package main.java.com.example.demo.configuration;
import main.java.com.example.demo.api.OpenMeteoApi;
import main.java.com.example.demo.dao.repository.LogDataRepository;
import main.java.com.example.demo.services.WeatherParser;
import main.java.com.example.demo.services.WeatherService;
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
