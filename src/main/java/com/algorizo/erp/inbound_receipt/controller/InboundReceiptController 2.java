package com.algorizo.erp.inbound_receipt.controller;

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
import co.algorizo.erp.inbound.inboundDTO;
import co.algorizo.erp.inbound_receipt.dto.InboundReceiptDTO;
import co.algorizo.erp.inbound_receipt.service.InboundReceiptService;

@Controller
public class InboundReceiptController {
    private static final Logger log = LoggerFactory.getLogger(InboundReceiptController.class);

    @Autowired
    private InboundReceiptService irService;

    // 전체 조회
    @GetMapping(value="inboundReceipt/listAllInboundReceipt")
    public String listAllInboundReceipt(Model model, HttpSession session) {
        try {
            log.info("입고거래명세서 전체조회");
            if (session.getAttribute("m_id") == null) {
                return "redirect:/";
            }
            List<InboundReceiptDTO> irList = irService.listAllInboundReceipt();
            model.addAttribute("irList", irList);
            return "inboundReceipt/inboundReceiptList";
        } catch (Exception e) {
            log.error("입고거래명세서 전체조회 중 오류 발생", e);
            return "redirect:/inboundReceipt/inboundReceiptError";
        }
    }

    // 선택 조회
    @GetMapping(value="inboundReceipt/selectOneInboundReceipt")
    public String selectOneInboundReceipt(@RequestParam("inre_id") int inre_id, Model model) {
        try {
            log.info("거래명세서 상세 조회 : " + inre_id);
            InboundReceiptDTO irDTO = irService.selectOneInboundReceipt(inre_id);
            log.info("irDTO : " + irDTO.toString());
            model.addAttribute("irDTO", irDTO);
            return "inboundReceipt/inboundReceiptDetail";
        } catch (Exception e) {
            log.error("거래명세서 상세 조회 중 오류 발생: inre_id=" + inre_id, e);
            return "redirect:/inboundReceipt/inboundReceiptError";
        }
    }

    // 등록 폼 요청
    @GetMapping(value="inboundReceipt/insertInboundReceipt")
    public String insertInboundReceiptForm(@RequestParam("in_id") int in_id, Model model) {
        try {
            log.info("입고 번호로 거래명세서 생성 폼 요청 : " + in_id);

            // 입고 정보 조회
            inboundDTO inboundData = irService.getInboundById(in_id);
            if (inboundData == null) {
                log.error("입고 데이터가 존재하지 않음! in_id: " + in_id);
                return "redirect:/error-500";
            }

            // DTO 변환
            InboundReceiptDTO inboundReceipt = new InboundReceiptDTO();
            inboundReceipt.setInbound_in_id(inboundData.getIn_id());
            inboundReceipt.setP_name(inboundData.getProduct().getP_name());
            inboundReceipt.setP_code(inboundData.getProduct().getP_code());
            inboundReceipt.setIn_quantity(inboundData.getIn_quantity());
            inboundReceipt.setP_price(inboundData.getProduct().getP_price());
            inboundReceipt.setCp_name(inboundData.getCompany().getCp_name());
            inboundReceipt.setCp_manager(inboundData.getCompany().getCp_manager());
            inboundReceipt.setCp_fax(inboundData.getCompany().getCp_fax());
            inboundReceipt.setInre_totalprice(inboundData.getIn_quantity() * inboundData.getProduct().getP_price());

            model.addAttribute("inboundReceipt", inboundReceipt);
            return "inboundReceipt/insertInboundReceipt";
        } catch (Exception e) {
            log.error("입고 데이터 조회 중 오류 발생: in_id=" + in_id, e);
            return "redirect:/error-500";
        }
    }

    // 등록 처리
    @PostMapping("inboundReceipt/insertInboundReceipt")
    public String insertInboundReceipt(@RequestParam("in_id") int in_id) {
        try {
            // 입고 정보 조회
            inboundDTO inboundData = irService.getInboundById(in_id);
            if (inboundData == null) {
                log.error("입고 데이터가 존재하지 않음! in_id: " + in_id);
                return "redirect:/error-500";
            }

            // DTO 변환
            InboundReceiptDTO irDTO = new InboundReceiptDTO();
            irDTO.setInbound_in_id(in_id);
            irDTO.setP_name(inboundData.getProduct().getP_name());
            irDTO.setP_code(inboundData.getProduct().getP_code());
            irDTO.setIn_quantity(inboundData.getIn_quantity());
            irDTO.setCp_name(inboundData.getCompany().getCp_name());
            irDTO.setCp_manager(inboundData.getCompany().getCp_manager());
            irDTO.setCp_fax(inboundData.getCompany().getCp_fax());
            irDTO.setInre_totalprice(inboundData.getIn_quantity() * inboundData.getProduct().getP_price());

            log.info("irDTO 확인 : " + irDTO);

            // 거래명세서 등록
            irService.insertInboundReceipt(irDTO);
            return "redirect:/inboundReceipt/listAllInboundReceipt";
        } catch (Exception e) {
            log.error("입고거래명세서 등록 중 오류 발생: in_id=" + in_id, e);
            return "redirect:/error-500";
        }
    }
//    에러페이지 작성
    @GetMapping(value="inboundReceipt/inboundReceiptError")
    public String inboundReceiptErrorPage() {
    	log.info("Error");
    	return "inboundReceipt/inboundReceiptError";
    }
    
}
