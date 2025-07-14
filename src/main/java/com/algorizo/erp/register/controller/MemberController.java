package com.algorizo.erp.register.controller;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.inject.Inject;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import co.algorizo.erp.dept.dto.DeptDTO;
import co.algorizo.erp.dept.service.DeptService;
import co.algorizo.erp.register.dto.MemberDTO;
import co.algorizo.erp.register.service.MemberService;

@Controller
public class MemberController {
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	private MemberService service;
	
	@Autowired
	private DeptService deptService;
	
	
	// 회원가입
	@RequestMapping("/register")
	public String registerForm(Model model) {
		logger.info("register Form");
			
		model.addAttribute("member", new MemberDTO());
			
		return "register";
	}
	// 회원가입 처리
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String register(
	        @RequestParam("birth_year") String birthYear,
	        @RequestParam("birth_month") String birthMonth,
	        @RequestParam("birth_day") String birthDay,
	        @ModelAttribute("dto") MemberDTO dto,
	        @RequestParam String phone1,
	        @RequestParam String phone2,
	        @RequestParam String phone3,
	        @RequestParam("m_name") String m_name,
	        Model model
	) {
	    logger.info("register");
	    
//	    이름 2글자 이상
	    if (m_name.length() < 2) {
	        model.addAttribute("error", "이름은 2글자 이상 입력해야 합니다.");
	        model.addAttribute("dto", dto); // 입력값 유지
	        return "register";
	    }
	    
//	    이름 영어, 한글만 가능
	    if (!m_name.matches("^[가-힣a-zA-Z]+$")) {
	        model.addAttribute("error", "이름은 한글 또는 영문자만 입력 가능합니다.");
	        model.addAttribute("dto", dto);
	        return "register";
	    }

	    // YYMMDD 형식의 birth 생성
	    if (birthYear != null && !birthYear.isEmpty() &&
	        birthMonth != null && !birthMonth.isEmpty() &&
	        birthDay != null && !birthDay.isEmpty()) {
	        
	        String yearLastTwoDigits = birthYear.substring(birthYear.length() - 2);
	        String paddedMonth = String.format("%02d", Integer.parseInt(birthMonth));
	        String paddedDay = String.format("%02d", Integer.parseInt(birthDay));
	        
	        String fullBirth = yearLastTwoDigits + "-"+ paddedMonth + "-"+ paddedDay;
	        dto.setBirth(fullBirth);
	        
	        // 전화번호 설정
	        String m_pno = phone1 + "-" + phone2 + "-" + phone3;
	        dto.setM_pno(m_pno);  // DTO에 전화번호 설정
	        
	        System.out.println("서버에서 설정한 birth: " + fullBirth);
	    }
	    
	    // 전화번호 검증 (필요시 추가)
	    if (dto.getM_pno() == null || dto.getM_pno().trim().isEmpty()) {
	        throw new IllegalArgumentException("전화번호(m_pno)가 비어있습니다.");
	    }
	    
	    System.out.println("m_pno 값 : " + dto.getM_pno());

	    // 회원 등록
	    service.insertMember(dto);

	    logger.info("회원가입 성공" + dto);
	    logger.info("Submitted birth field in DTO: {}", dto.getBirth());

	    return "redirect:/";
	}
	
	// 사원 전체조회
	@GetMapping("/members")
	public String memberList(Model model, HttpSession session) {
		
		 if (session.getAttribute("m_id") == null) {
		        return "redirect:/";
		    }
		 logger.info("사원 전체조회");
		
		List<MemberDTO> memberList = service.memberList();
		model.addAttribute("memberList",memberList);
		
		return "member/members";
	}
	
	// 사원 detail
	@GetMapping("/members/memberDetail")
	public String membersDetail(@RequestParam("m_id") String m_id, Model model, HttpSession session) {
		logger.info("사원 상세 조회 m_id = " + m_id);
		
		 if (session.getAttribute("m_id") == null) {
		        return "redirect:/";
		    }
		
		MemberDTO member = service.memberDetail(m_id);
		if(member == null) {
			logger.info("존재하지 않는 회원입니다. m_id : " + m_id);
			return "redirect:/memberError";
		}
		
		model.addAttribute("member",member);
		
		
		return "member/memberDetail";
	}
	
	// 사원 delete
	@GetMapping(value="/members/deleteMember")
	public String deleteMember(@RequestParam("m_id") String m_id, HttpSession session) {
		logger.info("삭제, m_id = " + m_id );
		 if (session.getAttribute("m_id") == null) {
		        return "redirect:/";
		    }
		
		service.deleteMember(m_id);
		return "redirect:/members";
	}
	
	
	// 사원 수정 폼 이동
		@GetMapping(value="/members/updateMember")
		public String updateMember(@RequestParam("m_id") String m_id, Model model, HttpSession session) {
			logger.info("update page for m_id = " + m_id);
			 if (session.getAttribute("m_id") == null) {
			        return "redirect:/";
			    }
			
			MemberDTO member = service.selectMember(m_id);
			if(member == null) {
				model.addAttribute("error", "해당 사원을 찾을 수 없습니다.");
				return "member/memberError";
			}
			List<DeptDTO> dList = deptService.getDeptList();
			model.addAttribute("dList", dList);
			
			model.addAttribute("member",member);
			
			return "member/memberUpdate";
		}
		// 사원 수정 처리
		@PostMapping(value="/members/updateMember")
		public String updateMember(MultipartHttpServletRequest request,
				RedirectAttributes redirectAttributes, HttpSession session,
				@RequestParam(value="m_photo",required = false) MultipartFile file,
				@RequestParam(value="originPhoto",required = false) String originPhoto) {
			
			 if (session.getAttribute("m_id") == null) {
			        return "redirect:/";
			    }
			
			try {
				MemberDTO member = new MemberDTO();
		        member.setM_id(request.getParameter("m_id"));
		        member.setM_email(request.getParameter("m_email"));
		        member.setM_pno(request.getParameter("m_pno"));
		        member.setM_addr(request.getParameter("m_addr"));
		        member.setDept_d_id(Integer.parseInt(request.getParameter("dept_d_id")));
		        member.setRole("user");
		        
		        // 사진 저장 경로
		        String uploadDir = session.getServletContext().getRealPath("/resources/img/members");
		        File saveDir = new File(uploadDir);
		        if(!saveDir.exists()) {
		        	saveDir.mkdirs();
		        }
		        
		        
		        // 사진 업로드 처리
		        if (file != null && !file.isEmpty()) {
		            String filename = file.getOriginalFilename();
		            String uuid = UUID.randomUUID().toString();
		            String saveName = uuid + "_" + filename;
		            File dest = new File(uploadDir, saveName);
		            file.transferTo(dest);
		            
		            member.setM_photo(saveName);
		        } else {
		            member.setM_photo(originPhoto);
		        }

		        service.updateMember(member);
				redirectAttributes.addFlashAttribute("success", "사원 정보가 수정되었습니다.");
				return "redirect:/members/memberDetail?m_id=" + member.getM_id();
				
			} catch(Exception e){
				logger.error("Error!" + e.getMessage());
				redirectAttributes.addFlashAttribute("error", "사원 정보 수정에 실패했습니다.");
				return "redirect:/member/memberError";
			}
			
			
			
			
		}
//	에러페이지
	@GetMapping(value="/memberError")
	public String memberError() {
		return "member/memberError";
	}
	
	
}
