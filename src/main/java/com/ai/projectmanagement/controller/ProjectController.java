package com.ai.projectmanagement.controller;

import com.ai.projectmanagement.entities.Employee;
import com.ai.projectmanagement.entities.Project;
import com.ai.projectmanagement.services.EmployeeService;
import com.ai.projectmanagement.services.ProjectService;
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
    ProjectService proService;

    @Autowired
    EmployeeService empService;



    @GetMapping()
    public String displayProjectList(Model model){

        List<Project> projectList = proService.findAll();
        model.addAttribute("projectsList",projectList);

        return "projects/Project";


    }

    @GetMapping("/new")
    public String displayProjectForm(Model model){
        model.addAttribute("project",new Project());

        List<Employee> employeeList = empService.findAll();


        model.addAttribute("allEmployyes",employeeList);
       return "projects/new-project";

    }


    @PostMapping("/save")
    public String CreateProject(Project project, Model model){
           proService.save(project);
        // use a redirect to prevent duplicate submissions
           return "redirect:/projects";


    }

    @GetMapping("/update")
    public String updateProjects(@RequestParam long id,Model model){

       Project project = proService.findById(id);


       model.addAttribute("project",project);

        List<Employee> all = empService.findAll();

        model.addAttribute("allEmployyes",all);



        return "projects/new-project";
    }


    @GetMapping("/delete")
    public String deleteProject(@RequestParam long id,Model model){

        Project project = proService.findById(id);

        proService.deleteById(project.getProjectId());


        return "redirect:/projects";
    }









}
