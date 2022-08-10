package com.ntg.organization.organization.dto;

import java.util.List;

import com.ntg.organization.organization.entity.Employee;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DepartmentDTO {

	private Long id;
	private String deptName;
	private List<Employee> employees;
}
