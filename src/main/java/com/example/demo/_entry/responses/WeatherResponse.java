package com.example.demo._entry.responses;

import com.example.demo._usecases.contracts.IWeatherDay;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class WeatherResponse {

    private List<IWeatherDay> data;
}
