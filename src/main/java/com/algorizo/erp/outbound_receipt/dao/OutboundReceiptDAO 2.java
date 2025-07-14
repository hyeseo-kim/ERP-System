package com.algorizo.erp.outbound_receipt.dao;

import java.util.List;

import co.algorizo.erp.outbound.outboundDTO;
import com.algorizo.erp.outbound_receipt.dto.OutboundReceiptDTO;

public interface OutboundReceiptDAO {
	
//	출고 거래명세서 조회
	public List<OutboundReceiptDTO> listAllOutboundReceipt() throws Exception;
	
//	출고 거래명세서 상세 조회
	public OutboundReceiptDTO selectOneOutboundReceipt(int outre_id) throws Exception;
	
//	출고 거래명세서 등록
	public void insertOutboundReceipt(OutboundReceiptDTO outboundReceipt) throws Exception;
	
//	출고 번호로 가져오기
	public outboundDTO getOutboundById(int out_id) throws Exception;
	
}
