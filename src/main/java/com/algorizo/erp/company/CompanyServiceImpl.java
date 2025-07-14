package com.algorizo.erp.company;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyServiceImpl implements CompanyService {
	
	@Autowired
	private CompanyDAO companyDAO;

	@Override
	public List<CompanyDTO> companylist() {
		return companyDAO.companylist();
	}

	@Override
	public CompanyDTO getcompany(int cp_id) {
		// TODO Auto-generated method stub
		return companyDAO.getcompany(cp_id);
	}

	@Override
	public void companyupdate(CompanyDTO companyDTO) {
		companyDAO.companyupdate(companyDTO);
	}

	@Override
	public void companyinsert(CompanyDTO companyDTO) {
		companyDAO.companyinsert(companyDTO);
	}

	@Override
	public void companydelete(int cp_id) {
		companyDAO.companydelete(cp_id);
	}

	@Override
	public CompanyDTO selectCompany(int cp_id) {
		return companyDAO.selectCompany(cp_id);
	}

	

}
