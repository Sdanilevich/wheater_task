package com.example.demo._entry.requests;

import com.example.demo._usecases.contracts.IWeatherRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class WeatherRequest implements IWeatherRequest {

    private final Double latitude;
    private final Double longitude;
    private final String timeZone;


}
