package com.ai.projectmanagement.controller;


import com.ai.projectmanagement.dao.EmployeeRepository;
import com.ai.projectmanagement.dao.ProjectRepository;
import com.ai.projectmanagement.entities.Employee;
import com.ai.projectmanagement.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")

public class APIController {

    @Autowired
    EmployeeRepository empRepo;

    @GetMapping("/test")
    public ResponseEntity<List<Employee>>getAllEmployees(){

        List<Employee> employeeList = empRepo.findAll();
      

        return new ResponseEntity<List<Employee>>(employeeList, HttpStatus.OK);


    }







}
