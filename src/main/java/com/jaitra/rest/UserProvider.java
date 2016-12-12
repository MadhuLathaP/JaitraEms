package com.jaitra.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.jaitra.dao.UserDao;
import com.jaitra.daoImpl.UserDaoImpl;
import com.jaitra.model.User;

@Path("user")
public class UserProvider {
	@POST
	@Path("create")
	@Produces(MediaType.APPLICATION_JSON)
	public User addUser(User user) {
		UserDao userDao = new UserDaoImpl();
		User returnUser = userDao.addUser(user);
		System.out.println("Employee create");
		return returnUser;
	}
	
	
	@POST
	@Path("read")
	@Produces(MediaType.APPLICATION_JSON)
	public User readUser(User user) {
		UserDao userDao = new UserDaoImpl();
		User returnUser = userDao.readUser(user);
		System.out.println("Employee read");
		return returnUser;
	}
	
	
	@GET
	@Path("readAll")
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> readAllUser() {
		UserDao userDao = new UserDaoImpl();
		List<User> returnUser = userDao.readAllUser();
		return returnUser;
	}
	
	
	@POST
	@Path("update")
	@Produces(MediaType.APPLICATION_JSON)
	public User updateUser(User user) {
		UserDao userDao = new UserDaoImpl();
		User returnUser = userDao.updateUser(user);
		System.out.println("Employee updated");
		return returnUser;
	}
	
	
	@POST
	@Path("delete")
	@Produces(MediaType.APPLICATION_JSON)
	public User deleteEmployee(User user) {
		UserDao userDao = new UserDaoImpl();
		User returnEmployee = userDao.deleteUser(user);
		System.out.println("Employee deleted");
		return returnEmployee;
	}

}
