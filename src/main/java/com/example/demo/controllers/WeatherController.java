package com.example.demo.controllers;

import com.example.demo.requests.WeatherRequest;
import com.example.demo.responses.WeatherResponse;
import com.example.demo.services.WeatherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@Slf4j
@RestController
@RequestMapping("/weather")
public class WeatherController {

    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("search")
    public ResponseEntity<WeatherResponse> search(
            @RequestParam Double latitude,
            @RequestParam Double longitude,
            @RequestParam(defaultValue = "GMT") String timeZone) {

        try {

            WeatherResponse response = weatherService.getWeather(new WeatherRequest(latitude, longitude, timeZone));
            return ResponseEntity.ok()
                    .body(response);

        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }

    }
}
