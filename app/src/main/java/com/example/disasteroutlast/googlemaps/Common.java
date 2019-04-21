package com.example.disasteroutlast.googlemaps;


import com.example.disasteroutlast.googlemaps.Remote.IGoogleApiServices;
import com.example.disasteroutlast.googlemaps.Remote.RetrofitClient;

public class Common {
    private static final String Google_API_URL = "https://maps.googleapis.com/";

    public static IGoogleApiServices getGoogleAPIService()
    {
        return RetrofitClient.getClient(Google_API_URL).create(IGoogleApiServices.class);
    }
}