package com.revature.app;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.revature.app.model.Department;

public class GetByIdDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        
        session.beginTransaction();
        //Get a table using a primary key
        Department department = session.get(Department.class, 3);
        System.out.println(department);
        
        session.getTransaction().commit();
        
        session.close();
	}

}
