package com.example.demo._usecases.contracts;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class WeatherFinder {

    private final IWeatherService weatherService;

    public WeatherFinder(IWeatherService weatherService) {
        this.weatherService = weatherService;
    }


    public List<IWeatherDay> getWeather(IWeatherRequest weatherRequest) {
        return weatherService.getWeather(weatherRequest);
    }
}