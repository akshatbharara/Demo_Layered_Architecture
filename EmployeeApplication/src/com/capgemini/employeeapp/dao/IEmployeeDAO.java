package com.capgemini.employeeapp.dao;

import java.util.List;

import com.capgemini.employeeapp.bean.EmployeeBean;
import com.capgemini.employeeapp.exception.EmployeeException;

public interface IEmployeeDAO {
	public Integer addEmployeeDetails(EmployeeBean employee) throws EmployeeException;
	public EmployeeBean viewEmployeeDetails(int empId) throws EmployeeException;
	public List<EmployeeBean> retrieveAllEmployees()throws EmployeeException;
	
}
