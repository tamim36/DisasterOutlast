package com.example.disasteroutlast.weatherinfo;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.disasteroutlast.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class TodayWeatherFragment extends Fragment {

    static TodayWeatherFragment todayWeatherFragment;

    public static TodayWeatherFragment getInstance(){
        if (todayWeatherFragment == null)
            todayWeatherFragment = new TodayWeatherFragment();
        return todayWeatherFragment;
    }

    public TodayWeatherFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_today_weather, container, false);
    }

}
