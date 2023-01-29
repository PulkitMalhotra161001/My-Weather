package com.example.weatherapplicationgfg;

public class WeatherRVModel {
    private final String time, temperature, icon, windSpeed;

    public WeatherRVModel(String time, String temperature, String icon, String windSpeed) {
        this.time = time;
        this.temperature = temperature;
        this.icon = icon;
        this.windSpeed = windSpeed;
    }

    public String getTime() {
        return time;
    }

    public String getTemperature() {
        return temperature;
    }


    public String getIcon() {
        return icon;
    }


    public String getWindSpeed() {
        return windSpeed;
    }

}
