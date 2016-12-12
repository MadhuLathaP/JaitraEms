package com.jaitra.test;

import java.util.List;

import com.jaitra.dao.UserDao;
import com.jaitra.daoImpl.UserDaoImpl;
import com.jaitra.model.Employee;
import com.jaitra.model.User;
import com.jaitra.utils.DBUtil;

public class ManageUser {
	public static void main(String[] args) {

		ManageUser manageUser = new ManageUser();

		manageUser.addUser();
		//manageUser.deleteUser();
		//manageUser.readUser();

		manageUser.readAllUser();
		//manageUser.updateUser();

		DBUtil.getFactory().close();

	}

	private void updateUser() {
		// TODO Auto-generated method stub
		UserDao userDao = new UserDaoImpl();
		User user = new User();
		
		
		user.setPassword("user");
		user.setLastUpdate("09/12/2016");
		user.setUserId("12");
		userDao.updateUser(user);
	}

	private void readAllUser() {
		// TODO Auto-generated method stub
		UserDao userDao = new UserDaoImpl();
		User user = new User();
		
		List<User> userList = userDao.readAllUser();
		
		for(User u : userList){
	        System.out.println("User Id: " + u.getUserId()); 
	        System.out.println("Password: " + u.getPassword()); 
	        System.out.println("Last Update: " + u.getLastUpdate()); 
		}

	}

	private void deleteUser() {
		// TODO Auto-generated method stub
		UserDao userDao = new UserDaoImpl();
		User user = new User();
		
		user.setUserId("12");
		
		userDao.deleteUser(user);
	}

	private void readUser() {
		// TODO Auto-generated method stub
		UserDao userDao = new UserDaoImpl();
		User user = new User();
		
		user.setUserId("12");
		
		user = userDao.readUser(user);
        System.out.println("User Id: " + user.getUserId()); 
        System.out.println("Password: " + user.getPassword()); 
        System.out.println("Last Update: " + user.getLastUpdate()); 
	}

	private void addUser() {
		// TODO Auto-generated method stub
		UserDao userDao = new UserDaoImpl();
		User user = new User();
		
		user.setUserId("12");
		user.setPassword("user");
		user.setLastUpdate("10/12/2016");
		
		userDao.addUser(user);
	}
}
