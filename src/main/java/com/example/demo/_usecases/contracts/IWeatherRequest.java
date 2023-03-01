package main.java.com.example.demo._usecases.contracts;

public interface IWeatherRequest {
    Double getLatitude();
    Double getLongitude();
    String getTimeZone();
}
