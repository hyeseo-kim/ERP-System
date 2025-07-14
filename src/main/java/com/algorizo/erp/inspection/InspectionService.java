package com.algorizo.erp.inspection;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import co.algorizo.erp.inbound.inboundDTO;
import co.algorizo.erp.inspection.DTO.DefectReasonDTO;
import co.algorizo.erp.inspection.DTO.InspectionDTO;

public interface InspectionService {
//	검수 조회
	List<InspectionDTO> list();
//	검수 상세보기
	InspectionDTO detail(int i_id);
//	검수 등록
	void register(InspectionDTO inspectionDTO);
//	검수 수정
	void update(InspectionDTO inspectionDTO);
//	검수 삭제
	void delete(int i_id);
//	검수 코드 생성
	String registerCode();
//	입고(입고대기 상태) 조회
	List<inboundDTO> inboudList();
//	입고 상태 변경
	void in_stateUpdate(int in_id , String state);
//	불량 사유 가져오기
	List<DefectReasonDTO> defectReasonList();
//	불량수량 차트 데이터
	Map<String, Object> defectReasonData(LocalDate start , LocalDate end);
}
