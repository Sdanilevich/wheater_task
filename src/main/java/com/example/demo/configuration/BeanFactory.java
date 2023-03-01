package main.java.com.example.demo.configuration;
import main.java.com.example.demo.weather.WeatherService;
import main.java.com.example.demo.weather.api.OpenMeteoApi;
import main.java.com.example.demo.weather.dataservices.LogDataRepository;
import main.java.com.example.demo.weather.parser.WeatherParser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanFactory {

    @Bean
    public WeatherService weatherService(OpenMeteoApi openApi, WeatherParser parser, LogDataRepository logDataRepository){
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

}
