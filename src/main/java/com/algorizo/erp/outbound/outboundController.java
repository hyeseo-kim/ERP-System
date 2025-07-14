package com.algorizo.erp.outbound;

import java.util.HashMap;
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
import co.algorizo.erp.inbound.inboundDTO;
import co.algorizo.erp.inbound.inboundService;
import com.algorizo.erp.outinspection.OutInspectionDTO;
import com.algorizo.erp.outinspection.OutInspectionService;
import co.algorizo.erp.product.ProductDTO;
import co.algorizo.erp.product.ProductService;
import com.algorizo.erp.register.dto.MemberDTO;
import com.algorizo.erp.register.service.MemberService;
import co.algorizo.erp.stock.stockDTO;
import co.algorizo.erp.stock.stockService;

@Controller
public class outboundController {

	private static final Logger logger = LoggerFactory.getLogger(outboundController.class);

	@Autowired
	private outboundService outboundservice;
	@Autowired
	private ProductService productservice;
	@Autowired
	private MemberService memberservice;
	@Autowired
	private CompanyService companyservice;
	@Autowired
	private stockService stockservice;
	@Autowired
	private OutInspectionService outspectionservice;

	//출고 전체 조회
	@GetMapping(value = "/outbound/outboundlist")
	public String list(Model model, HttpSession session) throws Exception {
		if (session.getAttribute("m_id") == null) {
			return "redirect:/"; //
		}
		List<outboundDTO> list = outboundservice.list();

		model.addAttribute("list", list);
		return "/outbound/outboundlist";

	}

	//출고 상세보기
	@GetMapping(value = "/outbound/outbounddetail")
	public String detail(@RequestParam("out_id") int out_id, Model model) throws Exception {
		System.out.println(out_id);
		List<outboundDTO> read = outboundservice.detail(out_id);
		System.out.println(read);

		model.addAttribute("detail", read);
		return "outbound/outbounddetail";

	}

	//출고 등록폼
	@GetMapping(value = "/outbound/outboundregister")
	public String registerform(HttpSession session, Model model) {
		if (session.getAttribute("m_id") == null) {
			return "redirect:/"; //
		}
		List<ProductDTO> product = productservice.productlist();
		List<MemberDTO> member = memberservice.memberList();
		List<CompanyDTO> company = companyservice.companylist();
		model.addAttribute("product", product);
		model.addAttribute("member", member);
		model.addAttribute("company", company);
		model.addAttribute("out_status", "출고 대기");
		return "outbound/outboundregister";
	}

	//출고 등록
	@PostMapping(value = "/outbound/outboundregister")
	public String register(@ModelAttribute outboundDTO outbounddto, HttpSession session,RedirectAttributes redirect) throws Exception {
		if (session.getAttribute("m_id") == null) {
			return "redirect:/"; //
		}
		 boolean canProceed = outboundservice.exceed(outbounddto.getProduct_p_id(), outbounddto.getOut_quantity());
		 System.out.println("outquantity"+outbounddto.getOut_quantity());
		 System.out.println("productid"+outbounddto.getProduct_p_id());

		    if (!canProceed) {
		        // 출고가 불가능한 경우 에러 메시지 추가
		        redirect.addFlashAttribute("errorMessage", "재고 수량보다 출고수량이 많아 출고 등록이 불가합니다.");
		        return "redirect:/outbound/outboundregister"; // 다시 등록 페이지로 리다이렉트
		    }
		    outboundservice.register(outbounddto);
		System.out.println(outbounddto);
		return "redirect:/outbound/outboundlist";
	}
	
	//출고 수정폼
	@GetMapping(value = "/outbound/outboundupdate")
	public String updateform(@ModelAttribute outboundDTO outbounddto, Model model) throws Exception {
		List<outboundDTO> dto = outboundservice.detail(outbounddto.getOut_id());
		model.addAttribute("up", dto);
		return "outbound/outboundupdate";
	}
	
