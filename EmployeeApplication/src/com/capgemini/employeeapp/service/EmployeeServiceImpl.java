package com.capgemini.employeeapp.service;

import java.util.List;

import com.capgemini.employeeapp.bean.EmployeeBean;
import com.capgemini.employeeapp.dao.EmployeeDAOImpl;
import com.capgemini.employeeapp.dao.IEmployeeDAO;
import com.capgemini.employeeapp.exception.EmployeeException;
/**
 * 
 * @author Zainab
 *
 */

public class EmployeeServiceImpl implements IEmployeeService {
	IEmployeeDAO employeeDao;
	
	
	public EmployeeServiceImpl() {
		employeeDao=new EmployeeDAOImpl();	
	}

	@Override
	public Integer addEmployeeDetails(EmployeeBean employee) throws EmployeeException {
		// TODO Auto-generated method stub
		
		return employeeDao.addEmployeeDetails(employee);
	}

	@Override
	public EmployeeBean viewEmployeeDetails(int empId) throws EmployeeException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<EmployeeBean> retrieveAllEmployees() throws EmployeeException {
		// TODO Auto-generated method stub
		return null;
	}
	public void validateEmployee(EmployeeBean bean) throws EmployeeException{
		//add the implementation
	}

}
