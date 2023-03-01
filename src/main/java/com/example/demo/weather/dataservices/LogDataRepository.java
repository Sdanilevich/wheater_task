package com.example.demo.dao.repository;

import com.example.demo.dao.entity.LogData;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface LogDataRepository extends JpaRepository<LogData, Long> {
}
