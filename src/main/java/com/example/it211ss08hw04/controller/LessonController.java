package com.example.it211ss08hw04.controller;

import com.example.it211ss08hw04.service.LessonService;
import jakarta.validation.constraints.Min;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/lessons")
public class LessonController {

    private final LessonService lessonService;

    public LessonController(LessonService lessonService) {
        this.lessonService = lessonService;
    }

    @GetMapping("/watch")
    public ResponseEntity<String> watchLesson(
            @RequestHeader("X-User") String userId,
            @RequestParam @Min(1) Long lessonId) {
        String videoUrl = lessonService.watchLesson(lessonId, userId);
        return ResponseEntity.ok(videoUrl);
    }
}

