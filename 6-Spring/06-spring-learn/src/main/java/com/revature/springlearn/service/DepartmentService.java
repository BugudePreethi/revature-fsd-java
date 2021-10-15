package com.revature.springlearn.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.springlearn.model.Department;
import com.revature.springlearn.repository.DepartmentRepository;

@Service
public class DepartmentService {
    private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentService.class);
    
    @Autowired
    private DepartmentRepository departmentRepository;
    
    public List<Department> list() {
        LOGGER.info("Start");
        return departmentRepository.findAll();
    }

}