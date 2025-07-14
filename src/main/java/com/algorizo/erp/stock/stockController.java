package com.algorizo.erp.stock;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.algorizo.erp.company.CompanyDTO;
import com.algorizo.erp.company.CompanyService;
import com.algorizo.erp.inbound.inboundDTO;
import com.algorizo.erp.inbound.inboundService;
import com.algorizo.erp.outbound.outboundDTO;
import com.algorizo.erp.outbound.outboundService;
import com.algorizo.erp.product.ProductDTO;
import com.algorizo.erp.product.ProductService;
import com.algorizo.erp.register.dto.MemberDTO;
import com.algorizo.erp.register.service.MemberService;

@Controller
public class stockController {
	
	int currentquantity;

	private static final Logger logger = LoggerFactory.getLogger(stockController.class);

	@Autowired
	private stockService stockservice;

	@Autowired
	private ProductService productservice;

	//재고 전체 조회
	@GetMapping(value = "/stock/stocklist")
	public String list(Model model, HttpSession session,@ModelAttribute stockDTO stockdto) throws Exception {
		if (session.getAttribute("m_id") == null) {
			return "redirect:/"; //
		}
		List<stockDTO> list = stockservice.list();
		List<StockSummaryDTO> summary = stockservice.summary();
		for (stockDTO dto : list) {
		    if (dto.getProduct_p_id() == stockdto.getProduct_p_id()) { 
		        if (dto.getS_quantity() > 50) {
		            dto.setS_status("재고 충족"); 
		        } else if (dto.getS_quantity() > 0) {
		            dto.setS_status("재고 부족");
		        } else if (dto.getS_quantity() == 0) {
		            dto.setS_status("재고 없음"); 
		        }
		        stockservice.updateStockStatus(dto); 
		    }
		}

		model.addAttribute("list", list);
		model.addAttribute("summary", summary);
		
		return "stock/stocklist";
	}

	//재고 상세보기
	@GetMapping(value = "/stock/stockdetail")
	public String detail(@RequestParam int s_id, Model model) throws Exception {
		stockDTO dto = stockservice.detail(s_id);
		System.out.println("s_controller" + dto);
		model.addAttribute("detail", dto);

		return "stock/stockdetail";
	}

}
