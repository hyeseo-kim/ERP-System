package com.algorizo.erp.inbound;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.algorizo.erp.company.CompanyDAO;
import com.algorizo.erp.product.ProductDAO;
import com.algorizo.erp.register.dao.MemberDAO;

@Service
public class inboundServicelmpl implements inboundService{
	
	@Autowired
	private inboundDAO inbounddao;
	@Autowired
	private ProductDAO productdao;
	@Autowired
	private MemberDAO memberdao;
	@Autowired
	private CompanyDAO companydao;

	//입고 전체 조회
	@Override
	public List<inboundDTO> list() throws Exception {
		// TODO Auto-generated method stub
		return inbounddao.list();
	}

	//입고 상세정보
	@Override
	public List<inboundDTO> detail(int in_id) throws Exception {
		// TODO Auto-generated method stub
		System.out.println(in_id);
		List<inboundDTO> dto = inbounddao.detail(in_id);
		System.out.println("service"+ dto);
		return dto;
	}
	
	//입고 등록
	@Override
	public void register(inboundDTO dto) throws Exception {
		// TODO Auto-generated method stub
		inbounddao.register(dto);
		productdao.productlist();
		companydao.companylist();
		memberdao.memberList();
	}

	//입고 수정
	@Override
	public void update(inboundDTO dto) throws Exception {
		// TODO Auto-generated method stub
		inbounddao.update(dto);
	}

	//입고 삭제
	@Override
	public int delete(int in_id) throws Exception {
		// TODO Auto-generated method stub
	return inbounddao.delete(in_id);
	}

	//입고 상태 수정
	@Override
	public void updateInboundStatus(String in_id, String in_status) throws Exception {
		// TODO Auto-generated method stub
		inbounddao.updateInboundStatus(in_id, in_status);
	}

	//재고수량 수정
	@Override
	public void stockupdate(int s_quantity,int s_id) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("i_idservice" + s_quantity);
		System.out.println("s_idservice" + s_id);
		inbounddao.stockupdate(s_quantity,s_id);
	}

}
