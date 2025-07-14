package com.algorizo.erp.outbound;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.algorizo.erp.company.CompanyDAO;
import co.algorizo.erp.inbound.inboundDAO;
import co.algorizo.erp.product.ProductDAO;
import com.algorizo.erp.register.dao.MemberDAO;

@Service
public class outboundServicelmpl implements outboundService {

	@Autowired
	private outboundDAO outbounddao;
	@Autowired
	private MemberDAO memberdao;
	@Autowired
	private ProductDAO productdao;
	@Autowired
	private CompanyDAO companydao;

	//출고 전체 조회
	@Override
	public List<outboundDTO> list() throws Exception {
		// TODO Auto-generated method stub
		return outbounddao.list();
	}

	//출고 상세보기
	@Override
	public List<outboundDTO> detail(int out_id) throws Exception {
		// TODO Auto-generated method stub
		return outbounddao.detail(out_id);
	}

	//출고 등록
	@Override
	public void register(outboundDTO dto) throws Exception {
		// TODO Auto-generated method stub
		outbounddao.register(dto);
		productdao.productlist();
		memberdao.memberList();
		companydao.companylist();
	}

	//출고 수정
	@Override
	public void update(outboundDTO dto) throws Exception {
		// TODO Auto-generated method stub
		outbounddao.update(dto);
	}

	//출고 삭제
	@Override
	public int delete(int out_id) throws Exception {
		// TODO Auto-generated method stub
		return outbounddao.delete(out_id);
	}

	//출고 상태 수정
	@Override
	public void updateOutboundStatus(String out_id, String out_status) throws Exception {
		// TODO Auto-generated method stub
		outbounddao.updateOutboundStatus(out_id, out_status);
	}

	//재고수량 수정
	@Override
	public void stockupdate(int s_quantity,int s_id) throws Exception {
		// TODO Auto-generated method stub
		outbounddao.stockupdate(s_quantity,s_id);
	}

	//재/출고수량 비교
	@Override
	public boolean exceed(int product_p_id,int out_quantity) throws Exception {
		System.out.println("servicelmpl exceed"+product_p_id);
		// TODO Auto-generated method stub
		int exceeds = outbounddao.exceed(product_p_id);
		System.out.println("현재 재고 수량" + exceeds);
		return exceeds >= out_quantity;
	}
}
