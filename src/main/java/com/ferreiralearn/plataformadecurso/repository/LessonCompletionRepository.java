package com.ferreiralearn.plataformadecurso.repository;

import com.ferreiralearn.plataformadecurso.model.LessonCompletion;
import com.ferreiralearn.plataformadecurso.model.LessonCompletionId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LessonCompletionRepository extends JpaRepository<LessonCompletion, LessonCompletionId> {

    @Query("SELECT COUNT(lc) FROM LessonCompletion lc " +
            "WHERE lc.user.id = :userId AND lc.lesson.module.course.id = :courseId")
    int countCompletedLessonsByUserIdAndCourseId(Long userId, Long courseId);

    @Query("SELECT lc.lesson.id FROM LessonCompletion lc " +
            "WHERE lc.user.id = :userId AND lc.lesson.module.course.id = :courseId")
    List<Long> findCompletedLessonIdsByUserIdAndCourseId(Long userId, Long courseId);

}