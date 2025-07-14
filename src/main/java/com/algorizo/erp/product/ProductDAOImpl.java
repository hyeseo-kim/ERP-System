package com.algorizo.erp.product;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDAOImpl implements ProductDAO{

	@Autowired
	private SqlSession sqlsession;
	
	private static final String NAMESPACE = "co.algorizo.erp.productMapper";
	@Override
	public void productinsert(ProductDTO productDTO) {

	    sqlsession.insert(NAMESPACE + ".productinsert", productDTO);
	}

	@Override
	public List<ProductDTO> productlist() {
		return sqlsession.selectList(NAMESPACE + ".productlist");
	}
	@Override
	public ProductDTO getProductCode(String p_code) {
		return sqlsession.selectOne(NAMESPACE + ".getProductCode", p_code);
	}

	@Override
	public void productupdate(ProductDTO productDTO) {
		sqlsession.update(NAMESPACE + ".productupdate", productDTO);
	}

	@Override
	public void productdelete(int p_id) {
		sqlsession.delete(NAMESPACE + ".productdelete", p_id);
	}

	@Override
	public String getLastProductCode() {
		return sqlsession.selectOne(NAMESPACE + ".getLastOrderCode");
	}

//	@Override
//	public int getStockQuantity(int stock_s_id) {
//		return sqlsession.selectOne(NAMESPACE + ".getStockQuantity", stock_s_id);
//	}

}
