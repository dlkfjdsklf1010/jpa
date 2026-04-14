package com.jpa.service;

import com.jpa.dto.ScheduleRequest;
import com.jpa.dto.ScheduleResponse;
import com.jpa.entity.Schedule;
import com.jpa.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    public ScheduleResponse create(ScheduleRequest request) {
        Schedule schedule = new Schedule(
                request.getTitle(),
                request.getContent(),
                request.getAuthor(),
                request.getPassword()
        );

        Schedule saved = scheduleRepository.save(schedule);
        return new ScheduleResponse(saved);
    }

    public List<ScheduleResponse> findAll() {
        return scheduleRepository.findAll()
                .stream()
                .map(ScheduleResponse::new)
                .toList();
    }

    public ScheduleResponse findOne(Long id) {
        Schedule schedule = scheduleRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("일정 없음"));

        return new ScheduleResponse(schedule);
    }

    public ScheduleResponse update(Long id, ScheduleRequest request) {
        Schedule schedule = scheduleRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("일정 없음"));

        // 비밀번호 검증
        if (!schedule.getPassword().equals(request.getPassword())) {
            throw new IllegalArgumentException("비밀번호 불일치");
        }

        schedule.update(request.getTitle(), request.getContent());

        return new ScheduleResponse(schedule);
    }

    public void delete(Long id, String password) {
        Schedule schedule = scheduleRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("일정 없음"));

        // 비밀번호 검증
        if (!schedule.getPassword().equals(password)) {
            throw new IllegalArgumentException("비밀번호 불일치");
        }

        scheduleRepository.delete(schedule);
    }
}