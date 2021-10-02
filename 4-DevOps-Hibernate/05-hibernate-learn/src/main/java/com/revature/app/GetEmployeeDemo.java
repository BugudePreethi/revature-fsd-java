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
        System.out.println("Transient at department and skill");
        System.out.println(e.getName());
        System.out.println("Transient at skill");
        System.out.println(e.getDepartment());
        System.out.println("Transient are removed");
        System.out.println(e.getSkillList());
        System.out.println("Employee Skill");
        System.out.println(e);
        session.getTransaction().commit();
        
        session.close();
	}

}
