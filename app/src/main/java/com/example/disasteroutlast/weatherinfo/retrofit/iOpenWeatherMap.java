package com.example.disasteroutlast.weatherinfo.retrofit;

import com.example.disasteroutlast.weatherinfo.model.ForcastWeather;
import com.example.disasteroutlast.weatherinfo.model.WeatherResult;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface iOpenWeatherMap {
    @GET("weather")
    Observable<WeatherResult> getWeatherByLatlng(@Query("lat") String lat,
                                                 @Query("lon") String lng,
                                                 @Query("appid") String appid,
                                                 @Query("units") String unit);

    @GET("forecast/hourly")
    Observable<ForcastWeather> getForecastWeather(@Query("lat") String lat,
                                                  @Query("lon") String lng,
                                                  @Query("appid") String appid,
                                                  @Query("units") String unit);
}
