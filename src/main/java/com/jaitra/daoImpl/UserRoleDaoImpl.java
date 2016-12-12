package com.jaitra.daoImpl;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.jaitra.dao.UserRoleDao;
import com.jaitra.model.Status;
import com.jaitra.model.UserRole;
import com.jaitra.utils.BeanCopy;
import com.jaitra.utils.DBUtil;

public class UserRoleDaoImpl implements UserRoleDao {

	/*------------- ADD USER -------------*/
	public UserRole addUserRole(UserRole userRole) {
		
		Session session =  DBUtil.getSession();
		
		Transaction transaction = null;
		Status status = new Status();
		
		String userId = null;
		
		try{
			transaction = session.beginTransaction();
			
			userId = (String) session.save(userRole);
			userRole.setUserId(userId);
			
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
		userRole.setStatus(status);
		return userRole;
	}
	
	
	/*------------- DELETE USER -------------*/

	public UserRole deleteUserRole(UserRole userRole) {
		Session session = DBUtil.getSession();
		Transaction transaction = null;
		Status status = new Status();
		
		try{
			transaction = session.beginTransaction();
			UserRole deleteUser = (UserRole) session.get(UserRole.class, userRole.getUserId());
			
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
		userRole.setStatus(status);
		
		return userRole;
	}
	
	
	/*------------- READ USER -------------*/

	public UserRole readUserRole(UserRole userRole) {
		
		Session session = DBUtil.getSession();
		Transaction transaction = null;
		Status status = new Status();
		
		try {
			transaction = session.beginTransaction();
			
			UserRole readUser = (UserRole) session.get(UserRole.class, userRole.getUserId());
			BeanCopy beanCopy = new BeanCopy();
			beanCopy.copyProperties(userRole, readUser);
			status.setCode(0);
			status.setMessage("Successfully read");
			transaction.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
			status.setCode(-1);
			status.setMessage(e.getMessage());
		}
		userRole.setStatus(status);
		return userRole;
	}
	
}
