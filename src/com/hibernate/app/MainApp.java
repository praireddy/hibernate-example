package com.hibernate.app;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.model.EmployeeModel;

public class MainApp {
	public static void main( String[] args )
	{
		System.out.println("Maven + Hibernate + MySQL");
		SessionFactory sf=new Configuration().configure().buildSessionFactory();

		//Session session = HibernateUtil.getSessionFactory().openSession();
		Session session=sf.openSession();
		session.beginTransaction();
		EmployeeModel emp = new EmployeeModel();
		emp.setId(600);
		emp.setName("Mounika");
		session.save(emp);

		session.getTransaction().commit();
		System.out.println("Data Inserted Successfully------>");

		//To read data


		Query query = session.createQuery("from EmployeeModel");
		List<EmployeeModel> employees = query.list();
		for(EmployeeModel employee : employees)
		{
			System.out.println("ID: "+employee .getId()+", Employee Name: "+employee .getName());
		}

	}
}

