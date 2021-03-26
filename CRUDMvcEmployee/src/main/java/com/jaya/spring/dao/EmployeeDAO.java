package com.jaya.spring.dao;

import java.util.List;

import com.jaya.spring.model.Employee;

public interface EmployeeDAO 
{
  public void addEmployee(Employee e);
  public void updateEmployee(Employee e);
  public List<Employee> listEmployees();
  public Employee getEmployeeById(int empId);
  public void removeEmployee(int empId);
 
 }
