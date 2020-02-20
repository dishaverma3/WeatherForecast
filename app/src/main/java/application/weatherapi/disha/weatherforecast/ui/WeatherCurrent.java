package application.weatherapi.disha.weatherforecast.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import application.weatherapi.disha.weatherforecast.R;
import application.weatherapi.disha.weatherforecast.model.Current;
import application.weatherapi.disha.weatherforecast.model.WeatherDays;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class WeatherCurrent extends AppCompatActivity {

    TextView location, temperature, description, smallDiscription, descriptionTable, windSpeed, tempMin,tempMax;
    RecyclerView recyclerView;
    ImageView image;
    Current responseData;
    WeatherViewModel viewModel;
    String imageUrl = "http://openweathermap.org/img/wn/";
    WeatherAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_current);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);

        init();
        viewModel.getData();

        viewModel.isCurrentSet.observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if (aBoolean)
                {
                    responseData = viewModel.data;
                    setCurrentData(responseData);
                }
            }
        });
    }

    private void setCurrentData(Current responseData) {
        double temperatureResponse = responseData.getMain().getTemp();

        temperature.setText(String.valueOf((int)(temperatureResponse-273.15))+(char) 0x00B0 + " C");
        location.setText(responseData.getName());
        description.setText(responseData.getWeather().get(0).getDescription());

        String url = imageUrl+responseData.getWeather().get(0).getIcon()+"@2x.png";
        Log.d("kjdfkxjvkfdv", "setCurrentData: "+url);

        Glide.with(this).load(url).into(image);

        smallDiscription.setText(responseData.getWeather().get(0).getMain());
        descriptionTable.setText(responseData.getWeather().get(0).getDescription());
        tempMin.setText(String.valueOf((int)(responseData.getMain().getTempMin()-273.15))+(char) 0x00B0 + " C");
        tempMax.setText(String.valueOf((int)(responseData.getMain().getTempMax()-273.15))+(char) 0x00B0 + " C");
        windSpeed.setText(responseData.getWind().getSpeed()+"");
    }

    private void init() {

        smallDiscription = findViewById(R.id.main);
        descriptionTable = findViewById(R.id.description);
        tempMin = findViewById(R.id.temp_min);
        tempMax = findViewById(R.id.temp_max);
        windSpeed = findViewById(R.id.wind_speed);
        location = findViewById(R.id.location);
        temperature = findViewById(R.id.temp_celcius);
        description = findViewById(R.id.weather);
        image = findViewById(R.id.image_weather);
        recyclerView = findViewById(R.id.recyclerView);

        viewModel = new ViewModelProvider(this).get(WeatherViewModel.class);
    }

    public void setRecyclerView(List<WeatherDays> list) {

        adapter = new WeatherAdapter(list, WeatherCurrent.this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

    }

}
