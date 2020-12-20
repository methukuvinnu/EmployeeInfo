package com.employee.source.service;

import java.util.ArrayList;

import com.employee.source.model.EmployeeModel;

public interface IEmployeeService {

	public ArrayList<EmployeeModel> getAllEmployees();
	
	public ArrayList<EmployeeModel> updateEmployeeDetails(EmployeeModel emp );
}
