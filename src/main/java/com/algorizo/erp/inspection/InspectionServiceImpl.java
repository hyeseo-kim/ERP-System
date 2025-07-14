package com.algorizo.erp.inspection;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.algorizo.erp.inbound.inboundDAO;
import co.algorizo.erp.inbound.inboundDTO;
import co.algorizo.erp.inspection.DTO.DefectReasonDTO;
import co.algorizo.erp.inspection.DTO.InspectionDTO;

@Service
public class InspectionServiceImpl implements InspectionService{
	@Autowired
	private InspectionDAO inspectionDAO;

	@Override
	public List<InspectionDTO> list() {

		return inspectionDAO.list();
	}

	@Override
	public InspectionDTO detail(int i_id) {

		return inspectionDAO.detail(i_id);
	}

	@Override
	@Transactional
	public void register(InspectionDTO inspectionDTO) {
//		등록일 처리
		Date today = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(" HH:mm:ss");
		inspectionDTO.setI_date(inspectionDTO.getI_date() + simpleDateFormat.format(today));
//		검수 등록
		inspectionDAO.register(inspectionDTO);
//		입고 상태 변경
		if(inspectionDTO.getI_defect_rate() <= 10) {
			inspectionDAO.in_stateUpdate(inspectionDTO.getIn_id() , "입고 확정 대기");
		} else {
			inspectionDAO.in_stateUpdate(inspectionDTO.getIn_id() , "입고 실패");
		}
	}

	@Override
	@Transactional
	public void update(InspectionDTO inspectionDTO) {
//		수정일 생성
		Date today = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		inspectionDTO.setI_moddate(simpleDateFormat.format(today));
//		검수 수정
		inspectionDAO.update(inspectionDTO);
//		입고 상태 변경
		if(inspectionDTO.getI_defect_rate() <= 10) {
			inspectionDAO.in_stateUpdate(inspectionDTO.getIn_id() , "입고 확정 대기");
		} else {
			inspectionDAO.in_stateUpdate(inspectionDTO.getIn_id() , "입고 실패");
		}
	}

	@Override
	@Transactional
	public void delete(int i_id) {
//		검수 상세보기
		InspectionDTO inspectionDTO = inspectionDAO.detail(i_id);
//		입고 상태 변경
		inspectionDAO.in_stateUpdate(inspectionDTO.getIn_id(), "입고 대기");
//		검수 삭제
		inspectionDAO.delete(i_id);
	}

	@Override
	public String registerCode() {
		Date today = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		String prefix = "INSP-" + dateFormat.format(today) + "-" ;
		
		String lastcode = inspectionDAO.registerCode(prefix);
		
		int index = 1;
		if(lastcode != null) {
			String[] parts = lastcode.split("-");
			index = Integer.parseInt(parts[2]) + 1;
		}
		String resultNum = String.format("%03d", index);
		return prefix + resultNum;
	}

	@Override
	public List<inboundDTO> inboudList() {

		return inspectionDAO.inboudList();
	}

	@Override
	public void in_stateUpdate(int in_id , String state) {

		inspectionDAO.in_stateUpdate(in_id , state);
	}

	@Override
	public List<DefectReasonDTO> defectReasonList() {

		return inspectionDAO.defectReasonList();
	}

	@Override
	public Map<String, Object> defectReasonData(LocalDate start , LocalDate end) {
		// TODO Auto-generated method stub
		return inspectionDAO.defectReasonData(start , end);
	}

}
