package com.ntg.organization.organization.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ntg.organization.organization.dto.DepartmentDTO;
import com.ntg.organization.organization.service.DepartmentService;

@RestController
@RequestMapping("/dept/v1")
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;

	@GetMapping(value = "/all")
	public List<DepartmentDTO> getAllDepartment() {
		return departmentService.getAllDepartment();
	}

}
