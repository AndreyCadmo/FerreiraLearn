package com.ferreiralearn.plataformadecurso.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "lesson_completions")
public class LessonCompletion {

    @EmbeddedId
    private LessonCompletionId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("lessonId")
    @JoinColumn(name = "lesson_id")
    private Lesson lesson;

    @Column(name = "completed_at", nullable = false, updatable = false)
    private LocalDateTime completedAt;

    public LessonCompletion() {
    }

    public LessonCompletion(User user, Lesson lesson) {
        this.user = user;
        this.lesson = lesson;
        this.id = new LessonCompletionId(user.getId(), lesson.getId());
        this.completedAt = LocalDateTime.now();
    }

    // Getters e Setters
    public LessonCompletionId getId() { return id; }
    public void setId(LessonCompletionId id) { this.id = id; }
    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
    public Lesson getLesson() { return lesson; }
    public void setLesson(Lesson lesson) { this.lesson = lesson; }
    public LocalDateTime getCompletedAt() { return completedAt; }
    public void setCompletedAt(LocalDateTime completedAt) { this.completedAt = completedAt; }
}