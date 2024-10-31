package com.iits.main.hibernate_application.dao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtill {
	static SessionFactory sf;
	static {
		// Step1: Create the Configuration object
		Configuration cfg = new Configuration();
		// Step2: Invoke the configure() method
		cfg.configure();// internally search for hibernate.cfg.xml file
		// Step3: Get the SessionFactory object
		sf = cfg.buildSessionFactory();
	}

	public static SessionFactory sessionFactory() {
		return sf;
	}

}
