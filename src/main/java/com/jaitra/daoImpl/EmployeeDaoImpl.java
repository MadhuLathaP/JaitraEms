package com.jaitra.daoImpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.jaitra.dao.EmployeeDao;
import com.jaitra.dao.LeaveSummaryDao;
import com.jaitra.dao.UserDao;
import com.jaitra.dao.UserRoleDao;
import com.jaitra.model.Employee;
import com.jaitra.model.LeaveSummary;
import com.jaitra.model.Status;
import com.jaitra.model.User;
import com.jaitra.model.UserRole;
import com.jaitra.utils.BeanCopy;
import com.jaitra.utils.DBUtil;

public class EmployeeDaoImpl implements EmployeeDao {

	/* Add Employee */

	public Employee createEmployee(Employee employee) {
		Session session = DBUtil.getSession();
		
		Status status = new Status();

		Transaction transaction = null;
		Integer empId = null;

		try {
			transaction = session.beginTransaction();

			empId = (Integer) session.save(employee);

			employee.setId(empId);
			
			//preparing leave summary
			LeaveSummaryDao leaveSummaryDao = new LeaveSummaryDaoImpl();
			LeaveSummary leaveSummary = new LeaveSummary();
			
			//as if hard code n0w replace with business logic
			leaveSummary.setEmpId(empId);
			leaveSummary.setCasualLeave(15);
			leaveSummary.setSickLeave(5);
			leaveSummary.setCasualLeaveUsed(0);
			leaveSummary.setSickLeaveUsed(0);
			leaveSummary.setTotalLeaveUsed(0);
			leaveSummary.setTotalLeave(20);
			
			leaveSummaryDao.createLeaveSummary(leaveSummary);
			
			// Add user as well , userid and password should be employee id
			UserDao userDao = new UserDaoImpl();
			User user = new User();
			
			user.setUserId(employee.getEmployeeId());
			user.setPassword(employee.getEmployeeId());
			user.setLastUpdate(userDao.getCurrentDate());
			
			userDao.addUser(user);
			
			// add user role 
			UserRoleDao userRoleDao = new UserRoleDaoImpl();
			UserRole userRole = new UserRole();
			
			userRole.setUserId(employee.getEmployeeId());
			userRole.setRole("Employee");
			
			userRoleDao.addUserRole(userRole);
			
			
			transaction.commit();
			status.setCode(0);
			status.setMessage("Successfully created");

		} catch (HibernateException e) {
			status.setCode(-1);
			status.setMessage(e.getMessage());
			transaction.rollback();
		} finally {
			DBUtil.closeSession(session);

		}
		
		employee.setStatus(status);
		
		return employee;
	}

	@Override
	public Employee deleteEmployee(Employee employee) {
		// TODO Auto-generated method stub
		Session session = DBUtil.getSession();

		Status status = new Status();

		Transaction transaction = null;
		int empId = employee.getId();
		
		try {
			transaction = session.beginTransaction();
			Employee deletingEmployee = (Employee) session.get(Employee.class, employee.getId());
			session.delete(deletingEmployee);
			//preparing leave summary
		
			LeaveSummaryDao leaveSummaryDao = new LeaveSummaryDaoImpl();
			LeaveSummary leaveSummary = new LeaveSummary();
			
			//as if hard code n0w replace with business logic
			leaveSummary.setEmpId(empId);
			
			leaveSummaryDao.deleteLeaveSummary(leaveSummary);
			status.setCode(0);
			status.setMessage("Successfully deleted");
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			status.setCode(-1);
			status.setMessage(e.getMessage());
		} finally {
			DBUtil.closeSession(session);
		}
		employee.setStatus(status);
		return employee;
	}

	@Override
	public List<Employee> readAllEmployee() {
		// TODO Auto-generated method stub
		Session session = DBUtil.getSession();
		
		Status status = new Status();
		Transaction transaction = null;
		List<Employee> employees = null;
		try {
			transaction = session.beginTransaction();

			employees = session.createQuery("from Employee").list();
			status.setCode(0);
			status.setMessage("Successfully read");

			transaction.commit();
		} catch (Exception e) {
			if (transaction != null)
				transaction.rollback();
			status.setCode(-1);
			status.setMessage(e.getMessage());
		} finally {
			DBUtil.closeSession(session);
		}
		return employees;
	}

	@Override
	public Employee readEmployee(Employee employee) {
		// TODO Auto-generated method stub

		Session session = DBUtil.getSession();
		Transaction transaction = null;
		
		Status status = new Status();
		
		try {
			transaction = session.beginTransaction();
		Query query=session.getNamedQuery("byId");
		System.out.println("queries"+query);
		query.setString("id",employee.getEmployeeId());
		employee =	(Employee)query.uniqueResult();
		System.out.println("list is"+employee);
			/*Employee idEmployee = (Employee) session.get(Employee.class, employee.getEmployeeId());
			BeanCopy beanCopy = new BeanCopy();
			beanCopy.copyProperties(employee, idEmployee);
			status.setCode(0);*/
			status.setMessage("Successfully read");
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
			status.setCode(-1);
			status.setMessage(e.getMessage());
		} finally {
			DBUtil.closeSession(session);
		}
		employee.setStatus(status);
		return employee;
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		Session session = DBUtil.getSession();
		Employee updateEmployee = null;;
		Status status = new Status();

		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			updateEmployee = (Employee) session.get(Employee.class, employee.getId());
			BeanCopy beanCopy = new BeanCopy();
			beanCopy.copyProperties(updateEmployee, employee);
			session.update(updateEmployee);

			status.setCode(0);
			status.setMessage("Successfully updated");
			
			transaction.commit();
		} catch (Exception e) {
			status.setCode(-1);
			status.setMessage(e.getMessage());
			transaction.rollback();

		} finally {
			session.close();
		}
		employee.setStatus(status);
		return employee;
	}
	
/*	public String Employee_leave(Employee employee) throws ParseException {
		  String date = employee.getDateOfJoining();
		  Date date1;
		  DateFormat formatter = new SimpleDateFormat("yyyy/MM/dd"); 
		  date1=(Date)formatter.parse(date);
		     Calendar cal = Calendar.getInstance();
		     cal.setTime(date1);
		     int month = cal.get(Calendar.MONTH);
		     return calculatebalance(month);
		  
		 }

	public String calculatebalance(int month) {
		  DecimalFormat df = new DecimalFormat("###.##");
		        float i= ((12-month)*((float)17/12));
		        return df.format(i);
		  
		 }*/
}
