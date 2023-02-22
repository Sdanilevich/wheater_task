package com.example.demo.responses;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class WeatherResponse {

    private List<WeatherDay> data;
}
