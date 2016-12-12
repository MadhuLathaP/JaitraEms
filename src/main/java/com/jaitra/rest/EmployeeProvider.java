package com.jaitra.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.jaitra.dao.EmployeeDao;
import com.jaitra.daoImpl.EmployeeDaoImpl;
import com.jaitra.model.Employee;

@Path("employee")
public class EmployeeProvider {
	
	@POST
	@Path("create")
	@Produces(MediaType.APPLICATION_JSON)
	public Employee createEmployee(Employee employee) {
		EmployeeDao employeeDao = new EmployeeDaoImpl();
		Employee returnEmployee = employeeDao.createEmployee(employee);
		System.out.println("Employee create");
		return returnEmployee;
	}
	
	
	@POST
	@Path("read")
	@Produces(MediaType.APPLICATION_JSON)
	public Employee readEmployee(Employee employee) {
		EmployeeDao employeeDao = new EmployeeDaoImpl();
		Employee returnEmployee = employeeDao.readEmployee(employee);
		System.out.println("Employee read");
		return returnEmployee;
	}
	
	
	@GET
	@Path("readAll")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Employee> readAllEmployee() {
		EmployeeDao employeeDao = new EmployeeDaoImpl();
		List<Employee> returnEmployee = employeeDao.readAllEmployee();
		return returnEmployee;
	}
	
	
	@POST
	@Path("update")
	@Produces(MediaType.APPLICATION_JSON)
	public Employee updateEmployee(Employee employee) {
		EmployeeDao employeeDao = new EmployeeDaoImpl();
		Employee returnEmployee = employeeDao.updateEmployee(employee);
		System.out.println("Employee updated");
		return returnEmployee;
	}
	
	
	@POST
	@Path("delete")
	@Produces(MediaType.APPLICATION_JSON)
	public Employee deleteEmployee(Employee employee) {
		EmployeeDao employeeDao = new EmployeeDaoImpl();
		Employee returnEmployee = employeeDao.deleteEmployee(employee);
		System.out.println("Employee deleted");
		return returnEmployee;
	}
	
	
}
