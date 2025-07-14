package com.algorizo.erp.inbound_receipt.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.algorizo.erp.inbound.inboundDTO;
import com.algorizo.erp.inbound_receipt.dto.InboundReceiptDTO;

@Repository
public class InboundReceiptDAOImpl implements InboundReceiptDAO{

	private static final String NAMESPACE = "co.algorizo.erp.inboundReceiptMapper";
	
	@Autowired
	SqlSession sqlSession;
	
	@Override
	public List<InboundReceiptDTO> listAllInboundReceipt() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(NAMESPACE+".selectAllInboundReceipt");
	}

	@Override
	public void insertInboundReceipt(InboundReceiptDTO inboundReceipt) throws Exception {
		sqlSession.insert(NAMESPACE+".insertInboundReceipt", inboundReceipt);
		
	}

	@Override
	public InboundReceiptDTO selectOneInboundReceipt(int inre_id) throws Exception {
		return sqlSession.selectOne(NAMESPACE+".selectOneInboundReceipt", inre_id);
	}

	@Override
	public inboundDTO getInboundById(int in_id) throws Exception {
		return sqlSession.selectOne(NAMESPACE+".getInboundById", in_id);
	}

}
