package com.example.demo.weather.model;

import com.example.demo._usecases.contracts.IWeatherDay;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class WeatherDay implements IWeatherDay {

    private String date;
    private String sunrise;
    private String sunset;
    private Double precipitation;

}
