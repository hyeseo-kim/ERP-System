package com.algorizo.erp.dept.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import co.algorizo.erp.dept.dao.DeptDAO;
import co.algorizo.erp.dept.dto.DeptDTO;
import co.algorizo.erp.dept.service.DeptService;

@Controller
public class DeptController {
	
	@Inject
	private DeptService service;
	
	@GetMapping("/register")
	public String registerForm(Model model) {
		List<DeptDTO> deptList = service.getDeptList();
		model.addAttribute("deptList", deptList);
		
		
		return "register";
	}
	
	
	
}
