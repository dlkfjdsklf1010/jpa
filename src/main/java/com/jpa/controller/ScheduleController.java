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

    @PostMapping
    public ScheduleResponse create(@RequestBody ScheduleRequest request) {
        return scheduleService.create(request);
    }

    @GetMapping
    public List<ScheduleResponse> findAll() {
        return scheduleService.findAll();
    }

    @GetMapping("/{id}")
    public ScheduleResponse findOne(@PathVariable Long id) {
        return scheduleService.findOne(id);
    }

    @PutMapping("/{id}")
    public ScheduleResponse update(
            @PathVariable Long id,
            @RequestBody ScheduleRequest request) {
        return scheduleService.update(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(
            @PathVariable Long id,
            @RequestParam String password) {
        scheduleService.delete(id, password);
    }
}