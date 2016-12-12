package com.jaitra.daoImpl;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.jaitra.dao.UserDao;
import com.jaitra.model.Status;
import com.jaitra.model.User;
import com.jaitra.utils.BeanCopy;
import com.jaitra.utils.DBUtil;

public class UserDaoImpl implements UserDao {

	
	/*------------- ADD USER -------------*/
	public User addUser(User user) {
		
		Session session =  DBUtil.getSession();
		
		Transaction transaction = null;
		Status status = new Status();
		
		String userId = null;
		
		try{
			transaction = session.beginTransaction();
			
			userId = (String) session.save(user);
			user.setUserId(userId);
			
			transaction.commit();
			status.setCode(0);
			status.setMessage("Successfully created");
		}catch(Exception e){
			e.printStackTrace();
			status.setCode(-1);
			status.setMessage(e.getMessage());
			transaction.rollback();
		}finally {
			DBUtil.closeSession(session);
		}
		user.setStatus(status);
		return user;
	}
	
	
	/*------------- DELETE USER -------------*/

	public User deleteUser(User user) {
		Session session = DBUtil.getSession();
		Transaction transaction = null;
		Status status = new Status();
		
		try{
			transaction = session.beginTransaction();
			User deleteUser = (User) session.get(User.class, user.getUserId());
			
			session.delete(deleteUser);
			
			status.setCode(0);
			status.setMessage("Successfully Deleted");
			
			transaction.commit();
			
		}catch(Exception e){
			e.printStackTrace();
			status.setCode(-1);
			status.setMessage(e.getMessage());
		}finally {
			DBUtil.closeSession(session);
		}
		user.setStatus(status);
		
		return user;
	}
	
	
	/*------------- READ USER -------------*/

	public User readUser(User user) {
		
		Session session = DBUtil.getSession();
		Transaction transaction = null;
		Status status = new Status();
		
		try {
			transaction = session.beginTransaction();
			
			User readUser = (User) session.get(User.class, user.getUserId());
			BeanCopy beanCopy = new BeanCopy();
			beanCopy.copyProperties(user, readUser);
			status.setCode(0);
			status.setMessage("Successfully read");
			transaction.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
			status.setCode(-1);
			status.setMessage(e.getMessage());
		}
		user.setStatus(status);
		return user;
	}
	
	
	/*------------- READ ALL USER -------------*/

	public List<User> readAllUser() {

		Session session = DBUtil.getSession();
		
		Status status = new Status();
		Transaction transaction = null;
		List<User> users = null;
		try {
			transaction = session.beginTransaction();

			users = session.createQuery("from User").list();
			status.setCode(0);
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
		return users;
	}
	
	
	/*------------- UPDATE USER -------------*/
	
	public User updateUser(User user) {
		
		Session session = DBUtil.getSession();
		Transaction transaction = null;
		Status status = new Status();
		
		try {
			transaction = session.beginTransaction();
			
			User updateUser = (User) session.get(User.class, user.getUserId());
			BeanCopy beanCopy = new BeanCopy();
			beanCopy.copyProperties(updateUser, user);
			session.update(updateUser);
			status.setCode(0);
			status.setMessage("Successfully read");
			transaction.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
			status.setCode(-1);
			status.setMessage(e.getMessage());
		}
		user.setStatus(status);
		return user;
	}
	
	
	public String getCurrentDate() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate localDate = LocalDate.now();
		String date = dtf.format(localDate);
		return date;
	}
}
