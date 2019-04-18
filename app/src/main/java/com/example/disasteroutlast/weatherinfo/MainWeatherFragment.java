package com.example.disasteroutlast.weatherinfo;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.disasteroutlast.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainWeatherFragment extends Fragment {


    public MainWeatherFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main_weather, container, false);
        startActivity(new Intent(getActivity(), WeatherMain.class));

        return view;
    }

}
