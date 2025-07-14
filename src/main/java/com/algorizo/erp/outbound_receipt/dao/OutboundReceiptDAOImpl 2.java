package com.algorizo.erp.outbound_receipt.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.algorizo.erp.outbound.outboundDTO;
import com.algorizo.erp.outbound_receipt.dto.OutboundReceiptDTO;

@Repository
public class OutboundReceiptDAOImpl implements OutboundReceiptDAO{
	
	private final static String NAMESPACE = "co.algorizo.erp.outboundReceiptMapper";
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<OutboundReceiptDTO> listAllOutboundReceipt() throws Exception {
		return sqlSession.selectList(NAMESPACE+".selectAllOutboundReceipt");
	}

	@Override
	public OutboundReceiptDTO selectOneOutboundReceipt(int outre_id) throws Exception {
		return sqlSession.selectOne(NAMESPACE+".selectOneOutboundReceipt", outre_id);
	}

	@Override
	public void insertOutboundReceipt(OutboundReceiptDTO outboundReceipt) throws Exception {
		sqlSession.insert(NAMESPACE+".insertOutboundReceipt", outboundReceipt);
	}

	@Override
	public outboundDTO getOutboundById(int out_id) throws Exception {
		return sqlSession.selectOne(NAMESPACE+".getOutboundById", out_id);
	}

}
