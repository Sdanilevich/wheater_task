package com.example.demo.api.model;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class WeatherModel {

    private Daily daily;

    @Getter
    public class Daily{
        List<String> time;
        List<String> sunrise;
        List<String> sunset;
        List<Double> precipitation_sum;
    }
}
