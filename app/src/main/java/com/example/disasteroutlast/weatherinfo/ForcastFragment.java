package com.example.disasteroutlast.weatherinfo;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.disasteroutlast.R;
import com.example.disasteroutlast.weatherinfo.AdapterPager.WeatherForecastAdapter;
import com.example.disasteroutlast.weatherinfo.common.Common;
import com.example.disasteroutlast.weatherinfo.model.ForcastWeather;
import com.example.disasteroutlast.weatherinfo.retrofit.RetrofitClient;
import com.example.disasteroutlast.weatherinfo.retrofit.iOpenWeatherMap;
import com.squareup.picasso.Picasso;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;


public class ForcastFragment extends Fragment {
    TextView txt_city_name;

    RecyclerView recycler_forecast;
    
    CompositeDisposable compositeDisposable;
    iOpenWeatherMap mServices;

    static ForcastFragment forcastFragment;
    ForcastWeather forcastWeather;

    public static ForcastFragment getInstance(){
        if (forcastFragment == null)
            forcastFragment = new ForcastFragment();
        return forcastFragment;
    }

    public ForcastFragment() {
        compositeDisposable = new CompositeDisposable();
        Retrofit retrofit = RetrofitClient.getRetrofit();
        mServices = retrofit.create(iOpenWeatherMap.class);
    }

    @Override
    public void onStop() {
        compositeDisposable.clear();
        super.onStop();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View itemView =  inflater.inflate(R.layout.fragment_forcast, container, false);

        txt_city_name = (TextView)itemView.findViewById(R.id.text_city_name);
        recycler_forecast = (RecyclerView)itemView.findViewById(R.id.recycler_forecast);
        recycler_forecast.setHasFixedSize(true);
        recycler_forecast.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

        getWeatherInfo();


        return itemView;
    }

    private void getWeatherInfo() {
        compositeDisposable.add(mServices.getForecastWeather(String.valueOf(Common.currentLocation.getLatitude()),
                String.valueOf(Common.currentLocation.getLongitude()), Common.API_Weather, "metric" )
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ForcastWeather>() {
                               @Override
                               public void accept(ForcastWeather forcastWeather) throws Exception {
                                   //Results
                                   setupLayout(forcastWeather);
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

    private void setupLayout(ForcastWeather forcastWeather) {
        txt_city_name.setText(new StringBuilder(forcastWeather.getCity().getName()));
        //temp_.setText(new StringBuilder(String.valueOf(forcastWeather.getList()[0].getMain().getTemp())).append("°C").toString());
        //dt_txt_.setText(Common.convertUnixToDate(forcastWeather.getList()[0].getDt()));
        WeatherForecastAdapter adapter = new WeatherForecastAdapter(getContext(), forcastWeather);
        recycler_forecast.setAdapter(adapter);
    }
}
