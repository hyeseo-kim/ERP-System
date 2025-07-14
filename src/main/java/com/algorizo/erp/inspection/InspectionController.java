package com.algorizo.erp.inspection;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import co.algorizo.erp.inbound.inboundDTO;
import co.algorizo.erp.inbound.inboundService;
import co.algorizo.erp.inspection.DTO.DefectReasonDTO;
import co.algorizo.erp.inspection.DTO.InspectionDTO;

@Controller
@RequestMapping(value = "/inspection")
public class InspectionController {
	@Autowired
	private InspectionService inspectionService;
	@Autowired
	private inboundService inboundService;
	
//	검수 조회 페이지 이동
	@GetMapping(value = "/list")
	public ModelAndView listPage(HttpSession session) {
		ModelAndView mav = new ModelAndView();
		if (session.getAttribute("m_id") == null) { 
			mav.setViewName("redirect:/");
	        return mav;
	    }
		
		mav.setViewName("inspection/inspectionList");
		return mav;
	}
	
//	검수 조회
	@GetMapping(value = "/listData")
	public ResponseEntity<List<InspectionDTO>> list() {
		List<InspectionDTO> list = inspectionService.list();
		
		return ResponseEntity.ok(list);
	}
	
//	검수 상세보기 페이지 이동
	@GetMapping(value = "/detail")
	public ModelAndView detailPage(@RequestParam int i_id) {
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("i_id", i_id);
		mav.setViewName("inspection/inspectionDetail");
		return mav;
	}
	
//	검수 상세보기
	@GetMapping(value = "/detailData")
	public ResponseEntity<InspectionDTO> detail(@RequestParam int i_id) {
		InspectionDTO inspection = inspectionService.detail(i_id);
		return ResponseEntity.ok(inspection);
	}
	
//	검수 등록 폼 이동
	@GetMapping(value = "/register")
	public String registerForm(HttpSession session) {
		if (session.getAttribute("m_id") == null) { 
	        return "redirect:/";
	    }
		return "inspection/inspectionRegister";
	}
	
//	검수 등록
	@PostMapping(value = "/register")
	public ResponseEntity<String> register(@RequestBody InspectionDTO inspectionDTO) {
		inspectionService.register(inspectionDTO);
		
		return ResponseEntity.ok("등록완료!");
	}
	
//	검수 수정 폼 이동
	@GetMapping(value = "/update")
	public ModelAndView updateForm(@RequestParam int i_id) {
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("i_id", i_id);
		mav.setViewName("inspection/inspectionUpdate");
		return mav;
	}
	
//	검수 수정
	@PostMapping(value = "/update")
	public ResponseEntity<String> update(@RequestBody InspectionDTO inspectionDTO) {
		inspectionService.update(inspectionDTO);
		
		return ResponseEntity.ok("수정완료!");
	}
//	검수 삭제
	@PostMapping(value = "/delete")
	public ResponseEntity<String> delete(@RequestParam int i_id) {
		
		inspectionService.delete(i_id);
		
		return ResponseEntity.ok("삭제완료!");
	}
	
//	코드 불러오기
	@GetMapping(value = "/code")
	@ResponseBody
	public String registerCode() {
		String newCode = inspectionService.registerCode();
		
		return newCode;
	}
	
//	입고 리스트 불러오기
	@GetMapping(value = "/inboundList")
	@ResponseBody
	public List<inboundDTO> inboundList() {
		
		return inspectionService.inboudList();
	}
	
//	입고 상세보기
	@GetMapping(value = "/inboundDetail")
	@ResponseBody
	public List<inboundDTO> inboundDetail(@RequestParam int in_id) throws Exception{
		return inboundService.detail(in_id);
	}
	
//	불량 사유 리스트
	@GetMapping(value = "/defectReason")
	@ResponseBody
	public List<DefectReasonDTO> defectReasonList(){
		
		return inspectionService.defectReasonList();
	}
	
//	월별 입고 불량 사유
	@GetMapping(value = "/reasonData")
	@ResponseBody
	public Map<String, Object> defectReasonData(@RequestParam String month){
		LocalDate start = LocalDate.parse(month + "-01");
	    LocalDate end = start.withDayOfMonth(start.lengthOfMonth());
		
		return inspectionService.defectReasonData(start , end);
	}
}
