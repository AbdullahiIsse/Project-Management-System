package com.ai.projectmanagement.services;

import com.ai.projectmanagement.dao.ProjectRepository;
import com.ai.projectmanagement.dto.ProjectStage;
import com.ai.projectmanagement.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    @Autowired
    ProjectRepository proRepo;




    public Project save(Project project){

        return proRepo.save(project);
    }



    public List<Project> findAll() {

        return proRepo.findAll();
    }


    public List<ProjectStage> projectStage(){

        return proRepo.projectStage();

    }

    public Project findById(long id){
        return proRepo.findById(id).get();
    }


    public void deleteById(long id){
        proRepo.deleteById(id);
    }







}
