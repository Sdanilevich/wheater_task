package main.java.com.example.demo.weather.api;

import lombok.extern.slf4j.Slf4j;
import main.java.com.example.demo._entry.exceptions.OpenApiException;
import main.java.com.example.demo.weather.model.WeatherModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
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
            String meteorUrl = String.format(url, latitude, longitude, timeZone);
            ResponseEntity response =  restTemplate.getForEntity(meteorUrl, WeatherModel.class);

            return (WeatherModel) response.getBody();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new OpenApiException(e.getMessage());
        }

    }
}
