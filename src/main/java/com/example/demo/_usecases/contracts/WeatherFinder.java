package main.java.com.example.demo._usecases.contracts;

import java.util.List;

public class WeatherFinder {

    private final IWeatherService weatherService;

    public WeatherFinder(IWeatherService weatherService) {
        this.weatherService = weatherService;
    }


    public List<IWeatherDay> getWeather(IWeatherRequest weatherRequest) {
        return weatherService.getWeather(weatherRequest);
    }
}
