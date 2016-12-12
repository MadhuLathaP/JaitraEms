package com.jaitra.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DBUtil {

	static SessionFactory factory = null;
	
	public static Session getSession() {

		Session session = null;
		try {

			if(factory == null)
			factory = new Configuration().configure().buildSessionFactory();
			session = factory.openSession();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return session;
	}

	public static void  closeSession(Session closingSession) {
		try {
			if(closingSession != null)
			closingSession.close();
			/*factory.close();*/
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static SessionFactory getFactory() {
		return factory;
	}

	public static void setFactory(SessionFactory factory) {
		DBUtil.factory = factory;
	}
	
	

}
