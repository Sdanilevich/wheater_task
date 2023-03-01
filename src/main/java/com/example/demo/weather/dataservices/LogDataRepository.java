package main.java.com.example.demo.weather.dataservices;

import main.java.com.example.demo._entry.entity.LogData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogDataRepository extends JpaRepository<LogData, Long> {
}
