package com.mukesh.controller;

import com.mukesh.forms.UserCreateForm;
import com.mukesh.service.UserService;
import com.mukesh.validators.UserCreateFormValidator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

/**
 * @author mukesh
 *
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserCreateFormValidator userCreateFormValidator;

    @InitBinder("registerForm")
    public void registerFormInitBinder(WebDataBinder binder) {
        binder.addValidators(userCreateFormValidator);
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String processLogin() {
        return "redirect:/";
    }

    @GetMapping("/register")
    public String register(@ModelAttribute("registerForm") UserCreateForm registerForm) {
        return "register";
    }

    @PostMapping("/register")
    public String processRegistration(@Valid @ModelAttribute("registerForm") UserCreateForm registerForm,
                                      BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            return "register";
        }

        userService.registerUser(registerForm);
        return "redirect:/login";
    }



}
