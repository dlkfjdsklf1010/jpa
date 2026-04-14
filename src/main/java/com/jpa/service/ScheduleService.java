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

    // 생성
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

    // 전체 조회 (작성자 필터 + 수정일 내림차순)
    public List<ScheduleResponse> findAll(String author) {

        List<Schedule> schedules;

        if (author == null) {
            schedules = scheduleRepository.findAllByOrderByUpdatedAtDesc();
        } else {
            schedules = scheduleRepository.findByAuthorOrderByUpdatedAtDesc(author);
        }

        return schedules.stream()
                .map(ScheduleResponse::new)
                .toList();
    }

    // 단건 조회
    public ScheduleResponse findOne(Long id) {
        Schedule schedule = scheduleRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("일정 없음"));

        return new ScheduleResponse(schedule);
    }

    // 수정
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

    // 삭제
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