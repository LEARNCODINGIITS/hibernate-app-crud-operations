package com.iits.main.hibernate_application;

import java.io.IOException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.iits.main.hibernate_application.dao.HibernateUtill;
import com.iits.main.hibernate_application.entity.Employee;

public class ClientCode {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws IOException {
		 SessionFactory sf=HibernateUtill.sessionFactory();
		 Session session=sf.openSession();
		 	 
		 String query1="From com.iits.main.hibernate_application.entity.Employee e";
		 Query<Employee> query=session.createQuery(query1);
		 List<Employee> listOfEmployees=query.list();
		 for(Employee emp:listOfEmployees) {
			 System.out.println(emp.getId()+"\t"+emp.getName()+"\t"+emp.getSalary());
		 }
		 
		 session.close();
		 sf.close();
	}

}
