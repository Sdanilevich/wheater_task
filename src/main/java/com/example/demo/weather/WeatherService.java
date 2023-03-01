package main.java.com.example.demo.weather;


import main.java.com.example.demo._entry.entity.LogData;
import main.java.com.example.demo._usecases.contracts.IWeatherDay;
import main.java.com.example.demo._usecases.contracts.IWeatherRequest;
import main.java.com.example.demo._usecases.contracts.IWeatherService;
import main.java.com.example.demo.weather.api.OpenMeteoApi;
import main.java.com.example.demo.weather.dataservices.LogDataRepository;
import main.java.com.example.demo.weather.model.WeatherModel;
import main.java.com.example.demo.weather.parser.WeatherParser;
import org.springframework.stereotype.Component;

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
        WeatherModel openApiResponse = openMeteoApi.getOpenMeteorData(weatherRequest.getLatitude(), weatherRequest.getLongitude(), weatherRequest.getTimeZone());
        List<IWeatherDay> response =  weatherParser.parse(openApiResponse);
        LogData logData = new LogData(weatherRequest.getLatitude(), weatherRequest.getLongitude());
        logDataRepository.save(logData);
        return response;
    }
}
