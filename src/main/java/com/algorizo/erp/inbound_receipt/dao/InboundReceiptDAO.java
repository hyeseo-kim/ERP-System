package com.algorizo.erp.inbound_receipt.dao;

import java.util.List;

import co.algorizo.erp.inbound.inboundDTO;
import com.algorizo.erp.inbound_receipt.dto.InboundReceiptDTO;

public interface InboundReceiptDAO {
//	입고 거래명세서 조회
	public List<InboundReceiptDTO> listAllInboundReceipt() throws Exception;
	
//	입고 거래명세서 등록
	public void insertInboundReceipt(InboundReceiptDTO inboundReceipt) throws Exception;
	
//	입고 거래명세서 선택 조회
	public InboundReceiptDTO selectOneInboundReceipt(int inre_id) throws Exception;
	
//	입고 번호로 가져오기
	public inboundDTO getInboundById(int in_id) throws Exception;
}
