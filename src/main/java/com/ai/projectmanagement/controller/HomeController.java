package com.ai.projectmanagement.controller;

import com.ai.projectmanagement.dao.EmployeeRepository;
import com.ai.projectmanagement.dao.ProjectRepository;
import com.ai.projectmanagement.entities.Employee;
import com.ai.projectmanagement.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {


    @Autowired
    ProjectRepository proRepo;

    @Autowired
    EmployeeRepository empRepo;

    @GetMapping("/")
    public String displayHome(Model model){

        //  we are querying the database for projects
        List<Project> projects = proRepo.findAll();
        model.addAttribute("projectsList",projects);

        //  we are querying the database for employees
        List<Employee> employees = empRepo.findAll();
        model.addAttribute("employeeList",employees);
        return "main/home";

    }





}
