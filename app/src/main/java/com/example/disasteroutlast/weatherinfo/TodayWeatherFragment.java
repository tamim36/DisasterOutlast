package com.example.disasteroutlast.weatherinfo;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.disasteroutlast.R;
import com.example.disasteroutlast.weatherinfo.common.Common;
import com.example.disasteroutlast.weatherinfo.model.WeatherResult;
import com.example.disasteroutlast.weatherinfo.retrofit.RetrofitClient;
import com.example.disasteroutlast.weatherinfo.retrofit.iOpenWeatherMap;
import com.squareup.picasso.Picasso;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

/**
 * A simple {@link Fragment} subclass.
 */
public class TodayWeatherFragment extends Fragment {

    ImageView img_weather;
    TextView txt_city_name, txt_wind, txt_humidity, txt_pressure, txt_temperature, txt_sunrise, txt_sunset, txt_date_time, txt_geocoord;
    LinearLayout weather_panel;
    ProgressBar loading;

    CompositeDisposable compositeDisposable;
    iOpenWeatherMap mServices;

    static TodayWeatherFragment todayWeatherFragment;
    WeatherResult weatherResult;

    public static TodayWeatherFragment getInstance(){
        if (todayWeatherFragment == null)
            todayWeatherFragment = new TodayWeatherFragment();
        return todayWeatherFragment;
    }

    public TodayWeatherFragment() {
        compositeDisposable = new CompositeDisposable();
        Retrofit retrofit = RetrofitClient.getRetrofit();
        mServices = retrofit.create(iOpenWeatherMap.class);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View itemView =  inflater.inflate(R.layout.fragment_today_weather, container, false);

        img_weather = (ImageView) itemView.findViewById(R.id.img_weather);
        txt_city_name = (TextView) itemView.findViewById(R.id.text_city_name);
        txt_wind = (TextView) itemView.findViewById(R.id.txt_wind);
        txt_humidity = (TextView) itemView.findViewById(R.id.txt_humidity);
        txt_pressure = (TextView) itemView.findViewById(R.id.txt_Pressure);
        txt_temperature = (TextView) itemView.findViewById(R.id.text_temparature);
        txt_sunrise = (TextView) itemView.findViewById(R.id.txt_sunrise);
        txt_sunset = (TextView) itemView.findViewById(R.id.txt_sunset);
        txt_date_time = (TextView) itemView.findViewById(R.id.text_date_time);
        txt_geocoord = (TextView) itemView.findViewById(R.id.txt_geo_coord);

        weather_panel = (LinearLayout)itemView.findViewById(R.id.weather_panel);
        loading = (ProgressBar)itemView.findViewById(R.id.loading);

        getWeatherInfo(); 


        return itemView;
    }

    private void getWeatherInfo() {
        compositeDisposable.add(mServices.getWeatherByLatlng(String.valueOf(Common.currentLocation.getLatitude()),
                String.valueOf(Common.currentLocation.getLongitude()), Common.API_Weather, "metric" )
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<WeatherResult>() {
                               @Override
                               public void accept(WeatherResult weatherResult) throws Exception {
                                    //Results
                                   setupLayout(weatherResult);
                                   weather_panel.setVisibility(View.VISIBLE);
                                   loading.setVisibility(View.GONE);
                               }
                           }, new Consumer<Throwable>() {
                               @Override
                               public void accept(Throwable throwable) throws Exception {
                                   Toast.makeText(getActivity(), ""+throwable.getMessage(), Toast.LENGTH_SHORT).show();
                               }
                           }
                )
        );
    }

    private void setupLayout(WeatherResult weatherResult) {
        //Load Image with Picasso library
        Picasso.get().load(new StringBuilder("https://openweathermap.org/img/w/")
            .append(weatherResult.getWeather()[0].getIcon())
                .append(".png").toString()
        ).into(img_weather);



        txt_temperature.setText(new StringBuilder(String.valueOf(weatherResult.getMain().getTemp())).append("°C").toString());
        txt_city_name.setText(weatherResult.getName());
        txt_date_time.setText(Common.convertUnixToDate(weatherResult.getDt()));
        txt_pressure.setText(new StringBuilder(String.valueOf(weatherResult.getMain().getPressure())).append(" hpa").toString());
        txt_humidity.setText(new StringBuilder(String.valueOf(weatherResult.getMain().getHumidity())).append(" %").toString());
        txt_sunrise.setText(Common.convertUnixToHour(weatherResult.getSys().getSunrise()));
        txt_sunset.setText(Common.convertUnixToHour(weatherResult.getSys().getSunset()));
        txt_geocoord.setText(new StringBuilder("[").append(String.valueOf(weatherResult.getCoord().getLat())).append(String.valueOf(weatherResult.getCoord().getLon())).append("]").toString());
        txt_wind.setText(new StringBuilder("Wind : ").append(String.valueOf(weatherResult.getWind().getSpeed())).append("km/h").toString());
    }

}
