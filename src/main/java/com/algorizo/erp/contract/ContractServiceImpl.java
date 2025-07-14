package com.algorizo.erp.contract;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

@Service
public class ContractServiceImpl implements ContractService{

	@Inject
	ContractDAO contractDAO;
	
	
	@Override
	public List<ContractDTO> getAllContracts() {
		// TODO Auto-generated method stub
		return contractDAO.getAllContracts();
	}

	@Override
	public void register(Map<String, Object> map) {
		// TODO Auto-generated method stub
		contractDAO.register(map);
	}

	@Override
	public ContractDTO getContractDetail(String cr_code) {
		// TODO Auto-generated method stub
		return contractDAO.getContractDetail(cr_code);
	}

	@Override
	public void updateContract(Map<String, Object> map) {
		// TODO Auto-generated method stub
		contractDAO.updateContract(map);
	}

	@Override
	public void deleteContract(String cr_code) {
		// TODO Auto-generated method stub
		contractDAO.deleteContract(cr_code);
	}

	@Override
	public String generateNextContractCode() {
		// TODO Auto-generated method stub
		String lastContractCode = contractDAO.getLastContractCode();
        String today = new SimpleDateFormat("yyyyMMdd").format(new Date());
        if (lastContractCode == null || !lastContractCode.startsWith("CR-" + today)) {
            return "CR-" + today + "-001";
        }
        int lastNumber = Integer.parseInt(lastContractCode.substring(12));
        return String.format("CR-%s-%03d", today, lastNumber + 1);
	}



}
