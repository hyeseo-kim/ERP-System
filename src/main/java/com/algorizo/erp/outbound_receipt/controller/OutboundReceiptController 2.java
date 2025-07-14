package com.algorizo.erp.outbound_receipt.controller;

import java.util.List;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import co.algorizo.erp.outbound.outboundDTO;
import co.algorizo.erp.outbound_receipt.dto.OutboundReceiptDTO;
import co.algorizo.erp.outbound_receipt.service.OutboundReceiptService;

@Controller
public class OutboundReceiptController {
    private static final Logger log = LoggerFactory.getLogger(OutboundReceiptController.class);
    
    @Autowired
    private OutboundReceiptService obrService;
    
    @GetMapping(value="outboundReceipt/listAllOutboundReceipt")
    public String listAllOutboundReceipt(Model model, HttpSession session) {
        try {
            log.info("출고거래명세서 전체 조회");
            if(session.getAttribute("m_id") == null) {
                return "redirect:/";
            }
            List<OutboundReceiptDTO> obrList = obrService.listAllOutboundReceipt();
            model.addAttribute("obrList", obrList);
            return "outboundReceipt/outboundReceiptList";
        } catch (Exception e) {
            log.error("출고거래명세서 전체 조회 중 오류 발생", e);
            return "redirect:/outboundReceipt/outboundReceiptError";
        }
    }

 // 선택조회
    @GetMapping(value="outboundReceipt/selectOneOutboundReceipt")
    public String selectOneOutboundReceipt(@RequestParam("outre_id") int outre_id, Model model) throws Exception {
        log.info("출고거래명세서 상세조회 outre_id : " + outre_id);
        
        // 데이터 조회
        OutboundReceiptDTO orDTO = obrService.selectOneOutboundReceipt(outre_id);
        
        // 데이터가 없을 경우 error-500으로 리디렉트
        if (orDTO == null) {
            log.error("출고거래명세서 데이터가 존재하지 않음! outre_id: " + outre_id);
            return "redirect:/outboundReceipt/outboundReceiptError";
        }
        
        model.addAttribute("orDTO", orDTO);
        return "outboundReceipt/outboundReceiptDetail";
    }
    
    @GetMapping(value="outboundReceipt/insertOutboundReceipt")
    public String insertOutboundReceiptForm(@RequestParam("out_id") int out_id, Model model) {
        try {
            log.info("출고 번호로 거래명세서 생성 폼 요청, out_id = " + out_id);
            outboundDTO outboundData = obrService.getOutboundById(out_id);
            if (outboundData == null) {
                log.error("출고 데이터가 존재하지 않음! out_id: " + out_id);
                return "redirect:/error-500";
            }
            OutboundReceiptDTO outboundReceipt = new OutboundReceiptDTO();
            outboundReceipt.setOutbound_out_id(outboundData.getOut_id());
            outboundReceipt.setP_name(outboundData.getProduct().getP_name());
            outboundReceipt.setP_code(outboundData.getProduct().getP_code());
            outboundReceipt.setOut_quantity(outboundData.getOut_quantity());
            outboundReceipt.setCp_name(outboundData.getCompany().getCp_name());
            outboundReceipt.setCp_manager(outboundData.getCompany().getCp_manager());
            outboundReceipt.setCp_fax(outboundData.getCompany().getCp_fax());
            outboundReceipt.setOutre_totalprice(outboundData.getOut_quantity() * outboundData.getProduct().getP_price());
            model.addAttribute("outboundReceipt", outboundReceipt);
            return "outboundReceipt/insertOutboundReceipt";
        } catch (Exception e) {
            log.error("출고 데이터 조회 중 오류 발생: out_id=" + out_id, e);
            return "redirect:/error-500";
        }
    }
    
    @PostMapping(value="outboundReceipt/insertOutboundReceipt")
    public String insertOutboundReceipt(@RequestParam("out_id") int out_id) {
        try {
            outboundDTO outboundData = obrService.getOutboundById(out_id);
            if (outboundData == null) {
                log.error("출고 데이터가 존재하지 않음! out_id: " + out_id);
                return "redirect:/error-500";
            }
            OutboundReceiptDTO orDTO = new OutboundReceiptDTO();
            orDTO.setOutbound_out_id(outboundData.getOut_id());
            orDTO.setP_name(outboundData.getProduct().getP_name());
            orDTO.setP_code(outboundData.getProduct().getP_code());
            orDTO.setOut_quantity(outboundData.getOut_quantity());
            orDTO.setCp_name(outboundData.getCompany().getCp_name());
            orDTO.setCp_manager(outboundData.getCompany().getCp_manager());
            orDTO.setCp_fax(outboundData.getCompany().getCp_fax());
            orDTO.setOutre_totalprice(outboundData.getOut_quantity() * outboundData.getProduct().getP_price());
            obrService.insertOutboundReceipt(orDTO);
            return "redirect:/outboundReceipt/listAllOutboundReceipt";
        } catch (Exception e) {
            log.error("출고거래명세서 등록 중 오류 발생: out_id=" + out_id, e);
            return "redirect:/error-500";
        }
    }
    
//  에러페이지 작성
	  @GetMapping(value="outboundReceipt/outboundReceiptError")
	  public String outboundReceiptErrorPage() {
	  	log.info("Error");
	  	return "outboundReceipt/outboundReceiptError";
	  }
}