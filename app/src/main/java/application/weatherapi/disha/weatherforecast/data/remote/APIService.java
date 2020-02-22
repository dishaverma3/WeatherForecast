package application.weatherapi.disha.weatherforecast.data.remote;

import application.weatherapi.disha.weatherforecast.model.current.Current;
import application.weatherapi.disha.weatherforecast.model.forecast.Forecast;
import application.weatherapi.disha.weatherforecast.model.hourly.Hourly;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIService {

    //for current city temperature
    @GET("weather")
    Call<Current> getWeatherResult_current(@Query("q") String cityName, @Query("appid") String apikey);

    @GET("forecast")
    Call<Forecast> getWeatherResult_forecast(@Query("q") String cityName, @Query("appid") String apikey);

}
