package main.java.com.example.demo.api;

import main.java.com.example.demo.api.model.WeatherModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class OpenMeteoApi {

    @Value("${open.meteo.url}")
    private String url;

    private final RestTemplate restTemplate;

    public OpenMeteoApi() {
        this.restTemplate = new RestTemplate();
    }

    public WeatherModel getOpenMeteoData(Double latitude, Double longitude, String timeZone) {
        String meteoUrl = String.format(url, latitude, longitude, timeZone);
        ResponseEntity response =  restTemplate.getForEntity(meteoUrl, WeatherModel.class);

        return (WeatherModel) response.getBody();
    }
}
