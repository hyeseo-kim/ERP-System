package com.algorizo.erp.procurement_plan;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.algorizo.erp.procurement_plan.DTO.PlanDTO;
import co.algorizo.erp.procurement_plan.DTO.PlanDetailDTO;
import co.algorizo.erp.procurement_plan.DTO.PlanProductDTO;

@Service
public class PlanServiceImpl implements PlanService {
	
	@Autowired
	private PlanDAO planDAO;
//	조달 계획 조회
	@Override
	public List<PlanDTO> list() {

		return planDAO.list();
	}
//	조달 계획 상세보기
	@Override
	public List<PlanDetailDTO> detail(int plan_id) {

		return planDAO.detail(plan_id);
	}
//	조달 계획 등록
	@Override
	@Transactional
	public void plan_Register(PlanDTO planDTO) {
//		등록일 처리
		Date today = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(" HH:mm:ss");
		planDTO.setPlan_regdate(planDTO.getPlan_regdate() + simpleDateFormat.format(today));
//		조달 계획 등록
		planDAO.plan_Register(planDTO);
//		조달 계획 품목 등록
		planDTO.getProducts().forEach(product -> product.setPlan_id(planDTO.getPlan_id()));
		planDTO.getProducts().forEach(product -> planDAO.product_Register(product));
		
	}
//	조달 계획 품목 등록
	@Override
	public void product_Register(PlanProductDTO planProductDTO) {

		planDAO.product_Register(planProductDTO);
		
	}
//	조달 계획 수정
	@Override
	@Transactional
	public void update(PlanDTO planDTO) {
//		수정일 등록
		Date today = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		planDTO.setPlan_moddate(dateFormat.format(today));
//		조달 계획 수정
		planDAO.update(planDTO);
//		조달 계획 품목 삭제
		planDAO.product_Delete(planDTO.getPlan_id());
//		조달 계획 품목 재등록
		planDTO.getProducts().forEach(product -> product.setPlan_id(planDTO.getPlan_id()));
		planDTO.getProducts().forEach(product -> planDAO.product_Register(product));
		
	}
//	조달 계획 삭제
	@Override
	public void plan_Delete(int plan_id) {

		planDAO.plan_Delete(plan_id);
		
	}
	@Override
	public void product_Delete(int plan_id) {

		planDAO.product_Delete(plan_id);
	}
//	코드 가져오기
	@Override
	public String registerCode() {
		Date today = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		String prefix = "PL-" + dateFormat.format(today) + "-";
		
		String lastcode = planDAO.registerCode(prefix);
		
		int index = 1;
		if(lastcode != null) {
			String[] parts = lastcode.split("-");
			index = Integer.parseInt(parts[2]) + 1;
		}
		String resultNum = String.format("%03d", index);
		return prefix + resultNum;
	}
//	품목 리스트
	@Override
	public List<PlanDetailDTO> product_list() {

		return planDAO.product_list();
	}
}
