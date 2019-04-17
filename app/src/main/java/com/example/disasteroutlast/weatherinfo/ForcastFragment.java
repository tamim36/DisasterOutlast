package com.example.disasteroutlast.weatherinfo;

import android.content.Context;
import android.net.Uri;
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
    TextView temp_, dt_txt_;
    LinearLayout forecast_panel;
    ProgressBar loading;
    
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View itemView =  inflater.inflate(R.layout.fragment_forcast, container, false);

        temp_ = (TextView)itemView.findViewById(R.id.temp_);
        dt_txt_= (TextView)itemView.findViewById(R.id.dt_txt_);
        loading = (ProgressBar)itemView.findViewById(R.id.loading);
        forecast_panel = (LinearLayout)itemView.findViewById(R.id.forecast_panel); 


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
                                   forecast_panel.setVisibility(View.VISIBLE);
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

    private void setupLayout(ForcastWeather forcastWeather) {
        temp_.setText(new StringBuilder(String.valueOf(forcastWeather.getList()[0].getMain().getTemp())).append("°C").toString());
        dt_txt_.setText(Common.convertUnixToDate(forcastWeather.getList()[0].getDt()));
    }
}
