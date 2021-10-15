package com.revature.springlearn.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.springlearn.model.Department;
import com.revature.springlearn.service.DepartmentService;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

    @Autowired
    private DepartmentService departmentService;
    
    @GetMapping
    public List<Department> getDepartmentList() {
        return departmentService.list();
    }

}