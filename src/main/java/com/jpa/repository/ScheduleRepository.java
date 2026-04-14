package com.jpa.repository;

import com.jpa.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

    // 전체 조회
    List<Schedule> findAllByOrderByUpdatedAtDesc();

    // 작성자 기준 조회
    List<Schedule> findByAuthorOrderByUpdatedAtDesc(String author);
}