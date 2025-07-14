package com.algorizo.erp.contract;

import java.util.List;
import java.util.Map;

import com.algorizo.erp.contract.ContractDTO;

public interface ContractDAO {

	public List<ContractDTO> getAllContracts();

	public void register(Map<String, Object> map);
	
	public ContractDTO getContractDetail(String cr_code);
	
	void updateContract(Map<String, Object> map);
	
	void deleteContract(String cr_code);
	
	String getLastContractCode();
	
}
