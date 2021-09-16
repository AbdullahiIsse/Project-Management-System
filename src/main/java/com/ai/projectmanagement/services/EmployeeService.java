package com.ai.projectmanagement.services;

import com.ai.projectmanagement.dao.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    //field injection
    @Autowired
    @Qualifier("staffRepositoryImpl1")
    StaffRepository empRepo;



    // constructor injection
    public EmployeeService( @Qualifier("staffRepositoryImpl1")StaffRepository empRepo) {
        this.empRepo = empRepo;
    }



    @Autowired // setter injection
    public void setEmpRepo( @Qualifier("staffRepositoryImpl1")StaffRepository empRepo) {
        this.empRepo = empRepo;
    }
}
