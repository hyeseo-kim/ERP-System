package com.algorizo.erp.dept.service;

import java.util.List;

import co.algorizo.erp.dept.dao.DeptDAO;
import co.algorizo.erp.dept.dto.DeptDTO;

public interface DeptService {
	public List<DeptDTO> getDeptList();
	public DeptDTO selectDept(int d_id);
}
