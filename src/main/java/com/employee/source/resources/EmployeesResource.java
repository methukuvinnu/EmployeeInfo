package com.employee.source.resources;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.source.constants.CommonConstants;
import com.employee.source.model.EmployeeModel;
import com.employee.source.service.IEmployeeService;


@RestController
@RequestMapping(value="/employee")
public class EmployeesResource {

	@Autowired
	IEmployeeService employeeService;

	@GetMapping
	/**
	 * This End point Builds and list the New Employees based on
	 * Their Role
	 *
	 */
	public ArrayList<EmployeeModel> employeeDetails() {

		return employeeService.getAllEmployees();
	}
	
	
	@PostMapping
	/**
	 * This End point updates the list of the employees based ob the user input
	 *
	 */
	public Map<String,Object> updateEmployeeDetails(@RequestBody EmployeeModel emp) {
		Map<String,Object>  returnObjMap=new HashMap<String,Object>();
		returnObjMap.put("returnCode", "0");
		returnObjMap.put("returnMsg", "Successfully Employee information Updated");
		Integer daysCount=(emp.getEmployeeRole().equals(CommonConstants.ROLE_HOURLY_EMPLOYEES)?
				          CommonConstants.VACATION_HE_DAYS:emp.getEmployeeRole().equals(CommonConstants.ROLE_SALARIED_EMPLOYEES)?
				          CommonConstants.VACATION_SE_DAYS:CommonConstants.VACATION_ME_DAYS);
		if(emp.getEmployeeVacationDays()<0 || emp.getEmployeeVacationDays()> daysCount) {
			returnObjMap.put("returnCode", "1");
			returnObjMap.put("returnMsg", "Vacation Days should positive and do not cross  "+daysCount+" days");
		}else if(emp.getEmployeeWorkDays()<0 || emp.getEmployeeWorkDays()> CommonConstants.MAX_WORK_DAYS) {
			returnObjMap.put("returnCode", "1");
			returnObjMap.put("returnMsg", "Working days should in range 0 to 260 ");
		}else {
		
		returnObjMap.put("data", employeeService.updateEmployeeDetails(emp));
		
		}
		
		if(returnObjMap.get("returnCode").equals("1")) {
			returnObjMap.put("data", employeeService.getAllEmployees());
		}
		return returnObjMap;
	}
}
