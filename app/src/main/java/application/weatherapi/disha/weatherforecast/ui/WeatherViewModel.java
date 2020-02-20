package application.weatherapi.disha.weatherforecast.ui;

import android.app.Application;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import application.weatherapi.disha.weatherforecast.data.remote.APIService;
import application.weatherapi.disha.weatherforecast.data.remote.RetrofitClient;
import application.weatherapi.disha.weatherforecast.model.Current;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WeatherViewModel extends AndroidViewModel {

    Current data;
    MutableLiveData<Boolean> isCurrentSet = new MutableLiveData<>();
    List<Current> list;

    public WeatherViewModel(@NonNull Application application) {
        super(application);
    }

    public void getData() {
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

    public void getAllForecast()
    {
        APIService api = RetrofitClient.getApiService();
        Call<Current> call = api.getWeatherResult_forecast("Bangalore","ad2df464339f14c12c60f03dc63f18e9");

        c

    }


}
