package com.ai.projectmanagement.controller;

import com.ai.projectmanagement.entities.Employee;
import com.ai.projectmanagement.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    EmployeeService empService;


    @GetMapping()
    public String displayEmployeeList(Model model){

        List<Employee> employeeList = empService.findAll();
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
        empService.save(employee);
        // use a redirect to prevent duplicate submissions
        return "redirect:/employees";

    }

    @GetMapping("/update")
    public String updateEmployee(@RequestParam long id,Model model){

        Employee employee = empService.findById(id);

        model.addAttribute("employee",employee);

        return "employees/new-employee";


    }


    @GetMapping("/delete")
    public String deleteEmployee(@RequestParam long  id,Model model){

        Employee employee1 = empService.findById(id);

        empService.deleteById(employee1.getEmployeeId());


        return "redirect:/employees";


    }





}
