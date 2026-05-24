package com.example.it211ss08hw04.repository;

import com.example.it211ss08hw04.entity.LessonVideo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LessonVideoRepository extends JpaRepository<LessonVideo, Long> {
}
