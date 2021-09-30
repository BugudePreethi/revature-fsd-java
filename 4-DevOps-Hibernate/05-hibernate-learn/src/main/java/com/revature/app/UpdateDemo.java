package com.revature.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.revature.app.model.Department;

public class UpdateDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        
        session.beginTransaction();
        //Update value in the table
        Department d = new Department();
        d.setId(10);
        d.setName("Sales");
        session.update(d);
        session.getTransaction().commit();
        
        session.close();
	}

}
