package com.algorizo.erp.calendar;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CalendarController {
	@Autowired
	private CalendarService calendarService;
	
	@GetMapping(value = "/calendar/date")
	@ResponseBody
	public List<CalendarDTO> getSchedule(@RequestParam("start") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate start
			, @RequestParam("end")   @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate end){

		return calendarService.getMonthlySchedule(start , end);
	}
}
