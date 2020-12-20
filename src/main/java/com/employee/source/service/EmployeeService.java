package com.employee.source.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.employee.source.model.EmployeeModel;
import com.employee.source.util.EmployeeInfo;

@Service
public class EmployeeService implements IEmployeeService{

	
	public ArrayList<EmployeeModel> getAllEmployees() {
		
		
		if(EmployeeInfo.employeeMap==null) {
			
			
			new EmployeeInfo().buildEmployeeDetails();
		}
		
		
		return EmployeeInfo.getAlEmployeeDetails();
		
		
		
	}
	
    public ArrayList<EmployeeModel> updateEmployeeDetails(EmployeeModel emp ) {
		
     
		for(EmployeeModel emplModel:EmployeeInfo.employeeMap.get(emp.getEmployeeRole())) {
			
			if(emplModel.getEmployeeId().equals(emp.getEmployeeId())) {
				
				emplModel.setEmployeeVacationDays(emp.getEmployeeVacationDays());
				emplModel.setEmployeeWorkDays(emp.getEmployeeWorkDays());
				
				
			}
		}
		
    return EmployeeInfo.getAlEmployeeDetails();
		
		
		
	}
}
