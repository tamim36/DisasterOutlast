package com.example.disasteroutlast;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.disasteroutlast.weatherinfo.MainWeatherFragment;
import com.example.disasteroutlast.weatherinfo.WeatherMain;

public class MainActivity extends AppCompatActivity {

    private MainWeatherFragment mainWeatherFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainWeatherFragment = new MainWeatherFragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_a, mainWeatherFragment)
                .commit();

        //Button weatherBtn = (Button)findViewById(R.id.weather_btn);
        /*weatherBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, WeatherMain.class));
            }
        });*/
    }
}
