package com.example.demo._entry.controllers;

import com.example.demo._entry.requests.WeatherRequest;
import com.example.demo._entry.responses.WeatherResponse;
import com.example.demo._usecases.contracts.IWeatherDay;
import com.example.demo.weather.WeatherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

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
            @RequestParam(required = false) String timeZone) {

        try {
            timeZone = timeZone == null ? this.defineTimeZone() : timeZone;
            List<IWeatherDay> response = weatherService.getWeather(new WeatherRequest(latitude, longitude, timeZone));

            return ResponseEntity.ok()
                    .body(new WeatherResponse(response));

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return ResponseEntity.internalServerError().build();
        }

    }

    private String defineTimeZone() {
        TimeZone zone = TimeZone.getDefault();
        DateTimeFormatter zoneAbbreviationFormatter
                = DateTimeFormatter.ofPattern("zzz", Locale.ENGLISH);
        return ZonedDateTime.now(zone.toZoneId()).format(zoneAbbreviationFormatter);
    }
}
