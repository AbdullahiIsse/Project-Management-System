package com.ai.projectmanagement.controller;

import com.ai.projectmanagement.dao.EmployeeRepository;
import com.ai.projectmanagement.dao.ProjectRepository;
import com.ai.projectmanagement.dto.EmployeeProject;
import com.ai.projectmanagement.dto.ProjectStage;
import com.ai.projectmanagement.entities.Project;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import java.util.List;

@Controller
public class HomeController {

    @Value("${version}")
    private String ver;


    @Autowired
    ProjectRepository proRepo;

    @Autowired
    EmployeeRepository empRepo;

    @GetMapping("/")
    public String displayHome(Model model) throws JsonProcessingException {

         model.addAttribute("versionNumber", ver);

        //  we are querying the database for projects
        List<Project> project = proRepo.findAll();
        model.addAttribute("projects",project);

        List<ProjectStage> projectStages = proRepo.projectStage();

        // Lets convert projectStage object into json structure for use in javascript

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = objectMapper.writeValueAsString(projectStages);

        model.addAttribute("projectStatusCnt",jsonString);



        //  we are querying the database for employees
        List<EmployeeProject> employeesProjectCount = empRepo.employeeProjects();
        model.addAttribute("employeeListProjectsCnt",employeesProjectCount);
        return "main/home";

    }





}
