package com.employee.source.util;

import java.util.ArrayList;
import java.util.HashMap;

import com.employee.source.constants.CommonConstants;
import com.employee.source.model.EmployeeModel;

public class EmployeeInfo {
	
	public static HashMap<String,ArrayList<EmployeeModel>> employeeMap;
	
	/**
	 * This Method builds all Employee to list in WEb Interface
	 *
	 */
	public HashMap<String,ArrayList<EmployeeModel>> buildEmployeeDetails() {
		ArrayList<String> employee=new ArrayList<String>();
		employee.add(CommonConstants.ROLE_HOURLY_EMPLOYEES);
		employee.add(CommonConstants.ROLE_SALARIED_EMPLOYEES);
		employee.add(CommonConstants.ROLE_MANAGER_EMPLOYEES);
		
		employeeMap=new HashMap<String,ArrayList<EmployeeModel>>();
		ArrayList<EmployeeModel> employeeList=null;
		
		for(int i=0;i<employee.size();i++) {
			String role=employee.get(i);
			employeeList=new ArrayList<EmployeeModel>();
			for(int j=1;j<=10;j++) {
				EmployeeModel  employeeInfo=new EmployeeModel();
				employeeInfo.setEmployeeId(role+1000+(j));
				employeeInfo.setEmployeeRole(role);
				employeeInfo.setEmployeeVacationDays(0);
				employeeInfo.setEmployeeWorkDays(0);
				employeeList.add(employeeInfo);
			}
			employeeMap.put(role, employeeList);
			
		}
		
		
		return employeeMap;
		
		
		
	}



public static ArrayList<EmployeeModel>  getAlEmployeeDetails() {
	
	ArrayList<EmployeeModel> employeeList=new ArrayList<EmployeeModel>();
	
	employeeList.addAll((ArrayList)EmployeeInfo.employeeMap.get(CommonConstants.ROLE_HOURLY_EMPLOYEES));
	employeeList.addAll((ArrayList)EmployeeInfo.employeeMap.get(CommonConstants.ROLE_SALARIED_EMPLOYEES));
	
	employeeList.addAll((ArrayList)EmployeeInfo.employeeMap.get(CommonConstants.ROLE_MANAGER_EMPLOYEES));

	
	return employeeList;
}
	
	
	
}
