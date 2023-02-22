package com.example.demo.services;

import com.example.demo.api.OpenMeteoApi;
import com.example.demo.api.model.WeatherModel;
import com.example.demo.dao.entity.LogData;
import com.example.demo.dao.repository.LogDataRepository;
import com.example.demo.requests.WeatherRequest;
import com.example.demo.responses.WeatherResponse;
import org.springframework.stereotype.Component;

@Component
public class WeatherService {

    private final OpenMeteoApi openMeteoApi;
    private final WeatherParser wheatherParser;

    private final LogDataRepository logDataRepository;

    public WeatherService(OpenMeteoApi openMeteoApi, WeatherParser wheatherParser, LogDataRepository logDataRepository) {
        this.openMeteoApi = openMeteoApi;
        this.wheatherParser = wheatherParser;
        this.logDataRepository = logDataRepository;
    }

    public WeatherResponse getWeather(WeatherRequest weatherRequest) {
        WeatherModel openApiResponse = openMeteoApi.getOpenMeteoData(weatherRequest.getLatitude(), weatherRequest.getLongitude(), weatherRequest.getTimeZone());
        WeatherResponse response =  wheatherParser.parse(openApiResponse);
        LogData logData = new LogData(weatherRequest.getLatitude(), weatherRequest.getLongitude());
        logDataRepository.save(logData);
        return response;
    }
}
