package com.ai.projectmanagement.services;

import com.ai.projectmanagement.dao.EmployeeRepository;
import com.ai.projectmanagement.dto.EmployeeProject;
import com.ai.projectmanagement.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {


    @Autowired
    EmployeeRepository empRepo;


    public Employee save(Employee employee){

        return empRepo.save(employee);

    }

    public List<Employee> findAll(){

        return empRepo.findAll();
    }

    public List<EmployeeProject> employeeProjects(){

        return empRepo.employeeProjects();

    }









}
