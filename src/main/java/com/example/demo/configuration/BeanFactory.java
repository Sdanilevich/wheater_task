package com.example.demo.configuration;
import com.example.demo._usecases.contracts.IWeatherService;
import com.example.demo._usecases.contracts.WeatherFinder;
import com.example.demo.weather.WeatherService;
import com.example.demo.weather.api.OpenMeteoApi;
import com.example.demo.weather.dataservices.LogDataRepository;
import com.example.demo.weather.parser.WeatherParser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanFactory {

    @Bean
    public IWeatherService weatherService(OpenMeteoApi openApi, WeatherParser parser, LogDataRepository logDataRepository){
        return new WeatherService(openApi, parser, logDataRepository);
    }

    @Bean
    public OpenMeteoApi openMeteoApi(){
        return new OpenMeteoApi();
    }

    @Bean
    public WeatherParser weatherParser(){
        return new WeatherParser();
    }

    @Bean
    public WeatherFinder weatherFinder(IWeatherService weatherService){
        return new WeatherFinder(weatherService);
    }
}
