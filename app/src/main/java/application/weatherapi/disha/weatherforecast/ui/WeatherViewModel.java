package application.weatherapi.disha.weatherforecast.ui;

import android.app.Application;
import android.util.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import application.weatherapi.disha.weatherforecast.data.remote.APIService;
import application.weatherapi.disha.weatherforecast.data.remote.RetrofitClient;
import application.weatherapi.disha.weatherforecast.model.current.Current;
import application.weatherapi.disha.weatherforecast.model.forecast.Forecast;
import application.weatherapi.disha.weatherforecast.model.current.WeatherDays;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WeatherViewModel extends AndroidViewModel {

    Current data;
    MutableLiveData<Boolean> isCurrentSet = new MutableLiveData<>();
    MutableLiveData<Boolean> isListSet = new MutableLiveData<>();
    List<WeatherDays> list = new ArrayList<>();


    public WeatherViewModel(@NonNull Application application) {
        super(application);
    }

    void getData() {
        APIService api = RetrofitClient.getApiService();
        Call<Current> call = api.getWeatherResult_current("Bangalore", "ad2df464339f14c12c60f03dc63f18e9");

        call.enqueue(new Callback<Current>() {
            @Override
            public void onResponse(Call<Current> call, Response<Current> response){
                if (response.isSuccessful())
                {
                    data = response.body();
                    isCurrentSet.setValue(true);
                }
            }

            @Override
            public void onFailure(Call<Current> call, Throwable t) {

            }
        });
    }

    void getAllForecast()
    {
        Log.d("response response", "onResponse: Size list -- Started");

        APIService api = RetrofitClient.getApiService();
        Call<Forecast> call = api.getWeatherResult_forecast("Bangalore","ad2df464339f14c12c60f03dc63f18e9");

        Log.d("response response", "onResponse: Size list --Calling");

        call.enqueue(new Callback<Forecast>() {
            @Override
            public void onResponse(Call<Forecast> call, Response<Forecast> response) {
                if (response.isSuccessful()) {

                    HashSet<Date> dateSet = new HashSet<>();

                    Log.d("response response", "onResponse: Size list -- "+response.body());

                    for (int i = 0 ; list.size() < 5; i++) {

                        try {
                            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                            Date date = format.parse(response.body().getList().get(i).getDtTxt());
                            if(!dateSet.contains(date))
                            {
                                String temp = String.format("%s%s C", String.valueOf((int) (response.body().getList().get(i).getMain().getTemp() - 273.15)), (char) 0x00B0);
                                WeatherDays weatherDays = new WeatherDays(response.body().getList().get(i).getWeather().get(0).getIcon(), response.body().getList().get(i).getDtTxt(), temp);
                                list.add(weatherDays);
                                dateSet.add(date);
                            }


                        } catch (ParseException e) {
                            e.printStackTrace();
                        }

                    }

                    Log.d("response response", "onResponse: Size list -- "+list.size());

                    isListSet.setValue(true);
                }
            }

            @Override
            public void onFailure(Call<Forecast> call, Throwable t) {
                Log.d("response response", "onResponse: Size list --Failed - "+ t.getMessage());

            }
        });
    }

}
