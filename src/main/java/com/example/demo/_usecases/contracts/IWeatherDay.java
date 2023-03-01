package com.example.demo._usecases.contracts;

import java.util.List;

public interface IWeatherDay {
        String getDate();
        String getSunrise();
        String getSunset();
        Double getPrecipitation();
}
