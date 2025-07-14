package com.algorizo.erp.calendar;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.algorizo.erp.contract.ContractDTO;
import co.algorizo.erp.inbound.inboundDTO;
import com.algorizo.erp.inspection.DTO.InspectionDTO;
import co.algorizo.erp.order.OrderDTO;
import com.algorizo.erp.outbound.outboundDTO;
import com.algorizo.erp.outinspection.OutInspectionDTO;
import com.algorizo.erp.procurement_plan.DTO.PlanDTO;
import com.algorizo.erp.procurement_plan.DTO.PlanDetailDTO;

@Repository
public class CalendarDAOImpl implements CalendarDAO{
	private static final String namespace = "co.algorizo.erp.calendarMapper";
	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<PlanDetailDTO> planDate(LocalDate start, LocalDate end) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("start", start);
		map.put("end", end);
		
		return sqlSession.selectList(namespace + ".planDate" , map);
	}

	@Override
	public List<OrderDTO> orderDate(LocalDate start, LocalDate end) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("start", start);
		map.put("end", end);
		
		return sqlSession.selectList(namespace + ".orderDate" , map);
	}

	@Override
	public List<ContractDTO> contractDate(LocalDate start, LocalDate end) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("start", start);
		map.put("end", end);
		
		return sqlSession.selectList(namespace + ".contractDate" , map);
	}

	@Override
	public List<InspectionDTO> inspectionDate(LocalDate start, LocalDate end) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("start", start);
		map.put("end", end);
		
		return sqlSession.selectList(namespace + ".inspectionDate" , map);
	}

	@Override
	public List<OutInspectionDTO> outInspectionDate(LocalDate start, LocalDate end) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("start", start);
		map.put("end", end);
		
		return sqlSession.selectList(namespace + ".outInspectionDate" , map);
	}

	@Override
	public List<inboundDTO> inboundDate(LocalDate start, LocalDate end) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("start", start);
		map.put("end", end);
		
		return sqlSession.selectList(namespace + ".inboundDate", map);
	}

	@Override
	public List<outboundDTO> outboundDate(LocalDate start, LocalDate end) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("start", start);
		map.put("end", end);
		
		return sqlSession.selectList(namespace + ".outboundDate", map);
	}

}
