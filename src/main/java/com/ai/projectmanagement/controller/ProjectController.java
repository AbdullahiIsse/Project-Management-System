package com.ai.projectmanagement.controller;

import com.ai.projectmanagement.dao.EmployeeRepository;
import com.ai.projectmanagement.dao.ProjectRepository;
import com.ai.projectmanagement.entities.Employee;
import com.ai.projectmanagement.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/projects")
public class ProjectController {

    @Autowired
    ProjectRepository proRepo;

    @Autowired
    EmployeeRepository empRepo;



    @GetMapping()
    public String displayProjectList(Model model){

        List<Project> projectList = proRepo.findAll();
        model.addAttribute("projectsList",projectList);

        return "projects/Project";


    }

    @GetMapping("/new")
    public String displayProjectForm(Model model){
        model.addAttribute("project",new Project());

        List<Employee> employeeList = empRepo.findAll();


        model.addAttribute("allEmployyes",employeeList);
       return "projects/new-project";

    }


    @PostMapping("/save")
    public String CreateProject(Project project, Model model){
           proRepo.save(project);
        // use a redirect to prevent duplicate submissions
           return "redirect:/projects";


    }


}
