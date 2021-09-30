package com.revature.app.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.revature.app.dao.EmployeeDao;
import com.revature.app.dao.impl.EmployeeDaoImpl;
import com.revature.app.model.Department;
import com.revature.app.model.Employee;

@Path("/employees")
public class EmployeeController {
	EmployeeDao dao = new EmployeeDaoImpl();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response list() {
		List<Employee> employeeList;
		try {
			employeeList = dao.list();
			return Response
					.ok()
					.entity(employeeList)
					.build();
		} catch (SQLException e) {
			return Response.status(500).build();
		}

	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response get(@PathParam("id") int id) {
		System.out.println("Employee ID: " + id);
		Employee employee1 = new Employee();
		employee1.setId(1);
		employee1.setName("John");
		employee1.setGender('M');
		employee1.setSalary(5000);
		Department department = new Department();
		department.setId(1);
		department.setName("Manufacturing");
		employee1.setDepartment(department);

		return Response.ok().entity(employee1).build();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response create(Employee employee) {
		try {
			dao.create(employee);
			return Response.ok().build();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Response.status(500).build();
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response update(Employee employee) {
		System.out.println("PUT");
		System.out.println(employee);
		return Response.ok().build();
	}

	@DELETE
	@Path("/{id}")
	public Response delete(@PathParam("id") int id) {
		System.out.println("Employee ID to delete: " + id);
		return Response.ok().build();
	}

}
