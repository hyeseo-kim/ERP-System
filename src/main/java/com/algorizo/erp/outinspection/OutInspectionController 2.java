package com.algorizo.erp.outinspection;

import java.util.List;

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
import co.algorizo.erp.outbound.outboundDTO;
import co.algorizo.erp.outbound.outboundService;
import com.algorizo.erp.procurement_plan.DTO.PlanDetailDTO;

@Controller
@RequestMapping(value = "/outInspection")
public class OutInspectionController {
	@Autowired
	private OutInspectionService outInspectionService;
	@Autowired
	private outboundService outboundService;
	
	@GetMapping(value = "/list")
	public ModelAndView listPage(HttpSession session) {
		ModelAndView mav = new ModelAndView();
		if (session.getAttribute("m_id") == null) { 
			mav.setViewName("redirect:/");
	        return mav;
	    }
		
		mav.setViewName("outInspection/outInspectionList");
		return mav;
	}
	
	@GetMapping(value = "/listData")
	public ResponseEntity<List<OutInspectionDTO>> list() {
		List<OutInspectionDTO> list = outInspectionService.list();
		
		return ResponseEntity.ok(list);
	}
	
	@GetMapping(value = "/detail")
	public ModelAndView detailPage(@RequestParam int oi_id) {
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("oi_id", oi_id);
		mav.setViewName("outInspection/outInspectionDetail");
		return mav;
	}
	
	@GetMapping(value = "/detailData")
	public ResponseEntity<OutInspectionDTO> detail(@RequestParam int oi_id) {
		OutInspectionDTO outInspectionDTO = outInspectionService.detail(oi_id);
		return ResponseEntity.ok(outInspectionDTO);
	}
	
	@GetMapping(value = "/register")
	public String registerForm(HttpSession session) {
		if (session.getAttribute("m_id") == null) { 
	        return "redirect:/";
	    }
		return "outInspection/outInspectionRegister";
	}
	
	@PostMapping(value = "/register")
	public ResponseEntity<String> register(@RequestBody OutInspectionDTO outInspectionDTO) {
		outInspectionService.register(outInspectionDTO);
		
		return ResponseEntity.ok("등록완료!");
	}
	
	@GetMapping(value = "/update")
	public ModelAndView updateForm(@RequestParam int oi_id) {
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("oi_id", oi_id);
		mav.setViewName("outInspection/outInspectionUpdate");
		return mav;
	}
	
	@PostMapping(value = "/update")
	public ResponseEntity<String> update(@RequestBody OutInspectionDTO outInspectionDTO) {
		outInspectionService.update(outInspectionDTO);
		
		return ResponseEntity.ok("수정완료!");
	}
	@PostMapping(value = "/delete")
	public ResponseEntity<String> delete(@RequestParam int oi_id) {
		
		outInspectionService.delete(oi_id);
		
		return ResponseEntity.ok("삭제완료!");
	}
	
	@GetMapping(value = "/code")
	@ResponseBody
	public String registerCode() {
		String newCode = outInspectionService.registerCode();
		
		return newCode;
	}
	
	@GetMapping(value = "/outboundList")
	@ResponseBody
	public List<outboundDTO> inboundList() {
		
		return outInspectionService.outboundList();
	}
	
	@GetMapping(value = "/outboundDetail")
	@ResponseBody
	public List<outboundDTO> outboundDetail(@RequestParam int out_id) throws Exception{
		return outboundService.detail(out_id);
	}
	
	@GetMapping(value = "/defectReason")
	@ResponseBody
	public List<DefectReasonDTO> defectReasonList(){
		
		return outInspectionService.defectReasonList();
	}
}
