package com.ferreiralearn.plataformadecurso.repository;

import com.ferreiralearn.plataformadecurso.model.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LessonRepository extends JpaRepository<Lesson, Long> {

    @Query("SELECT COUNT(l) FROM Lesson l WHERE l.module.course.id = :courseId")
    int countLessonsByCourseId(Long courseId);
}
