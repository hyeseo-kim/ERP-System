package com.algorizo.erp.dept.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import co.algorizo.erp.dept.dao.DeptDAO;
import co.algorizo.erp.dept.dto.DeptDTO;

@Service
public class DeptServiceimpl implements DeptService{

	@Inject
	private DeptDAO dao;
	
	@Override
	public List<DeptDTO> getDeptList() {
		// TODO Auto-generated method stub
		return dao.getDeptList();
	}

	@Override
	public DeptDTO selectDept(int d_id) {
		// TODO Auto-generated method stub
		return dao.selectDept(d_id);
	}

}
