package com.danovska01.data_validation_demo.controllers;



import com.danovska01.data_validation_demo.models.LoginModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;


@Controller
@RequestMapping("/")
public class LoginController {
     @GetMapping("/login")
    public String displayLoginForm (Model model){
         model.addAttribute("loginModel", new LoginModel());
        return "loginForm.html";
    }

    @PostMapping("/processLogin")
    public String processLogin (@Valid LoginModel loginModel, BindingResult bindingResult, Model model){
         if(bindingResult.hasErrors()){
             model.addAttribute("loginModel", loginModel);
             return "loginForm.html";
         }
        model.addAttribute("loginModel", loginModel);
        return "loginResults.html";
    }
}