	//출고 수정
	@PostMapping(value = "/outbound/outboundupdate")
	public String update(@ModelAttribute outboundDTO outbounddto, RedirectAttributes redirect) throws Exception {
		if (outbounddto.getOut_status() == null || outbounddto.getOut_status().isEmpty()) {
	        outbounddto.setOut_status("출고 대기"); // 기본값 설정
	    }
	    System.out.println("수정된 로직: " + outbounddto);
	    System.out.println("productid" + outbounddto.getProduct_p_id());

	    // 재고 수량 검증 로직
	    boolean canProceed = outboundservice.exceed(outbounddto.getProduct_p_id(), outbounddto.getOut_quantity());
	    if (!canProceed) {
	        // 에러 메시지 추가
	        redirect.addFlashAttribute("errorMessage", "출고 수량이 재고 수량보다 많아 출고 수정이 불가능합니다.");
	        return "redirect:/outbound/outboundupdate?out_id=" + outbounddto.getOut_id(); // 수정 페이지로 리다이렉트
	    }

	    // 출고 수정
	    outboundservice.update(outbounddto);
	    return "redirect:/outbound/outbounddetail?out_id=" + outbounddto.getOut_id();
	}


	
	//출고 삭제
	@PostMapping(value = "/outbound/outbounddelete")
	public String delete(@RequestParam int out_id) throws Exception {
		int result = outboundservice.delete(out_id);
		if (result > 0) {
			return "redirect:/outbound/outboundlist";
		}
		return "redirect:/outbound/outboundlist";
	}
	
	//출고(상태/재고 차감)
	@PostMapping(value = "/outbound/confirm")
	@ResponseBody
	public ResponseEntity<Map<String, String>> confirmOutbound(@RequestBody Map<String, Object> payload) {
	    Map<String, String> response = new HashMap<>();

	    try {
	        // in_id 값이 제대로 전달되었는지 확인
	        if (!payload.containsKey("out_id") || payload.get("out_id") == null
	                || String.valueOf(payload.get("out_id")).trim().isEmpty()) {
	            response.put("status", "error");
	            response.put("message", "출고 ID가 유효하지 않습니다.");
	            return ResponseEntity.badRequest().body(response);
	        }

	        String out_id = String.valueOf(payload.get("out_id"));
	        String oi_id = String.valueOf(payload.get("oi_id"));
	        String s_id = String.valueOf(payload.get("s_id"));

	        // ID 유효성 검사
	        try {
	            Integer.parseInt(out_id);
	        } catch (NumberFormatException e) {
	            response.put("status", "error");
	            response.put("message", "유효하지 않은 출고 ID입니다.");
	            return ResponseEntity.badRequest().body(response);
	        }

	        Integer outinspectionId = Integer.valueOf(oi_id);
	        Integer stockid = Integer.valueOf(s_id);

	        // 바로 확정 처리
	        if (outinspectionId == 0) {
	            outboundservice.updateOutboundStatus(out_id, "출고 완료");
	            response.put("status", "success");
	            response.put("message", "출고가 완료되었습니다.");
	            return ResponseEntity.ok(response);
	        }

	        stockDTO stock = stockservice.detail(stockid);
	        OutInspectionDTO outinspection = outspectionservice.detail(outinspectionId);

	        int stockQuantity = stock.getS_quantity();
	        int outinspectionQuantity = outinspection.getOi_quantity();

	        // 재고 수량 확인
	        if (outinspectionQuantity > stockQuantity) {
	            response.put("status", "error");
	            response.put("message", "재고 수보다 출고 수가 많습니다.");
	            return ResponseEntity.badRequest().body(response);
	        }

	        // 정상 처리
	        stock.setS_quantity(stockQuantity - outinspectionQuantity);
	        outboundservice.stockupdate(stock.getS_quantity(), stockid);
	        outboundservice.updateOutboundStatus(out_id, "출고 완료");

	        response.put("status", "success");
	        response.put("message", "출고가 완료되었습니다.");
	        return ResponseEntity.ok(response);

	    } catch (Exception e) {
	        response.put("status", "error");
	        response.put("message", "처리 중 오류가 발생했습니다.");
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
	    }
	}

}
