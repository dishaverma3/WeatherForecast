package application.weatherapi.disha.weatherforecast.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import application.weatherapi.disha.weatherforecast.R;
import jp.wasabeef.blurry.Blurry;

import android.os.Bundle;
import android.view.View;

public class WeatherCurrent extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_current);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);



    }
}
