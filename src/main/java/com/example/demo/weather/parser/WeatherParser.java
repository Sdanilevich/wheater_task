package com.example.demo.weather.parser;

import com.example.demo._entry.exceptions.ValidateException;
import com.example.demo._usecases.contracts.IWeatherDay;
import com.example.demo.weather.model.WeatherDay;
import com.example.demo.weather.model.WeatherModel;

import java.util.List;
import java.util.stream.IntStream;

public class WeatherParser {

    public List<IWeatherDay> parse(WeatherModel openApiResponse) {
        var daily = openApiResponse.getDaily();
        this.validateResponse(openApiResponse.getDaily());
        return IntStream.range(0, daily.getTime().size()).mapToObj(s->buildWeatherData(daily, s)).toList();
    }

    private IWeatherDay buildWeatherData(WeatherModel.Daily daily, int numberOfDate){
        return new WeatherDay(daily.getTime().get(numberOfDate),
                daily.getSunrise().get(numberOfDate),
                daily.getSunset().get(numberOfDate),
                daily.getPrecipitation_sum().get(numberOfDate));
    }

    private void validateResponse(WeatherModel.Daily daily) {
        if (daily != null &&
                daily.getTime() != null &&
                daily.getSunrise() != null &&
                daily.getSunset() != null &&
                daily.getPrecipitation_sum() != null) {
            var sizeData = List.of(daily.getTime().size(),
                    daily.getSunrise().size(),
                    daily.getSunset().size(),
                    daily.getPrecipitation_sum().size());
            if (sizeData.stream().distinct().count() != 1) {
                throw new ValidateException("Bad open api response");
            }
        }
    }

}
