package com.ai.projectmanagement.dao;

import com.ai.projectmanagement.dto.EmployeeProject;
import com.ai.projectmanagement.entities.Employee;
import com.ai.projectmanagement.entities.Project;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "apiemployees",path = "apiemployees")
public interface EmployeeRepository extends PagingAndSortingRepository<Employee,Long> {
    @Override
    public List<Employee> findAll();



    @Query(nativeQuery = true, value = "Select e.first_name as firstName ,e.last_name as lastName, COUNT(p.employee_id) as projectCount " +
            "from employee e left join project_employee p ON e.employee_id = p.employee_id " +
            "GROUP By e.first_name,e.last_name " +
            "ORDER BY 3 DESC")
    public List<EmployeeProject> employeeProjects();


    public Employee findByEmail(String value);

}
