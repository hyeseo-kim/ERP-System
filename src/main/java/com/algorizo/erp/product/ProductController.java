package com.algorizo.erp.product;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Locale;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import co.algorizo.erp.company.CompanyDTO;
import co.algorizo.erp.company.CompanyService;
import co.algorizo.erp.dept.dto.DeptDTO;
import co.algorizo.erp.dept.service.DeptService;
import com.algorizo.erp.register.dto.MemberDTO;
import com.algorizo.erp.register.service.MemberService;
import co.algorizo.erp.stock.stockDTO;
import co.algorizo.erp.stock.stockService;

@Controller
public class ProductController {
	
	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
	
	@Autowired
	private ProductService productservice;
	
	@Inject
	MemberService memberservice;
	
	@Inject
	DeptService deptservice;
	
	@Inject
	CompanyService companyservice;
	
	@Inject
	stockService stockservice;
	
	@RequestMapping(value = "/product/productinsert", method = RequestMethod.GET)
	public String productinsert(Model model, HttpSession session) {
		
		if (session.getAttribute("m_id") == null) {
            return "redirect:/"; // Redirect to login page if not logged in
        }
		// 세션에서 m_id 가져오기
		String m_id = (String) session.getAttribute("m_id");
		MemberDTO member = memberservice.selectMember(m_id);
		model.addAttribute("member", member);  // 모델에 회원 정보 추가

		// 부서 정보 가져오기
		Integer d_id = (Integer) session.getAttribute("d_id");
		DeptDTO dept = deptservice.selectDept(d_id);
		model.addAttribute("dept", dept);  // 모델에 부서 정보 추가
		
		 String nextProductCode = productservice.generateNextProductCode();
		model.addAttribute("nextProductCode", nextProductCode);
		
		List<CompanyDTO> companylist = companyservice.companylist();
		model.addAttribute("companylist", companylist);
		
		// 상품 등록 폼 준비
		ProductDTO productDTO = new ProductDTO();
		productDTO.setDept(dept);  // 부서 정보 세팅
		model.addAttribute("product", productDTO);
		
		return "product/productinsert";
	}
	
	@RequestMapping(value = "/product/productinsert", method = RequestMethod.POST)
	public String productinsert(HttpServletRequest request, @ModelAttribute ProductDTO productDTO, HttpSession session, Model model) throws Exception{
		if (session.getAttribute("m_id") == null) { 
	        return "redirect:/";  // ✅ 세션 없으면 로그인 페이지로 리다이렉트
	    }

		// 로그인한 사용자의 ID와 이름을 상품에 추가
	    String member_m_id = (String) session.getAttribute("m_id");
	    MemberDTO member = memberservice.selectMember(member_m_id);
	    productDTO.setMember_m_id(member_m_id);
	    productDTO.setMember_m_name(member.getM_name()); // 로그인된 사용자의 이름 저장

	    // 부서 정보 가져오기
	    Integer d_id = (Integer) session.getAttribute("d_id");
	    DeptDTO dept = deptservice.selectDept(d_id);
	    productDTO.setDept(dept);
	    productDTO.setDept_d_id(d_id);
	    productDTO.setDept_team(dept.getTeam());
	    
	    Integer company_cp_id = productDTO.getCompany_cp_id();
	    CompanyDTO company = companyservice.getcompany(productDTO.getCompany_cp_id());
	    productDTO.setCompany_cp_id(company_cp_id);
	    productDTO.setCp_name(company.getCp_name());
	    productDTO.setCp_ctg(company.getCp_ctg());
	    
	    
		List<CompanyDTO> companylist = companyservice.companylist();
		model.addAttribute("companylist", companylist);
	    
		productservice.insertProductWithStock(productDTO);
	    
	    return "redirect:/product/productlist";
	}
	
