package com.algorizo.erp.procurement_plan;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.algorizo.erp.procurement_plan.DTO.PlanDTO;
import co.algorizo.erp.procurement_plan.DTO.PlanDetailDTO;
import co.algorizo.erp.procurement_plan.DTO.PlanProductDTO;

@Repository
public class PlanDAOImpl implements PlanDAO {
	private static final String namespace = "co.algorizo.erp.planMapper";
	@Autowired
	private SqlSession sqlSession;
//	조달 계획 조회
	@Override
	public List<PlanDTO> list() {
		// TODO Auto-generated method stub

		return sqlSession.selectList(namespace + ".list");
	}
//	조달 계획 상세보기
	@Override
	public List<PlanDetailDTO> detail(int plan_id) {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace + ".detail", plan_id);
	}
//	조달 계획 등록
	@Override
	public void plan_Register(PlanDTO planDTO) {
		// TODO Auto-generated method stub
		sqlSession.insert(namespace + ".plan_register", planDTO);
	}
//	조달 계획 품목 등록
	@Override
	public void product_Register(PlanProductDTO planProductDTO) {
		// TODO Auto-generated method stub
		sqlSession.insert(namespace + ".product_register", planProductDTO);
	}
//	조달 계획 수정
	@Override
	public void update(PlanDTO planDTO) {
		// TODO Auto-generated method stub
		sqlSession.update(namespace + ".update", planDTO);
	}
//	조달 계획 삭제
	@Override
	public void plan_Delete(int plan_id) {
		// TODO Auto-generated method stub
		sqlSession.delete(namespace + ".plan_delete", plan_id);
	}
//	조달 계획 품목 삭제
	@Override
	public void product_Delete(int plan_id) {
		// TODO Auto-generated method stub
		sqlSession.delete(namespace + ".product_delete", plan_id);
	}
//	코드 가져오기 
	@Override
	public String registerCode(String prefix) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace + ".registerCode", prefix);
	}
//	품목 리스트
	@Override
	public List<PlanDetailDTO> product_list() {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace + ".product_list");
	}
}
