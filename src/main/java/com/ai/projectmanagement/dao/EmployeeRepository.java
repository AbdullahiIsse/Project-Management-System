package com.ai.projectmanagement.dao;

import com.ai.projectmanagement.entities.Employee;
import com.ai.projectmanagement.entities.Project;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee,Long> {
    @Override
    public List<Employee> findAll();


}
