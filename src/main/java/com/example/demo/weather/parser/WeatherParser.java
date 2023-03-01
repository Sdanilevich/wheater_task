package main.java.com.example.demo.weather.parser;

import main.java.com.example.demo._entry.exceptions.ValidateException;
import main.java.com.example.demo._usecases.contracts.IWeatherDay;
import main.java.com.example.demo.weather.model.WeatherDay;
import main.java.com.example.demo.weather.model.WeatherModel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class WeatherParser {

    public List<IWeatherDay> parse(WeatherModel openApiResponse) {
        List<IWeatherDay> dates = new ArrayList<>();
        WeatherModel.Daily daily = openApiResponse.getDaily();
        this.validateResponse(openApiResponse.getDaily());
        if (daily != null && daily.getTime() != null && !daily.getTime().isEmpty()) {
            for (int i = 0; i < daily.getTime().size(); i++) {
                WeatherDay data = new WeatherDay(daily.getTime().get(i),
                        daily.getSunrise().get(i),
                        daily.getSunset().get(i),
                        daily.getPrecipitation_sum().get(i));
                dates.add(data);
            }
        }
        return dates;
    }

    private void validateResponse(WeatherModel.Daily daily) {
        if (daily != null &&
                daily.getTime() != null &&
                daily.getSunrise() != null &&
                daily.getSunset() != null &&
                daily.getPrecipitation_sum() != null) {
            List<Integer> sizeData = List.of(daily.getTime().size(),
                    daily.getSunrise().size(),
                    daily.getSunset().size(),
                    daily.getPrecipitation_sum().size());
            if (sizeData.stream().distinct().count() != 1) {
                throw new ValidateException("Bad open api response");
            }
        }
    }

}
