package com.mukesh.controller.advice;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.mukesh.auth.CustomUserDetails;

@ControllerAdvice
public class CurrentUserAdviceController {

    @ModelAttribute("currentUser")
    public CustomUserDetails getCurrentUser(
            @AuthenticationPrincipal CustomUserDetails customUserDetails) {
        return customUserDetails;
    }
}
