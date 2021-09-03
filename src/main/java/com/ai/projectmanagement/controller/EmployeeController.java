package com.ai.projectmanagement.controller;

import com.ai.projectmanagement.dao.EmployeeRepository;
import com.ai.projectmanagement.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    EmployeeRepository empRepo;


    @GetMapping()
    public String displayEmployeeList(Model model){

        List<Employee> employeeList = empRepo.findAll();
        model.addAttribute("employeeList",employeeList);

        return "employees/Employee";

    }


    @GetMapping("/new")
    public String displayEmployeeForm(Model model){

        model.addAttribute("employee",new Employee());
        return "employees/new-employee";

    }


    @PostMapping("/save")
    public String AddEmployee(Employee employee,Model model){
        empRepo.save(employee);
        // use a redirect to prevent duplicate submissions
        return "redirect:/employees/new";


    }





}
