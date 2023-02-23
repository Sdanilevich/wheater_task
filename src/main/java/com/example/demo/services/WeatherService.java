package main.java.com.example.demo.services;

import main.java.com.example.demo.api.OpenMeteoApi;
import main.java.com.example.demo.api.model.WeatherModel;
import main.java.com.example.demo.dao.entity.LogData;
import main.java.com.example.demo.dao.repository.LogDataRepository;
import main.java.com.example.demo.requests.WeatherRequest;
import main.java.com.example.demo.responses.WeatherResponse;

public class WeatherService {

    private final OpenMeteoApi openMeteoApi;
    private final WeatherParser weatherParser;

    private final LogDataRepository logDataRepository;

    public WeatherService(OpenMeteoApi openMeteoApi, WeatherParser weatherParser, LogDataRepository logDataRepository) {
        this.openMeteoApi = openMeteoApi;
        this.weatherParser = weatherParser;
        this.logDataRepository = logDataRepository;
    }

    public WeatherResponse getWeather(WeatherRequest weatherRequest) {
        WeatherModel openApiResponse = openMeteoApi.getOpenMeteoData(weatherRequest.getLatitude(), weatherRequest.getLongitude(), weatherRequest.getTimeZone());
        WeatherResponse response =  weatherParser.parse(openApiResponse);
        LogData logData = new LogData(weatherRequest.getLatitude(), weatherRequest.getLongitude());
        logDataRepository.save(logData);
        return response;
    }
}
