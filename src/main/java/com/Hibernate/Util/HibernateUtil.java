package com.Hibernate.Util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static final SessionFactory sessionFactory = builSessionFactory();
	
	private static SessionFactory builSessionFactory() {
		try {
			return new Configuration().configure().buildSessionFactory(); //Créé la SessionFactory depuis hibernate.cfg.xml
		} catch (Exception ex) {
			System.out.println("SessionFactoty creaton failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionfactory() {
		return sessionFactory;
	}
	
	public static void shutdown() {
		getSessionfactory().close();
	}
	
	
}
