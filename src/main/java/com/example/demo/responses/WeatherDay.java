package main.java.com.example.demo.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class WeatherDay {

    private String date;
    private String sunrise;
    private String sunset;
    private Double precipitation;

}
