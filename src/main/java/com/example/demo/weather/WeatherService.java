package com.example.demo.weather;


import com.example.demo._entry.entity.LogData;
import com.example.demo._usecases.contracts.IWeatherDay;
import com.example.demo._usecases.contracts.IWeatherRequest;
import com.example.demo._usecases.contracts.IWeatherService;
import com.example.demo.weather.api.OpenMeteoApi;
import com.example.demo.weather.dataservices.LogDataRepository;
import com.example.demo.weather.parser.WeatherParser;

import java.util.List;

public class WeatherService implements IWeatherService {

    private final OpenMeteoApi openMeteoApi;
    private final WeatherParser weatherParser;
    private final LogDataRepository logDataRepository;

    public WeatherService(OpenMeteoApi openMeteoApi, WeatherParser weatherParser, LogDataRepository logDataRepository) {
        this.openMeteoApi = openMeteoApi;
        this.weatherParser = weatherParser;
        this.logDataRepository = logDataRepository;
    }

    public List<IWeatherDay> getWeather(IWeatherRequest weatherRequest) {
        var openApiResponse = openMeteoApi.getOpenMeteorData(weatherRequest.getLatitude(), weatherRequest.getLongitude(), weatherRequest.getTimeZone());
        var response =  weatherParser.parse(openApiResponse);
        var logData = new LogData(weatherRequest.getLatitude(), weatherRequest.getLongitude());
        logDataRepository.save(logData);
        return response;
    }
}
