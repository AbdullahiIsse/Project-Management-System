package com.ai.projectmanagement.services;

import com.ai.projectmanagement.dao.UserAccountRepository;
import com.ai.projectmanagement.entities.UserAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserAccountService {


    @Autowired
    UserAccountRepository UserAccountRepo;


    public UserAccount save(UserAccount userAccount){

        return UserAccountRepo.save(userAccount);
    }



}
