package main.java.com.example.demo.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class WeatherResponse {

    private List<WeatherDay> data;

    private String description;

    public WeatherResponse(String description){
        this.description = description;
    }

    public WeatherResponse(List<WeatherDay> date) {
        this.data = date;
        this.description = "ok";
    }
}
