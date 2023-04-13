package com.example.demo._usecases.contracts;

import java.util.List;

public interface IWeatherService {

    List<IWeatherDay> getWeather(IWeatherRequest request);
}
