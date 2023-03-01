package main.java.com.example.demo.services;

import main.java.com.example.demo.api.model.WeatherModel;
import main.java.com.example.demo.responses.WeatherDay;
import main.java.com.example.demo.responses.WeatherResponse;

import java.util.ArrayList;
import java.util.List;

public class WeatherParser {

    public WeatherResponse parse(WeatherModel openApiResponse){
        List<WeatherDay> dates = new ArrayList<>();
        WeatherModel.Daily daily = openApiResponse.getDaily();
        if (daily!= null && daily.getTime()!= null && !daily.getTime().isEmpty()){
            for (int i = 0; i < daily.getTime().size(); i++) {

                WeatherDay data = new WeatherDay(daily.getTime().get(i),
                        daily.getSunrise().get(i),
                        daily.getSunset().get(i),
                        daily.getPrecipitation_sum().get(i)) ;
                dates.add(data);
            }
        }
        return new WeatherResponse(dates);
    }

}
