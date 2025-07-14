package com.algorizo.erp.procurement_plan;

import java.util.List;

import co.algorizo.erp.procurement_plan.DTO.PlanDTO;
import co.algorizo.erp.procurement_plan.DTO.PlanDetailDTO;
import co.algorizo.erp.procurement_plan.DTO.PlanProductDTO;

public interface PlanService {
//	조달 계획 조회
	List<PlanDTO> list();
//	조달 계획 상세보기
	List<PlanDetailDTO> detail(int plan_id);
//	조달 계획 등록
	void plan_Register(PlanDTO planDTO);
//	조달 계획 품목 등록
	void product_Register(PlanProductDTO planProductDTO);
//	조달 계획 수정
	void update(PlanDTO planDTO);
//	조달 계획 삭제
	void plan_Delete(int plan_id);
//	조달 계획 품목 삭제
	void product_Delete(int plan_id);
//	코드 가져오기
	String registerCode();
//	품목 리스트
	List<PlanDetailDTO> product_list();
}
