package com.algorizo.erp.contract;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class ContractDAOImpl implements ContractDAO {

	@Inject
	private SqlSession sqlSession;
	
	private static final String nameSpace = "co.algorizo.erp.contractMapper";	
	
	@Override
	public List<ContractDTO> getAllContracts() {
		// TODO Auto-generated method stub
		return sqlSession.selectList(nameSpace + ".getAllContracts");
	}

	@Override
	public void register(Map<String, Object> map) {
		// TODO Auto-generated method stub
		sqlSession.insert(nameSpace + ".register", map);
	}

	@Override
	public ContractDTO getContractDetail(String cr_code) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(nameSpace + ".getContractDetail", cr_code);
	}

	@Override
	public void updateContract(Map<String, Object> map) {
		// TODO Auto-generated method stub
		sqlSession.update(nameSpace + ".updateContract", map);
	}

	@Override
	public void deleteContract(String cr_code) {
		// TODO Auto-generated method stub
		sqlSession.delete(nameSpace + ".deleteContract", cr_code);
	}

	@Override
	public String getLastContractCode() {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(nameSpace + ".getLastContractCode");
	}

}
