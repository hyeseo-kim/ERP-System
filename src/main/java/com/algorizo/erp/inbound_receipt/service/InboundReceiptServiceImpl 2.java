package com.algorizo.erp.inbound_receipt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.algorizo.erp.inbound.inboundDTO;
import co.algorizo.erp.inbound_receipt.dao.InboundReceiptDAO;
import co.algorizo.erp.inbound_receipt.dto.InboundReceiptDTO;

@Service
public class InboundReceiptServiceImpl implements InboundReceiptService{

	@Autowired
	private InboundReceiptDAO dao;
	
	@Override
	public List<InboundReceiptDTO> listAllInboundReceipt() throws Exception {
		return dao.listAllInboundReceipt();
	}

	@Override
	public void insertInboundReceipt(InboundReceiptDTO inboundReceipt) throws Exception {
		dao.insertInboundReceipt(inboundReceipt);
	}

	@Override
	public InboundReceiptDTO selectOneInboundReceipt(int inre_id) throws Exception{
		return dao.selectOneInboundReceipt(inre_id);
	}

	@Override
	public inboundDTO getInboundById(int in_id) throws Exception {
		return dao.getInboundById(in_id);
	}

}
