package com.example.demo.weather.api;

import lombok.extern.slf4j.Slf4j;
import com.example.demo._entry.exceptions.OpenApiException;
import com.example.demo.weather.model.WeatherModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;

@Slf4j
public class OpenMeteoApi {

    @Value("${open.meteo.url}")
    private String url;

    private final RestTemplate restTemplate;

    public OpenMeteoApi() {
        this.restTemplate = new RestTemplate();
    }

    public WeatherModel getOpenMeteorData(Double latitude, Double longitude, String timeZone) {
        try {
            var meteorUrl = String.format(url, latitude, longitude, timeZone);
            var response =  restTemplate.getForEntity(meteorUrl, WeatherModel.class);

            return response.getBody();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new OpenApiException(e.getMessage());
        }

    }
}
