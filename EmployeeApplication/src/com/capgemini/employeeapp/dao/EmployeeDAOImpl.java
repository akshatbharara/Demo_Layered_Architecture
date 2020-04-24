package com.capgemini.employeeapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.capgemini.employeeapp.bean.EmployeeBean;
import com.capgemini.employeeapp.exception.EmployeeException;
import com.capgemini.employeeapp.util.DBConnection;
/**
 * 
 * @author Zainab
 *
 */

public class EmployeeDAOImpl implements IEmployeeDAO{

	Logger logger=Logger.getRootLogger();
	
	
	public EmployeeDAOImpl() {
		
		PropertyConfigurator.configure("resources//log4j.properties");
	}


	@SuppressWarnings("resource")
	@Override
	public Integer addEmployeeDetails(EmployeeBean employee) throws EmployeeException {
		
		Connection connection = DBConnection.getInstance().getConnection();	
		
		PreparedStatement preparedStatement=null;		
		ResultSet resultSet = null;
		
		int employeeId=0;
		
		int queryResult=0;
		try
		{		
			preparedStatement=connection.prepareStatement(QueryMapper.INSERT_QUERY);

			preparedStatement.setString(1,employee.getEmployeeName());
					
			queryResult=preparedStatement.executeUpdate();
		
			preparedStatement = connection.prepareStatement(QueryMapper.EMPLOYEEID_QUERY_SEQUENCE);
			resultSet=preparedStatement.executeQuery();

			if(resultSet.next())
			{
				employeeId=resultSet.getInt(1);
						
			}
	
			if(queryResult==0)
			{
				logger.error("Insertion failed ");
				throw new EmployeeException("Inserting employee details failed ");

			}
			else
			{
				logger.info("Employee details added successfully:");
				return employeeId;
			}
		 }
		catch(SQLException sqlException)
		{
			logger.error(sqlException.getMessage());
			throw new EmployeeException("Tehnical problem occured refer log");
		}
		finally
		{
			try 
			{
				preparedStatement.close();
				connection.close();
			}
			catch (SQLException sqlException) 
			{
				logger.error(sqlException.getMessage());
				throw new EmployeeException("Error in closing db connection");	
			}
		}
		
		
		// TODO Auto-generated method stub
	
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


	

}
