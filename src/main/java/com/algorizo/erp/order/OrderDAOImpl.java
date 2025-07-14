package com.algorizo.erp.order;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;


@Repository
public class OrderDAOImpl implements OrderDAO{

	@Inject
	private SqlSession sqlSession;
	
	private static final String nameSpace = "co.algorizo.erp.orderMapper";
	
	
	@Override
	public List<OrderDTO> getAllOrders() {
		// TODO Auto-generated method stub
		return sqlSession.selectList(nameSpace + ".getAllOrders");
	}


	@Override
	public void register(OrderDTO orderDTO) {
		// TODO Auto-generated method stub
		sqlSession.insert(nameSpace + ".register", orderDTO);
	}


	@Override
	public OrderDTO getOrderDetail(String o_code) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(nameSpace + ".getOrderDetail", o_code);
	}


	@Override
	public void updateOrder(Map<String, Object> map) {
		// TODO Auto-generated method stub
		sqlSession.update(nameSpace + ".updateOrder", map);
	}


	


	@Override
	public String getLastOrderCode() {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(nameSpace + ".getLastOrderCode");
	}


	@Override
	public void deleteOrder(String o_code) {
		// TODO Auto-generated method stub
		sqlSession.update(nameSpace + ".deleteOrder", o_code);
	}




}
