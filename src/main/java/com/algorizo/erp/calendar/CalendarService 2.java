package com.algorizo.erp.calendar;

import java.time.LocalDate;
import java.util.List;

import com.algorizo.erp.contract.ContractDTO;
import com.algorizo.erp.inspection.DTO.InspectionDTO;
import co.algorizo.erp.order.OrderDTO;
import com.algorizo.erp.outinspection.OutInspectionDTO;
import com.algorizo.erp.procurement_plan.DTO.PlanDTO;

public interface CalendarService {
	
	List<CalendarDTO> getMonthlySchedule(LocalDate start, LocalDate end);
}
