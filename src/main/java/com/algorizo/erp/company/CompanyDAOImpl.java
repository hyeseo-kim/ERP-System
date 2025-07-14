package com.algorizo.erp.company;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class CompanyDAOImpl implements CompanyDAO{

	@Autowired
	private SqlSession sqlSession;
	
	private static final String NAMESPACE = "co.algorizo.erp.companyMapper";
	
	@Override
	public List<CompanyDTO> companylist() {
		return sqlSession.selectList(NAMESPACE + ".companylist");
	}

	@Override
	public CompanyDTO getcompany(int cp_id) {
		return sqlSession.selectOne(NAMESPACE + ".getcompany", cp_id);
	}

	@Override
	public void companyupdate(CompanyDTO companyDTO) {
		sqlSession.update(NAMESPACE + ".companyupdate", companyDTO);
	}

	@Override
	public void companyinsert(CompanyDTO companyDTO) {
		sqlSession.insert(NAMESPACE + ".companyinsert", companyDTO);
	}

	@Override
	public void companydelete(int cp_id) {
		sqlSession.delete(NAMESPACE + ".companydelete", cp_id);
	}

	@Override
	public CompanyDTO selectCompany(int cp_id) {
		return sqlSession.selectOne(NAMESPACE + ".selectCompany", cp_id);
	}

	
	

	

}
