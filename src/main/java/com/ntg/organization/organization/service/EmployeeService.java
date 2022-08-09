package com.ntg.organization.organization.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ntg.organization.organization.entity.Employee;
import com.ntg.organization.organization.respository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	public List<Employee> getAllEmployee() {
		return (List<Employee>) employeeRepository.findAll();
	}

	public Employee createNewEmployee(Employee newEmp) {
		if (newEmp != null) {
			return employeeRepository.save(newEmp);
		}
		return null;
	}

	public boolean deleteEmployeeById(Long id) {
		if (id != null) {
			employeeRepository.deleteById(id);
			return true;
		}

		return false;
	}

	public Employee getEmployeeByName(String name, String email) {
		return employeeRepository.findByNameAndEmail(name, email);
	}

}
