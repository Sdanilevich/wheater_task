package com.example.demo.weather.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import com.example.demo._usecases.contracts.IWeatherDay;

@AllArgsConstructor
@Getter
public class WeatherDay implements IWeatherDay {

    private String date;
    private String sunrise;
    private String sunset;
    private Double precipitation;

}
