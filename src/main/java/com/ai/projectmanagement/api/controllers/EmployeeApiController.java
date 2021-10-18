package com.ai.projectmanagement.api.controllers;

import com.ai.projectmanagement.dao.EmployeeRepository;
import com.ai.projectmanagement.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/app-api-employees")
public class EmployeeApiController {


    @Autowired
    EmployeeRepository empRepo;




    @GetMapping()
    public List<Employee> getEmployees(){

        return empRepo.findAll();

    }




    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable("id") Long id){
        return empRepo.findById(id).get();
    }

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Employee create(@RequestBody @Valid Employee employee){

       return empRepo.save(employee);

    }



    @PutMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public Employee update(@RequestBody @Valid Employee employee){

       return empRepo.save(employee);


    }

    @PatchMapping(value = "/{id}",consumes = "application/json")
    public Employee partialUpdate(@PathVariable("id") long id,@RequestBody @Valid Employee patchEmployee){

        Employee employee = empRepo.findById(id).get();

        if (patchEmployee.getEmail() != null){
            employee.setEmail(patchEmployee.getEmail());
        }

        if (patchEmployee.getFirstName() != null){
            employee.setFirstName(patchEmployee.getFirstName());
        }


        if (patchEmployee.getLastName() != null){
            employee.setLastName(patchEmployee.getLastName());
        }

        return empRepo.save(employee);


    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") long id){

        try {
            empRepo.deleteById(id);
        }
        catch (EmptyResultDataAccessException e){


        }

    }


    @GetMapping(params = {"page","size"})
    @ResponseStatus(HttpStatus.OK)
    public Iterable<Employee> FindPaginatedEmployees(@RequestParam("page") int page,@RequestParam("size") int size){

        Pageable pageAndSize = PageRequest.of(page,size);

        return empRepo.findAll(pageAndSize);

    }











}
