package com.algorizo.erp.company;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.algorizo.erp.register.dto.MemberDTO;
import com.algorizo.erp.register.service.MemberService;


@Controller
public class CompanyController {
	
	@Autowired
	private SqlSession sqlsession;
	
	@Inject
	MemberService memberservice;
	
	@Autowired
	private CompanyService companyservice;
	
	@RequestMapping(value="/company/companylist", method = RequestMethod.GET)
	public String companylist(Model model, HttpSession session) {
		if (session.getAttribute("m_id") == null) { 
	        return "redirect:/";  // ✅ 세션 없으면 로그인 페이지로 리다이렉트
	    }

		List<CompanyDTO> companylist = companyservice.companylist();
		model.addAttribute("companylist", companylist);
		return "company/companylist";
	}
	
	@RequestMapping(value="/company/companydetail", method = RequestMethod.GET)
	public String companydetail(@RequestParam("cp_id")int cp_id, Model model, HttpSession session) {
		if (session.getAttribute("m_id") == null) { 
	        return "redirect:/";  // ✅ 세션 없으면 로그인 페이지로 리다이렉트
	    }
		
		CompanyDTO company = companyservice.getcompany(cp_id);
		model.addAttribute("company", company);
		return "company/companydetail";
	}
	
	@RequestMapping(value = "/company/companyupdate", method = RequestMethod.GET)
	public String companyupdate(@RequestParam("cp_id") int cp_id, Model model) {
		CompanyDTO company = companyservice.getcompany(cp_id);
		model.addAttribute("company",company);
		return "company/companyupdate";
	}
	
	@RequestMapping(value = "/company/companyupdate", method = RequestMethod.POST)
	public String companyupdate(CompanyDTO company) {
		companyservice.companyupdate(company);
		return "redirect:/company/companylist";
	}
	
	@RequestMapping(value="/company/companyinsert", method = RequestMethod.GET)
	public String companyinsert(HttpSession session) {
		
		if (session.getAttribute("m_id") == null) { 
	        return "redirect:/";  // ✅ 세션 없으면 로그인 페이지로 리다이렉트
	    }
		
		return "company/companyinsert";
	}
	
	@RequestMapping(value="/company/companyinsert", method = RequestMethod.POST)
	public String companyinsert(@ModelAttribute CompanyDTO companyDTO, HttpSession session) {
		if (session.getAttribute("m_id") == null) { 
	        return "redirect:/";  // ✅ 세션 없으면 로그인 페이지로 리다이렉트
	    }
		
		String member_m_id = (String) session.getAttribute("m_id");
		MemberDTO member = memberservice.selectMember(member_m_id);
		companyDTO.setMember_m_id(member_m_id);
		companyDTO.setM_name(member.getM_name());
		
		companyservice.companyinsert(companyDTO);
		return "redirect:/company/companylist";
	}
	
	@RequestMapping(value="/company/companydelete", method = RequestMethod.GET)
	public String companydelete(@RequestParam("cp_id") int cp_id) {
		companyservice.companydelete(cp_id);
		return "redirect:/company/companylist";
	}
	
}
