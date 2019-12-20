package com.example.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.beans.Employee;

@RestController
@RequestMapping("api/employees/")
public class EmployeeController {

	List<Employee> empList = new ArrayList<>();
	
	@RequestMapping(value="save",method = RequestMethod.POST)
	public int saveEmployee(@RequestBody Employee emp) {
		empList.add(emp);
		return emp.getEmployeeId();
	}
	
	@RequestMapping(value="getDetails",method = RequestMethod.GET)
	public Employee getDetails(@RequestParam(name="empId", required=false, defaultValue="1") String empId) {
		int id = Integer.parseInt(empId);
		return empList.stream().filter(emp -> emp.getEmployeeId()==id).collect(Collectors.toList()).get(0);
	}
	
	@RequestMapping(value="getList",method = RequestMethod.GET)
	public List<Employee> getEmployeeList() {
		return empList;
	}
	
	@RequestMapping(value="removeDetails",method = RequestMethod.DELETE)
	public List<Employee> removeDetails(@RequestParam(name="empId", required=true) String empId) {
		empList.removeIf(e -> e.getEmployeeId() == Integer.parseInt(empId));
		return empList;
	}
	
	@RequestMapping(value="updateDetails",method = RequestMethod.PUT)
	public Employee updateDetails(@RequestBody Employee updateEmp) {
		Employee emp = empList.stream().filter(e -> e.getEmployeeId() == updateEmp.getEmployeeId()).collect(Collectors.toList()).get(0);
		emp.setFirstName(updateEmp.getFirstName());
		emp.setLastName(updateEmp.getLastName());
		return emp;
	}
	

}
