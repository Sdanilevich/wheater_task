package com.example.demo.api;

import com.example.demo.api.model.WeatherModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class OpenMeteoApi {

    @Value("open.meteo.url")
    private String url;

    private final RestTemplate restTemplate;

    public OpenMeteoApi(String url, RestTemplate restTemplate) {
        this.url = url;
        this.restTemplate = restTemplate;
    }

    public WeatherModel getOpenMeteoData(Double latitude, Double longitude, String timeZone) {
        String meteoUrl = String.format(url, latitude, latitude, timeZone);
        ResponseEntity response =  restTemplate.getForEntity(meteoUrl, WeatherModel.class);

        return (WeatherModel) response.getBody();
    }
}
