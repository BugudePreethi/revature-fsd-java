package com.revature.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.revature.app.model.Employee;

public class GetEmployeeDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        
        session.beginTransaction();
        
        Employee e = session.get(Employee.class, 1);
        System.out.println(e);
//        System.out.println(e.getName());
//        System.out.println(e.getDepartment());
//        System.out.println(e.getSkillList());
        
        session.getTransaction().commit();
        
        session.close();
	}

}
