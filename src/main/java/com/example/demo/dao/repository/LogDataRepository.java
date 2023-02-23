package main.java.com.example.demo.dao.repository;

import main.java.com.example.demo.dao.entity.LogData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogDataRepository extends JpaRepository<LogData, Long> {
}
