package com.jaitra.dao;

import com.jaitra.model.UserRole;

public interface UserRoleDao {
	
	public UserRole addUserRole(UserRole userRole);
	public UserRole deleteUserRole(UserRole userRole);
	public UserRole readUserRole(UserRole userRole);
	
}
