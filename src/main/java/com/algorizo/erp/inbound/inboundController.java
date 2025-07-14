package com.algorizo.erp.inbound;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import co.algorizo.erp.company.CompanyDTO;
import co.algorizo.erp.company.CompanyService;
import com.algorizo.erp.inspection.InspectionService;
import com.algorizo.erp.inspection.DTO.InspectionDTO;
import com.algorizo.erp.product.ProductDTO;
import com.algorizo.erp.product.ProductService;
import com.algorizo.erp.register.dto.MemberDTO;
import com.algorizo.erp.register.service.MemberService;
import co.algorizo.erp.stock.stockDTO;
import co.algorizo.erp.stock.stockService;

@Controller
public class inboundController {

	private static final Logger logger = LoggerFactory.getLogger(inboundController.class);

	@Autowired
	private inboundService inboundservice;
	@Autowired
	private MemberService memberservice;
	@Autowired
	private ProductService productservice;
	@Autowired
	private CompanyService companyservice;
	@Autowired
	private stockService stockservice;
	@Autowired
	private InspectionService inspectionservice;

	
	//입고 전체 조회
	@GetMapping(value = "/inbound/inboundlist")
	public String list(Model model, HttpSession session) throws Exception {
		if (session.getAttribute("m_id") == null) {
			return "redirect:/";
		}
		List<inboundDTO> list = inboundservice.list();
		System.out.println(list);
		model.addAttribute("list", list);
		return "inbound/inboundlist";
	}

	//입고 상세정보
	@GetMapping(value = "/inbound/inbounddetail")
	public String detail(@RequestParam("in_id") int in_id, Model model) throws Exception {
		try {
			List<inboundDTO> dto = inboundservice.detail(in_id);
			model.addAttribute("dto", dto);
			return "inbound/inbounddetail";
		} catch (NumberFormatException e) {
			return "redirect:/errorPage"; //
		}
	}

	//입고 등록폼
	@GetMapping(value = "/inbound/inboundregister")
	public String registerform(HttpSession session, Model model) throws Exception {
		if (session.getAttribute("m_id") == null || session.getAttribute("m_id").equals("")) {
			return "redirect:/"; //
		}
		List<ProductDTO> productList = productservice.productlist();
		List<CompanyDTO> companyList = companyservice.companylist();
		List<MemberDTO> memberList = memberservice.memberList();
		model.addAttribute("product", productList);
		model.addAttribute("company", companyList);
		model.addAttribute("member", memberList);
		model.addAttribute("in_status", "입고 대기");
		return "inbound/inboundregister";
	}

	//입고 등록
	@PostMapping(value = "/inbound/inboundregister")
	public String register(@ModelAttribute inboundDTO inbounddto, HttpSession session, RedirectAttributes redirect)
			throws Exception {
		if (session.getAttribute("m_id") == null) {
			return "redirect:/"; //
		}
		inboundservice.register(inbounddto);
		return "redirect:/inbound/inboundlist"; // 성공 시 목록 페이지로 이동
	}

	//입고 수정폼
	@GetMapping(value = "/inbound/inboundupdate")
	public String updateform(@RequestParam int in_id, Model model) throws Exception {
		List<inboundDTO> update = inboundservice.detail(in_id);
		model.addAttribute("up", update);
		return "inbound/inboundupdate";
	}

	//입고 수정
	@PostMapping(value = "/inbound/inboundupdate")
	public String update(@ModelAttribute inboundDTO inbounddto) throws Exception {
		if (inbounddto.getIn_status() == null || inbounddto.getIn_status().isEmpty()) {
	        inbounddto.setIn_status("입고 대기"); // 기본값 설정
	    }
		inboundservice.update(inbounddto);
		return "redirect:/inbound/inbounddetail?in_id=" + inbounddto.getIn_id();
	}

	//입고 삭제
	@PostMapping(value = "/inbound/inbounddelete")
	public String delete(@RequestParam int in_id, Model model) throws Exception {
		int result = inboundservice.delete(in_id);

		if (result > 0) {
			return "redirect:/inbound/inboundlist";
		}
		return "redirect:/inbound/inboundlist";
	}

	//입고 확정 및 재고수량 증가
	@PostMapping(value = "/inbound/confirm")
	@ResponseBody
	public ResponseEntity<?> confirmInbound(@RequestBody Map<String, Object> payload) {
		logger.debug("Request payload: {}", payload); // 요청 확인
		System.out.println("Request payload: " + payload); // 콘솔에 출력

		try {
			// in_id 값이 제대로 전달되었는지 확인
			if (!payload.containsKey("in_id") || payload.get("in_id") == null
					|| String.valueOf(payload.get("in_id")).trim().isEmpty()) {
				System.out.println("입고 ID가 유효하지 않습니다."); // 유효하지 않은 in_id 출력
				return ResponseEntity.badRequest().body("입고 ID가 유효하지 않습니다.");
			}

			String in_id = String.valueOf(payload.get("in_id"));
			String i_id = String.valueOf(payload.get("i_id"));
			String s_id = String.valueOf(payload.get("s_id"));


			// in_id가 숫자일 경우에만 처리
			try {
				Integer.parseInt(in_id); // 문자열을 정수로 변환할 수 있는지 체크
				System.out.println("in_id가 정수로 변환됨: " + in_id); // 정수로 변환된 in_id 출력
			} catch (NumberFormatException e) {
				System.out.println("유효하지 않은 입고 ID입니다."); // 유효하지 않은 ID 출력
				return ResponseEntity.badRequest().body("유효하지 않은 입고 ID입니다.");
			}
			//Integer로 형변환
			Integer inspectionId = Integer.valueOf(i_id);
			Integer stockid = Integer.valueOf(s_id);
			System.out.println("stockid"+stockid);
			
			 if (inspectionId == 0) { // i_id가 0일 경우 바로 확정 처리
		            System.out.println("i_id가 0이므로 바로 확정 처리");
		            inboundservice.updateInboundStatus(in_id, "입고 완료");
		            System.out.println("입고 상태 업데이트: 입고 완료, in_id = " + in_id);
		            return ResponseEntity.ok().build();
		    }
			 
			stockDTO stock = stockservice.detail(stockid);
			System.out.println("stockdetail" + stock); 
			InspectionDTO inspection = inspectionservice.detail(inspectionId);
			System.out.println("inspectiondetail" + inspection );
			
			stock.setS_quantity(stock.getS_quantity() + inspection.getI_quantity());
			// 입고 상태 업데이트 호출
			inboundservice.updateInboundStatus(in_id, "입고 완료");
			inboundservice.stockupdate(stock.getS_quantity(),stockid);
			
			return ResponseEntity.ok().build();
			
		} catch (Exception e) {
			logger.error("입고 상태 업데이트 중 오류 발생: {}", e.getMessage());
			System.out.println("입고 상태 업데이트 중 오류 발생: " + e.getMessage()); // 오류 메시지 출력
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("상태 업데이트 실패");
		}
	}

}
