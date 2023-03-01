package com.example.demo.weather.api;

import com.example.demo.weather.model.WeatherModel;
import com.example.demo._entry.exceptions.OpenApiException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@Slf4j
public class OpenMeteoApi {

    @Value("open.meteo.url")
    private final String url;

    private final RestTemplate restTemplate;

    public OpenMeteoApi(String url, RestTemplate restTemplate) {
        this.url = url;
        this.restTemplate = restTemplate;
    }

    public WeatherModel getOpenMeteorData(Double latitude, Double longitude, String timeZone) {
        try {
            String meteorUrl = String.format(url, latitude, longitude, timeZone);
            ResponseEntity response =  restTemplate.getForEntity(meteorUrl, WeatherModel.class);

            return (WeatherModel) response.getBody();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new OpenApiException(e.getMessage());
        }

    }
}
