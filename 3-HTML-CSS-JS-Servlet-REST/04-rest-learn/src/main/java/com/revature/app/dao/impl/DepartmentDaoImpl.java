package com.revature.app.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.app.dao.DepartmentDao;
import com.revature.app.dao.Util;
import com.revature.app.model.Department;

public class DepartmentDaoImpl implements DepartmentDao{

	@Override
	public List<Department> list() throws SQLException {
		List<Department> departmentList = new ArrayList<>();
		try (Connection connection = Util.getConnection()) {
			String sql = "SELECT * FROM department";
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery(); 
			while (resultSet.next()) {				
				Department department = new Department();
				department.setId(resultSet.getInt("id"));
				department.setName(resultSet.getString("name"));
				
				departmentList.add(department);
			}
		}
		return departmentList;
	}

}
