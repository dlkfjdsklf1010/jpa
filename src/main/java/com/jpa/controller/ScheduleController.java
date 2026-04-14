package com.jpa.controller;

import com.jpa.dto.ScheduleRequest;
import com.jpa.dto.ScheduleResponse;
import com.jpa.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/schedules")
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;

    // 생성
    @PostMapping
    public ScheduleResponse create(@RequestBody ScheduleRequest request) {
        return scheduleService.create(request);
    }

    // 전체 조회 (author 선택)
    @GetMapping
    public List<ScheduleResponse> findAll(
            @RequestParam(required = false) String author
    ) {
        return scheduleService.findAll(author);
    }

    // 단건 조회
    @GetMapping("/{id}")
    public ScheduleResponse findOne(@PathVariable Long id) {
        return scheduleService.findOne(id);
    }

    // 수정
    @PutMapping("/{id}")
    public ScheduleResponse update(
            @PathVariable Long id,
            @RequestBody ScheduleRequest request
    ) {
        return scheduleService.update(id, request);
    }

    // 삭제
    @DeleteMapping("/{id}")
    public void delete(
            @PathVariable Long id,
            @RequestParam String password
    ) {
        scheduleService.delete(id, password);
    }
}