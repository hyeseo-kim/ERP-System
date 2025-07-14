package com.algorizo.erp.outbound_receipt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.algorizo.erp.outbound.outboundDTO;
import co.algorizo.erp.outbound_receipt.dao.OutboundReceiptDAO;
import co.algorizo.erp.outbound_receipt.dto.OutboundReceiptDTO;

@Service
public class OutboundReceiptServiceImpl implements OutboundReceiptService{

	@Autowired
	private OutboundReceiptDAO dao;
	
	@Override
	public List<OutboundReceiptDTO> listAllOutboundReceipt() throws Exception {
		return dao.listAllOutboundReceipt();
	}

	@Override
	public OutboundReceiptDTO selectOneOutboundReceipt(int outre_id) throws Exception {
		return dao.selectOneOutboundReceipt(outre_id);
	}

	@Override
	public void insertOutboundReceipt(OutboundReceiptDTO outboundReceipt) throws Exception {
		dao.insertOutboundReceipt(outboundReceipt);
	}

	@Override
	public outboundDTO getOutboundById(int out_id) throws Exception {
		return dao.getOutboundById(out_id);
	}
	
}
