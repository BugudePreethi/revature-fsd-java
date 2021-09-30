package com.revature.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.revature.app.model.Department;

public class DeleteDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        
        session.beginTransaction();
        //Delete a row in the table
        Department d = new Department();
        d.setId(6);
        session.remove(d);
        
        session.getTransaction().commit();
        
        session.close();
	}

}
