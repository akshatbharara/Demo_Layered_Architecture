package com.capgemini.employeeapp.service;

import java.util.List;

import com.capgemini.employeeapp.bean.EmployeeBean;
import com.capgemini.employeeapp.exception.EmployeeException;

public interface IEmployeeService {
	public Integer addEmployeeDetails(EmployeeBean employee) throws EmployeeException;
	public EmployeeBean viewEmployeeDetails(int empId) throws EmployeeException;
	public List<EmployeeBean> retrieveAllEmployees()throws EmployeeException;
	

}
