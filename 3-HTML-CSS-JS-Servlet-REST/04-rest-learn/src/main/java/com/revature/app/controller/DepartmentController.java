package com.revature.app.controller;

import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.revature.app.dao.DepartmentDao;
import com.revature.app.dao.impl.DepartmentDaoImpl;
import com.revature.app.model.Department;

@Path("/departments")
public class DepartmentController {
	private DepartmentDao dao = new DepartmentDaoImpl();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response list() {
		List<Department> departmentList;
		try {
			departmentList = dao.list();
			return Response
					.ok()
					.entity(departmentList)
					.build();
		} catch (SQLException e) {
			return Response.status(500).build();
		}
	}
}
