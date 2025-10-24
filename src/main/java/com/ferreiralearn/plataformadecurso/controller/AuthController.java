package com.ferreiralearn.plataformadecurso.controller;

import com.ferreiralearn.plataformadecurso.model.User;
import com.ferreiralearn.plataformadecurso.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    private boolean isAuthenticated() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || authentication.getPrincipal().equals("anonymousUser")) {
            return false;
        }
        return authentication.isAuthenticated();
    }

    @GetMapping("/login")
    public String showLoginPage(Model model) {
        if (isAuthenticated()) {
            return "redirect:/";
        }
        model.addAttribute("user", new User());
        return "login_page";
    }

    @GetMapping("/register")
    public String showRegistrationRedirect() {
        if (isAuthenticated()) {
            return "redirect:/";
        }
        return "redirect:/login#register";
    }

    @PostMapping("/register")
    public String processRegistration(@ModelAttribute("user") User user) {
        try {
            userService.registerUser(user);
        } catch (RuntimeException e) {
            return "redirect:/login?regError#register";
        }
        return "redirect:/login?success";
    }
}