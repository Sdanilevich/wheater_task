package main.java.com.example.demo._entry.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import main.java.com.example.demo._usecases.contracts.IWeatherDay;

import java.util.List;

@AllArgsConstructor
@Getter
public class WeatherResponse {

    private List<IWeatherDay> data;
}
