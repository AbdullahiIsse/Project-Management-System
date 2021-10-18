package com.ai.projectmanagement.api.controllers;

import com.ai.projectmanagement.dao.ProjectRepository;
import com.ai.projectmanagement.entities.Employee;
import com.ai.projectmanagement.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/app-api-projects")
public class ProjectApiController {

    @Autowired
    ProjectRepository proRepo;





    @GetMapping()
    public List<Project>getAllEmployees(){

        return proRepo.findAll();
    }


    @GetMapping("/{id}")
    public Project getProjectById(@PathVariable("id") long id){
        return proRepo.findById(id).get();
    }



    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Project create(@RequestBody @Valid Project project){
        return proRepo.save(project);
    }


    @PutMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public Project update(@RequestBody @Valid Project project){
        return proRepo.save(project);
    }


    @PatchMapping(value = "/{id}",consumes = "application/json")
    public Project partialUpdate(@PathVariable("id") long id,@RequestBody @Valid Project patchProject){

       Project project = proRepo.findById(id).get();

        if (patchProject.getName() != null){
            project.setName(patchProject.getName());
        }

        if (patchProject.getStage() != null){
            project.setStage(patchProject.getStage());
        }


        if (patchProject.getDescription() != null){
            project.setDescription(patchProject.getDescription());
        }

        return proRepo.save(project);

    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") long id){

        proRepo.deleteById(id);

    }


    @GetMapping(params = {"page","size"})
    @ResponseStatus(HttpStatus.OK)
    public Iterable<Project> FindPaginatedEmployees(@RequestParam("page") int page, @RequestParam("size") int size){

        Pageable pageAndSize = PageRequest.of(page,size);

        return proRepo.findAll(pageAndSize);

    }







}
