package com.algorizo.erp.inspection;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.algorizo.erp.inbound.inboundDTO;
import co.algorizo.erp.inspection.DTO.DefectReasonDTO;
import co.algorizo.erp.inspection.DTO.InspectionDTO;

@Repository
public class InspectionDAOImpl implements InspectionDAO{
	private static final String namespace = "co.algorizo.erp.inspectionMapper";
	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<InspectionDTO> list() {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace + ".list");
	}

	@Override
	public InspectionDTO detail(int i_id) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace + ".detail", i_id);
	}

	@Override
	public void register(InspectionDTO inspectionDTO) {
		// TODO Auto-generated method stub
		sqlSession.insert(namespace + ".register", inspectionDTO);
	}

	@Override
	public void update(InspectionDTO inspectionDTO) {
		// TODO Auto-generated method stub
		sqlSession.update(namespace + ".update", inspectionDTO);
	}

	@Override
	public void delete(int i_id) {
		// TODO Auto-generated method stub
		sqlSession.delete(namespace + ".delete", i_id);
	}

	@Override
	public String registerCode(String prefix) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace + ".registerCode", prefix);
	}

	@Override
	public List<inboundDTO> inboudList() {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace + ".inboudList");
	}

	@Override
	public void in_stateUpdate(int in_id , String state) {
		Map<String, Object> update = new HashMap<String, Object>();
		update.put("in_id", in_id);
		update.put("state", state);
		sqlSession.update(namespace + ".in_stateUpdate", update);
	}

	@Override
	public List<DefectReasonDTO> defectReasonList() {
		
		return sqlSession.selectList(namespace + ".defect_reason");
	}

	@Override
	public Map<String, Object> defectReasonData(LocalDate start , LocalDate end) {
		// TODO Auto-generated method stub
		Map<String, Object> local = new HashMap<String, Object>();
		local.put("start", start);
		local.put("end", end);
		return sqlSession.selectMap(namespace + ".chartData" , local ,"label");
	}

}
