package com.jaitra.dao;

import java.util.List;
import java.util.Set;

import com.jaitra.model.Employee;
import com.jaitra.model.LeaveDetail;
import com.jaitra.model.LeaveSummary;
import com.jaitra.model.Status;

public interface EmployeeDao {

	//public Employee addEmployee(Employee employee);
	public Employee createEmployee(Employee employee);
	public Employee readEmployee(Employee employee);
	public List<Employee> readAllEmployee();
	public Employee deleteEmployee(Employee employee);
	public Employee updateEmployee(Employee employee);



}
