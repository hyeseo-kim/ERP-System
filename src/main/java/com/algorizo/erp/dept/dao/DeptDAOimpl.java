package com.algorizo.erp.dept.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.algorizo.erp.dept.dto.DeptDTO;

@Repository
public class DeptDAOimpl implements DeptDAO{

	@Inject
	private SqlSession sqlSession;
	
	@Override
	public List<DeptDTO> getDeptList() {
		// TODO Auto-generated method stub
		return sqlSession.selectList("co.algorizo.erp.deptMapper.getDeptList");
	}

	@Override
	public DeptDTO selectDept(int d_id) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("co.algorizo.erp.deptMapper.getDeptById", d_id);
	}

}
