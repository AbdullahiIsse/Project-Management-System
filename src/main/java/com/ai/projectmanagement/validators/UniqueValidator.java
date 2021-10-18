package com.ai.projectmanagement.validators;

import com.ai.projectmanagement.dao.EmployeeRepository;
import com.ai.projectmanagement.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueValidator implements ConstraintValidator<UniqueValue,String> {



    @Autowired
    EmployeeRepository empRepo;




    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {

        System.out.println("Entered validation method...");
        Employee employee = empRepo.findByEmail(s);

        if (employee != null)
            return  false;
        else
         return true;


    }
}
