package com.jaitra.test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.jaitra.dao.EmployeeDao;
import com.jaitra.dao.LeaveSummaryDao;
import com.jaitra.daoImpl.EmployeeDaoImpl;
import com.jaitra.daoImpl.LeaveSummaryDaoImpl;
import com.jaitra.model.Employee;
import com.jaitra.model.LeaveDetail;
import com.jaitra.model.LeaveSummary;
import com.jaitra.model.Status;
import com.jaitra.utils.DBUtil;

public class ManageEmployee {

	public static void main(String[] args) {

	ManageEmployee manageEmployee = new ManageEmployee();
		
		manageEmployee.createEmployee();
		//manageEmployee.deleteEmployee();
		//manageEmployee.updateEmployee();
	
		//manageEmployee.readEmployee();
		//manageEmployee.readAllEmployee();
		
		DBUtil.getFactory().close(); 

	}

	public void readEmployee() {
		EmployeeDao employeeDao = new EmployeeDaoImpl();

		Employee employee = new Employee();
		employee.setEmployeeId("2");
		
		employee = employeeDao.readEmployee(employee);
        System.out.println("Employee Id: " + employee.getEmployeeId()); 
        System.out.println("First Name: " + employee.getFirstName()); 
        System.out.println("Last Name: " + employee.getLastName()); 
        System.out.println("DateOfBirth: " + employee.getDateOfBirth()); 
        System.out.println("DateOfJoining: " + employee.getDateOfJoining()); 
        System.out.println("Email: " + employee.getEmail()); 
        System.out.println("Address: " + employee.getAddress()); 
	}

	public void createEmployee() {
		
		EmployeeDao employeeDao = new EmployeeDaoImpl();
		
		Employee employee1 = new Employee();
		
		employee1.setEmployeeId("2");
		employee1.setFirstName("Zara");
		employee1.setLastName("Ali");
		employee1.setDateOfBirth("10/05/1990");
		employee1.setDateOfJoining("05/02/2016");
		employee1.setEmail("zaraali@gmail.com");
		employee1.setAddress("xyz");
		employee1.setPan("XZHh459656D554");
		employee1.setDesignation("ac");
		employee1.setAccountNo("69989654555");
		
		Employee returnEmp = employeeDao.createEmployee(employee1);

		System.out.println(returnEmp);

	}

	public void readAllEmployee() {
		EmployeeDao employeeDao = new EmployeeDaoImpl();

/*		Employee employee = new Employee();
		employee.setId(1);*/
		//List<Employee> empList=null;
		
		List<Employee> empList=employeeDao.readAllEmployee();
		System.out.println(empList);
		for(Employee e:empList)
		{
        System.out.println("Employee Id: " + e.getEmployeeId()); 
        System.out.println("First Name: " + e.getFirstName()); 
        System.out.println("Last Name: " + e.getLastName()); 
        System.out.println("DateOfBirth: " + e.getDateOfBirth()); 
        System.out.println("DateOfJoining: " + e.getDateOfJoining()); 
        System.out.println("Email: " + e.getEmail()); 
        System.out.println("Address: " + e.getAddress()); 
		}
	}

	public void deleteEmployee() {
		EmployeeDao employeeDao = new EmployeeDaoImpl();

		Employee emp = new Employee();
		emp.setId(2);
		employeeDao.deleteEmployee(emp);

		
	}
	
	public void updateEmployee() {
		EmployeeDao employeeDao = new EmployeeDaoImpl();

		Employee employee1 = new Employee();
		employee1.setEmployeeId("4");
		employee1.setFirstName("abc");
		employee1.setLastName("Zara");
		employee1.setDateOfBirth("10/05/1990");
		employee1.setDateOfJoining("05/02/2016");
		employee1.setEmail("kjajZara@gmail.com");
		employee1.setAddress("fdg");

		employee1.setId(1);
		employeeDao.updateEmployee(employee1);
	}


}