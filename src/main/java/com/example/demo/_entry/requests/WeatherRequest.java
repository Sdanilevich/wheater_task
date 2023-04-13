package com.example.demo._entry.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import com.example.demo._usecases.contracts.IWeatherRequest;

@AllArgsConstructor
@Getter
public class WeatherRequest implements IWeatherRequest {

    private final Double latitude;
    private final Double longitude;
    private final String timeZone;


}
