package com.ferreiralearn.plataformadecurso.service;

import com.ferreiralearn.plataformadecurso.model.Lesson;
import com.ferreiralearn.plataformadecurso.model.LessonCompletion;
import com.ferreiralearn.plataformadecurso.model.User;
import com.ferreiralearn.plataformadecurso.repository.LessonCompletionRepository;
import com.ferreiralearn.plataformadecurso.repository.LessonRepository;
import com.ferreiralearn.plataformadecurso.repository.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LessonService {

    private final LessonRepository lessonRepository;
    private final LessonCompletionRepository completionRepository;
    private final UserRepository userRepository;

    public LessonService(LessonRepository lessonRepository,
                         LessonCompletionRepository completionRepository,
                         UserRepository userRepository) {
        this.lessonRepository = lessonRepository;
        this.completionRepository = completionRepository;
        this.userRepository = userRepository;
    }

    public Lesson findById(Long lessonId) {
        return lessonRepository.findById(lessonId)
                .orElseThrow(() -> new RuntimeException("Aula não encontrada com ID: " + lessonId));
    }

    @Transactional
    public void markLessonAsCompleted(Long lessonId) {

        User user = getAuthenticatedUser();


        Lesson lesson = findById(lessonId);
        LessonCompletion completion = new LessonCompletion(user, lesson);

        completionRepository.save(completion);
    }

    private User getAuthenticatedUser() {
        String userEmail = SecurityContextHolder.getContext()
                .getAuthentication()
                .getName();

        return userRepository.findByEmail(userEmail)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado: " + userEmail));
    }
}