package com.jpa.dto;

import com.jpa.entity.Schedule;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ScheduleResponse {

    private Long id;
    private String title;
    private String content;
    private String author;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public ScheduleResponse(Schedule schedule) {
        this.id = schedule.getId();
        this.title = schedule.getTitle();
        this.content = schedule.getContent();
        this.author = schedule.getAuthor();
        this.createdAt = schedule.getCreatedAt();
        this.updatedAt = schedule.getUpdatedAt();
    }
}