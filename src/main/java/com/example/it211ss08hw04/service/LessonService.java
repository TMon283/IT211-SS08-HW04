package com.example.it211ss08hw04.service;

import com.example.it211ss08hw04.entity.LessonVideo;
import com.example.it211ss08hw04.exception.AccessDeniedException;
import com.example.it211ss08hw04.exception.ResourceNotFoundException;
import com.example.it211ss08hw04.repository.LessonVideoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LessonService {

    private final LessonVideoRepository lessonVideoRepository;

    public String watchLesson(Long lessonId, String userId) {
        LessonVideo video = lessonVideoRepository.findById(lessonId)
                .orElseThrow(() -> new ResourceNotFoundException("Lesson video not found"));

        if (!video.getIsFree()) {
            boolean purchased = checkUserPurchasedCourse(userId, video.getCourseId());
            if (!purchased) {
                throw new AccessDeniedException("You have not purchased this course yet.");
            }
        }
        return video.getVideoUrl();
    }

    private boolean checkUserPurchasedCourse(String userId, Long courseId) {
        return false;
    }
}
