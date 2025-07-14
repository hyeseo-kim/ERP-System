package com.algorizo.erp.outinspection;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.algorizo.erp.inbound.inboundDTO;
import co.algorizo.erp.inspection.DTO.DefectReasonDTO;
import co.algorizo.erp.inspection.DTO.InspectionDTO;
import co.algorizo.erp.outbound.outboundDTO;

@Repository
public class OutInspectionDAOImpl implements OutInspectionDAO{
	private static final String namespace = "co.algorizo.erp.outInspectionMapper";
	@Autowired
	private SqlSession sqlSession;
	@Override
	public List<OutInspectionDTO> list() {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace + ".list");
	}
	@Override
	public OutInspectionDTO detail(int oi_id) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace + ".detail", oi_id);
	}
	@Override
	public void register(OutInspectionDTO outInspectionDTO) {
		// TODO Auto-generated method stub
		sqlSession.insert(namespace + ".register", outInspectionDTO);
	}
	@Override
	public void update(OutInspectionDTO outInspectionDTO) {
		// TODO Auto-generated method stub
		sqlSession.update(namespace + ".update", outInspectionDTO);
	}
	@Override
	public void delete(int oi_id) {
		// TODO Auto-generated method stub
		sqlSession.delete(namespace + ".delete", oi_id);
	}
	@Override
	public String registerCode(String prefix) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace + ".registerCode", prefix);
	}
	@Override
	public List<outboundDTO> outboundList() {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace + ".outboudList");
	}
	@Override
	public void out_stateUpdate(int out_id, String state) {
		// TODO Auto-generated method stub
		Map<String, Object> update = new HashMap<String, Object>();
		update.put("out_id", out_id);
		update.put("state", state);
		sqlSession.update(namespace + ".out_stateUpdate", update);
	}
	@Override
	public List<DefectReasonDTO> defectReasonList() {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace + ".defect_reason");
	}


}
