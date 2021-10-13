package com.ai.projectmanagement.controller;

import com.ai.projectmanagement.entities.UserAccount;
import com.ai.projectmanagement.services.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SecurityController {

    @Autowired
    BCryptPasswordEncoder bCryptEncoder;

    @Autowired
    UserAccountService userAccountService;


    @GetMapping("/register")
    public String register(Model model){

        UserAccount userAccount = new UserAccount();
        model.addAttribute("userAccount",userAccount);


        return "Security/register";


    }


    @PostMapping("/register/save")
    public String saveUser(Model model,UserAccount userAccount){
        userAccount.setPassword(bCryptEncoder.encode(userAccount.getPassword()));
        userAccountService.save(userAccount);

        return "redirect:/";

    }
}
