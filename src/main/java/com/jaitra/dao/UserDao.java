package com.jaitra.dao;

import java.util.List;

import com.jaitra.model.User;

public interface UserDao {

	public User addUser(User user);
	public User deleteUser(User user);
	public User readUser(User user);
	public List<User> readAllUser();
	public User updateUser(User user);
	
	public String getCurrentDate();
}
