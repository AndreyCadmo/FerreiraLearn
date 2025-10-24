package com.ferreiralearn.plataformadecurso.service;

import com.ferreiralearn.plataformadecurso.model.Course;
import com.ferreiralearn.plataformadecurso.model.User;
import com.ferreiralearn.plataformadecurso.repository.*;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    private final CourseRepository courseRepository;
    private final LessonRepository lessonRepository;
    private final LessonCompletionRepository completionRepository;
    private final UserRepository userRepository;

    public CourseService(CourseRepository courseRepository,
                         LessonRepository lessonRepository,
                         LessonCompletionRepository completionRepository,
                         UserRepository userRepository) {
        this.courseRepository = courseRepository;
        this.lessonRepository = lessonRepository;
        this.completionRepository = completionRepository;
        this.userRepository = userRepository;
    }

    public Course findById(Long courseId) {
        return courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Curso não encontrado com ID: " + courseId));
    }

    public List<Course> findAllCourses() {
        return courseRepository.findAll();
    }

    public int calculateCourseProgress(Long courseId) {
        User user = getAuthenticatedUser();
        if (user == null) return 0;
        int totalLessons = lessonRepository.countLessonsByCourseId(courseId);
        if (totalLessons == 0) return 0;
        int completedLessons = completionRepository.countCompletedLessonsByUserIdAndCourseId(user.getId(), courseId);
        double progress = ((double) completedLessons / totalLessons) * 100.0;
        return (int) progress;
    }

    private User getAuthenticatedUser() {
        String userEmail = SecurityContextHolder.getContext().getAuthentication().getName();
        return userRepository.findByEmail(userEmail).orElse(null);
    }
}