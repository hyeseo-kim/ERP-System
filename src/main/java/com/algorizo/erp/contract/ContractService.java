package com.algorizo.erp.contract;

import java.util.List;
import java.util.Map;

public interface ContractService {

	public List<ContractDTO> getAllContracts();

	public void register(Map<String, Object> map);
	
	public ContractDTO getContractDetail(String cr_code);
	
	void updateContract(Map<String, Object> map);
	
	void deleteContract(String cr_code);
	
	public String generateNextContractCode();
	
}
