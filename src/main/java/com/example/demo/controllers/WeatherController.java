package main.java.com.example.demo.controllers;

import main.java.com.example.demo.requests.WeatherRequest;
import main.java.com.example.demo.responses.WeatherResponse;
import main.java.com.example.demo.services.WeatherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            WeatherResponse error = new WeatherResponse(e.getMessage());
            return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
        }

    }
}
