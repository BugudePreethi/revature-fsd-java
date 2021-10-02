package com.revature.app;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.revature.app.model.Employee;

public class GetAllEmployeesDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        
        session.beginTransaction();
        
        //SQL query is executed only once
        String sql = "select e from Employee e inner join fetch e.department inner join fetch e.skillList";
		List<Employee> employeeList = session.createQuery(sql, Employee.class).getResultList();
		Set<Employee> employeeSet = new HashSet(employeeList);
		for (Employee employee : employeeSet) {
			System.out.println(employee.getName());
			System.out.println(employee.getDepartment());
			System.out.println(employee.getSkillList());
		}

        
//        List<Employee> eList = session.createQuery("from Employee", Employee.class).getResultList();
//        for(Employee e : eList) {
//        	System.out.println(e);
//        	System.out.println(e.getName());
//        	System.out.println(e.getDepartment());
//        	System.out.println(e.getSkillList());
//        }
        session.getTransaction().commit();
        
        session.close();

	}

}
