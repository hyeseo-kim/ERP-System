package com.algorizo.erp.outinspection;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.algorizo.erp.inbound.inboundDAO;
import co.algorizo.erp.inbound.inboundDTO;
import co.algorizo.erp.inspection.DTO.DefectReasonDTO;
import co.algorizo.erp.inspection.DTO.InspectionDTO;
import co.algorizo.erp.outbound.outboundDTO;

@Service
public class OutInspectionServiceImpl implements OutInspectionService{
	@Autowired
	private OutInspectionDAO outInspectionDAO;

	@Override
	public List<OutInspectionDTO> list() {

		return outInspectionDAO.list();
	}

	@Override
	public OutInspectionDTO detail(int oi_id) {

		return outInspectionDAO.detail(oi_id);
	}

	@Override
	@Transactional
	public void register(OutInspectionDTO outInspectionDTO) {
//		등록일 처리
		Date today = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(" HH:mm:ss");
		outInspectionDTO.setOi_date(outInspectionDTO.getOi_date() + simpleDateFormat.format(today));
//		검수 등록
		outInspectionDAO.register(outInspectionDTO);
//		입고 상태 변경
		if(outInspectionDTO.getOi_defect_rate() <= 10) {
			outInspectionDAO.out_stateUpdate(outInspectionDTO.getOut_id() , "출고 확정 대기");
		} else {
			outInspectionDAO.out_stateUpdate(outInspectionDTO.getOut_id() , "출고 실패");
		}
	}

	@Override
	@Transactional
	public void update(OutInspectionDTO outInspectionDTO) {
//		수정일 생성
		Date today = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		outInspectionDTO.setOi_moddate(simpleDateFormat.format(today));
//		검수 수정
		outInspectionDAO.update(outInspectionDTO);
//		입고 상태 변경
		if(outInspectionDTO.getOi_defect_rate() <= 10) {
			outInspectionDAO.out_stateUpdate(outInspectionDTO.getOut_id() , "출고 확정 대기");
		} else {
			outInspectionDAO.out_stateUpdate(outInspectionDTO.getOut_id() , "출고 실패");
		}
	}

	@Override
	@Transactional
	public void delete(int oi_id) {
//		검수 상세보기
		OutInspectionDTO outInspectionDTO = outInspectionDAO.detail(oi_id);
//		입고 상태 변경
		outInspectionDAO.out_stateUpdate(outInspectionDTO.getOut_id(), "출고 대기");
//		검수 삭제
		outInspectionDAO.delete(oi_id);
	}

	@Override
	public String registerCode() {
		Date today = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		String prefix = "O_INSP-" + dateFormat.format(today) + "-";
		
		String lastcode = outInspectionDAO.registerCode(prefix);
		
		int index = 1;
		if(lastcode != null) {
			String[] parts = lastcode.split("-");
			index = Integer.parseInt(parts[2]) + 1;
		}
		String resultNum = String.format("%03d", index);
		return prefix + resultNum;
	}

	@Override
	public List<outboundDTO> outboundList() {

		return outInspectionDAO.outboundList();
	}

	@Override
	public void in_stateUpdate(int in_id , String state) {

		outInspectionDAO.out_stateUpdate(in_id , state);
	}

	@Override
	public List<DefectReasonDTO> defectReasonList() {

		return outInspectionDAO.defectReasonList();
	}

}
