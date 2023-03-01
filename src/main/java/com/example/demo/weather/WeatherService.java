package com.example.demo.weather;

import com.example.demo._usecases.contracts.IWeatherDay;
import com.example.demo._usecases.contracts.IWeatherRequest;
import com.example.demo._usecases.contracts.IWeatherService;
import com.example.demo.weather.api.OpenMeteoApi;
import com.example.demo.weather.model.WeatherModel;
import com.example.demo._entry.entity.LogData;
import com.example.demo.weather.parser.WeatherParser;
import com.example.demo.weather.dataservices.LogDataRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
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
