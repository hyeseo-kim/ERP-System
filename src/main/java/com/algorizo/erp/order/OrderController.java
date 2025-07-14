package com.algorizo.erp.order;

import java.io.IOException;
import java.io.OutputStream;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import com.algorizo.erp.company.CompanyDTO;
import com.algorizo.erp.company.CompanyService;
import com.algorizo.erp.product.ProductDTO;
import com.algorizo.erp.product.ProductService;
import com.algorizo.erp.register.dto.MemberDTO;
import com.algorizo.erp.register.service.MemberService;
import com.algorizo.erp.stock.stockDTO;
import com.algorizo.erp.stock.stockService;

@Controller
public class OrderController {

	@Inject
	OrderService orderService;
	@Inject
	MemberService memberService;
	@Inject
	ProductService productService;
	@Inject
	CompanyService companyService;
	@Inject
	stockService stockService;
	
	
   
	
	@GetMapping(value = "order/list")
	public String list(Model model, HttpSession session) {
		if (session.getAttribute("m_id") == null) {
			return "redirect:/"; // ✅ 세션 없으면 로그인 페이지로 리다이렉트
		}

		List<OrderDTO> list = orderService.getAllOrders();
		System.out.println("Order List: " + list);
		model.addAttribute("list", list);

		return "order/orderList";
	}

	@GetMapping(value = "order/register")
	public String register(Model model, HttpSession session) throws Exception {
		if (session.getAttribute("m_id") == null) {
			return "redirect:/"; // ✅ 세션 없으면 로그인 페이지로 리다이렉트
		}

		
		
		
		// 현재 로그인한 사용자 정보 가져오기
		String m_id = (String) session.getAttribute("m_id");
		MemberDTO member = memberService.selectMember(m_id); // memberService에 이 메소드 필요
	
		
		List<OrderDTO> list = orderService.getAllOrders();
		List<ProductDTO> productList = productService.productlist();
		List<CompanyDTO> companyList = companyService.companylist();
		
		
		model.addAttribute("list", list);
		model.addAttribute("productList", productList);
		model.addAttribute("companyList", companyList);
		
		
		String nextOrderCode = orderService.generateNextOrderCode();
		model.addAttribute("nextOrderCode", nextOrderCode);
		model.addAttribute("member", member);
		
		
		
		return "order/orderRegister";
	}

	@PostMapping(value = "order/register")
	public String register(@ModelAttribute OrderDTO orderDTO, HttpSession session) {
		if (session.getAttribute("m_id") == null) {
			return "redirect:/"; // ✅ 세션 없으면 로그인 페이지로 리다이렉트
			
		}
		
		orderDTO.setMember_m_id((String) session.getAttribute("m_id"));

	 	orderService.register(orderDTO);
	 
		return "redirect:/order/list";
	}

	@GetMapping(value = "order/detail")
	public String detail(@RequestParam("o_code") String o_code, Model model) {

		OrderDTO order = orderService.getOrderDetail(o_code);

		model.addAttribute("order", order);

		return "order/orderDetail";
	}

	@GetMapping(value = "order/update")
	public String update(@RequestParam("o_code") String o_code, Model model) {
		OrderDTO order = orderService.getOrderDetail(o_code);

		model.addAttribute("order", order);
		
		List<CompanyDTO> companyList = companyService.companylist();
		model.addAttribute("companyList", companyList);

		return "order/orderUpdate";
	}

	@PostMapping(value = "order/update")
	public String update(@RequestParam Map<String, Object> map, Model model) {

		orderService.updateOrder(map);
		List<CompanyDTO> companyList = companyService.companylist();
		model.addAttribute("companyList", companyList);

		return "redirect:/order/detail?o_code=" + map.get("o_code");
	}

	@GetMapping(value = "order/delete")
	public String delete(@RequestParam("o_code") String o_code) {

		orderService.deleteOrder(o_code);

		return "redirect:/order/list";
	}

}
