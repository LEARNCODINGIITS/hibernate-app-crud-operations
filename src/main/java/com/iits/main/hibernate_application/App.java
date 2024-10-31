package com.iits.main.hibernate_application;

import java.io.IOException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import com.iits.main.hibernate_application.dao.HibernateUtill;
import com.iits.main.hibernate_application.entity.Employee;

public class App {
	public static void main(String[] args) throws IOException {
		// Step1 & Step2
		SessionFactory sf = HibernateUtill.sessionFactory();
		// Step3:Get the session
		Session session = sf.openSession();
		/*
		 * We are getting the session object in order perform the operations like
		 * insert,update,delete,retrieve Note: In order to perform insert,update,delete
		 * we need get the transaction object
		 */
		// Step4: Begin the transaction
		Transaction tx = session.beginTransaction();
		// insertData(sf, session, tx);
		// deleteData(sf,session,tx);
		// retrieve(sf,session);
		update(sf, session, tx);

	}

	@SuppressWarnings("deprecation")
	public static void update(SessionFactory sf, Session session, Transaction tx) {
		Employee employee = new Employee();// <--- data set
		session.load(employee, 2);// select * from employee where eid=2---> db
		employee.setSalary(employee.getSalary() + 10000.00);// data update

		session.update(employee);// --> update employee set salary=510000.00 where eid=2

		tx.commit();// update
		session.close();
		sf.close();

	}

	@SuppressWarnings("deprecation")
	public static void retrieve(SessionFactory sf, Session session) {

		// Get the Record from the database:
		// 1.void load(Object, Serilizable)
		// 1.1.Object load(Class, Serializable)
		// 2. Object get(Class,Serializable
		// Employee emp=new Employee();
		// session.load(emp,21);
		Employee emp = session.get(Employee.class, 12);
		if (emp != null)
			System.out.println(emp);
		else
			System.err.println("Id is not found");
		session.close();
		sf.close();
	}

	public static void deleteData(SessionFactory sf, Session session, Transaction tx) {

		// delete
		Employee employee = new Employee();
		employee.setId(3);
		session.remove(employee);
		tx.commit();
		session.close();
		sf.close();

	}

	public static void insertData(SessionFactory sf, Session session, Transaction tx) {
		try {
			// Insert the Record
			// Create the Employee object and set the data
			Employee employee = new Employee();
			employee.setId(3);
			employee.setName("SRK1");
			employee.setSalary(600000.00);
			session.persist(employee);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		} finally {
			session.close();
			sf.close();
		}
	}
}
