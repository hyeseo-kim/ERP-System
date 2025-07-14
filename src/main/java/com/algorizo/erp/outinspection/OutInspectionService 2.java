package com.algorizo.erp.outinspection;

import java.util.List;

import co.algorizo.erp.inbound.inboundDTO;
import co.algorizo.erp.inspection.DTO.DefectReasonDTO;
import co.algorizo.erp.inspection.DTO.InspectionDTO;
import co.algorizo.erp.outbound.outboundDTO;

public interface OutInspectionService {
//	검수 조회
	List<OutInspectionDTO> list();
//	검수 상세보기
	OutInspectionDTO detail(int oi_id);
//	검수 등록
	void register(OutInspectionDTO outInspectionDTO);
//	검수 수정
	void update(OutInspectionDTO outInspectionDTO);
//	검수 삭제
	void delete(int oi_id);
//	검수 코드 생성
	String registerCode();
//	입고(입고대기 상태) 조회
	List<outboundDTO> outboundList();
//	입고 상태 변경
	void in_stateUpdate(int out_id , String state);
//	불량 사유 가져오기
	List<DefectReasonDTO> defectReasonList();
}
