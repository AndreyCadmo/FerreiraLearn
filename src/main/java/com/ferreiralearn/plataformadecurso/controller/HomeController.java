package com.ferreiralearn.plataformadecurso.controller;

import com.ferreiralearn.plataformadecurso.model.Course;
import com.ferreiralearn.plataformadecurso.service.CourseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    private final CourseService courseService;

    public HomeController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/")
    public String showHomePage(Model model) {
        List<Course> courses = courseService.findAllCourses();
        model.addAttribute("courses", courses);
        return "home_page";
    }
}