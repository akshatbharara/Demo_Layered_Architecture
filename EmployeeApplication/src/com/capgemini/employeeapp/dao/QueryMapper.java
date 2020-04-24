package com.capgemini.employeeapp.dao;



public interface QueryMapper {
	public static final String INSERT_QUERY="INSERT INTO EmployeeDetails VALUES(employeeId_sequence.NEXTVAL,?)";
	public static final String EMPLOYEEID_QUERY_SEQUENCE="SELECT employeeId_sequence.CURRVAL FROM DUAL";

}

/******************TABLESCRIPT*******************
CREATE TABLE EmployeeDetails(
employee_id NUMBER,
employee_name VARCHAR2(20)
);

CREATE SEQUENCE employeeId_sequence;

************************************************/