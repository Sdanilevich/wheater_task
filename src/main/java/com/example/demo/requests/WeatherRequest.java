package com.example.demo.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class WeatherRequest {

    private final Double latitude;
    private final Double longitude;
    private final String timeZone;


}
