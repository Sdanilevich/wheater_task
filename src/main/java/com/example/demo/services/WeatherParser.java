package com.example.demo.services;

import com.example.demo.api.model.WeatherModel;
import com.example.demo.responses.WeatherDay;
import com.example.demo.responses.WeatherResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
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
