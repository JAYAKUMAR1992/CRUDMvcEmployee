	package com.jaya.spring.service;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jaya.spring.dao.EmployeeDAO;
import com.jaya.spring.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	private EmployeeDAO employeeDAO;

	public void setEmployeeDAO(EmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
	}

	@Override
	@Transactional
	public void addEmployee(Employee e) {
		this.employeeDAO.addEmployee(e);
	}

	@Override
	@Transactional
	public void updateEmployee(Employee e) {
		this.employeeDAO.updateEmployee(e);
	}

	@Override
	@Transactional
	public List<Employee> listEmployees() {
		return this.employeeDAO.listEmployees();
	}

	@Override
	@Transactional
	public Employee getEmployeeById(int EmpId) {
		return this.employeeDAO.getEmployeeById(EmpId);
	}

	@Override
	@Transactional
	public void removeEmployee(int EmpId) {
		this.employeeDAO.removeEmployee(EmpId);
	}

}