	@RequestMapping(value= "/product/productlist", method = RequestMethod.GET)
	public String productlist(Model model, HttpSession session) {
		if (session.getAttribute("m_id") == null) { 
	        return "redirect:/";  // ✅ 세션 없으면 로그인 페이지로 리다이렉트
	    }
		
		List<ProductDTO> productlist = productservice.productlist();
		model.addAttribute("productlist", productlist);
		
		String m_id = (String) session.getAttribute("m_id");
		MemberDTO member = memberservice.selectMember(m_id);
		model.addAttribute("member", member);
		
		Integer d_id = (Integer) session.getAttribute("d_id");
		DeptDTO dept = deptservice.selectDept(d_id);
		model.addAttribute("dept", dept);
		
		List<CompanyDTO> companylist = companyservice.companylist();
		model.addAttribute("companylist", companylist);
		
		return "product/productlist";
	}
	
	@RequestMapping(value = "/product/productdetail", method = RequestMethod.GET)
	public String productdetail(@RequestParam("p_code") String p_code, Model model, HttpSession session) {
		ProductDTO product = productservice.getProductCode(p_code);
		model.addAttribute("product", product);

		// 로그인한 사용자 정보 가져오기
		String m_id = (String) session.getAttribute("m_id");
		MemberDTO member = memberservice.selectMember(m_id);
		model.addAttribute("member", member);

		Integer d_id = (Integer) session.getAttribute("d_id");
		DeptDTO dept = deptservice.selectDept(d_id);
		model.addAttribute("userDept", dept);  // 변경: dept -> userDept
		
		CompanyDTO company = companyservice.getcompany(product.getCompany_cp_id()); 
	    model.addAttribute("company", company);  // 회사 정보만 모델에 추가
	    
	    List<CompanyDTO> companylist = companyservice.companylist();
		model.addAttribute("companylist", companylist);
		
		return "product/productdetail";
	}
	
	
	@RequestMapping(value = "/product/productupdate", method = RequestMethod.GET)
	public String productupdate(@RequestParam("p_code") String p_code, HttpSession session, Model model) {
		ProductDTO product = productservice.getProductCode(p_code);
		model.addAttribute("product", product);
		
		// 세션에서 m_id 가져오기
		String m_id = (String) session.getAttribute("m_id");
		MemberDTO member = memberservice.selectMember(m_id);
		model.addAttribute("member", member);  // 모델에 회원 정보 추가
		
		String modifier_m_id = (String) session.getAttribute("m_id");
		product.setModifier_m_id(modifier_m_id);
		product.setModifier_m_name(member.getM_name());
		
		List<CompanyDTO> companylist = companyservice.companylist();
		model.addAttribute("companylist", companylist);
		    
		return "product/productupdate";
	}
	
	@RequestMapping(value = "/product/productupdate", method = RequestMethod.POST)
	public String productupdate(ProductDTO product, HttpSession session, Model model) {
		
		// 세션에서 m_id 가져오기
		String m_id = (String) session.getAttribute("m_id");
		MemberDTO member = memberservice.selectMember(m_id);
		model.addAttribute("member", member);  // 모델에 회원 정보 추가

		product.setModifier_m_id(m_id);
	    product.setModifier_m_name(member.getM_name());
	    
		// 부서 정보 가져오기
		Integer d_id = (Integer) session.getAttribute("d_id");
		DeptDTO dept = deptservice.selectDept(d_id);
		model.addAttribute("dept", dept);  // 모델에 부서 정보 추가
		
		CompanyDTO company = companyservice.getcompany(product.getCompany_cp_id());
	    product.setCp_name(company.getCp_name());
	    product.setCp_ctg(company.getCp_ctg());
		
		List<CompanyDTO> companylist = companyservice.companylist();
		model.addAttribute("companylist", companylist);
		
	    productservice.productupdate(product);
	    return "redirect:/product/productdetail?p_code=" + product.getP_code();
	}
	
	@RequestMapping(value = "/product/productdelete", method = RequestMethod.GET)
	public String productdelete(@RequestParam("p_id") int p_id) {
		productservice.productdelete(p_id);
		return "redirect:/product/productlist";
	}

}
