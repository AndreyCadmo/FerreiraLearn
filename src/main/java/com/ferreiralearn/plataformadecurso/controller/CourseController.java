package com.ferreiralearn.plataformadecurso.controller;

import com.ferreiralearn.plataformadecurso.model.Course;
import com.ferreiralearn.plataformadecurso.model.Lesson;
import com.ferreiralearn.plataformadecurso.service.CourseService;
import com.ferreiralearn.plataformadecurso.service.LessonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CourseController {

    private final CourseService courseService;
    private final LessonService lessonService;

    public CourseController(CourseService courseService, LessonService lessonService) {
        this.courseService = courseService;
        this.lessonService = lessonService;
    }

    @GetMapping("/course/{courseId}/lesson/{lessonId}")
    public String getLessonPage(@PathVariable Long courseId,
                                @PathVariable Long lessonId,
                                Model model) {

        Course course = courseService.findById(courseId);
        Lesson lesson = lessonService.findById(lessonId);

        int progressPercent = courseService.calculateCourseProgress(courseId);

        model.addAttribute("progressPercent", progressPercent);

        model.addAttribute("course", course);
        model.addAttribute("currentLesson", lesson);
        model.addAttribute("currentLessonId", lessonId);

        return "course_page";
    }

    @PostMapping("/course/{courseId}/lesson/{lessonId}/complete")
    public String markAsComplete(@PathVariable Long courseId,
                                 @PathVariable Long lessonId) {

        lessonService.markLessonAsCompleted(lessonId);
        return "redirect:/course/" + courseId + "/lesson/" + lessonId;
    }
}