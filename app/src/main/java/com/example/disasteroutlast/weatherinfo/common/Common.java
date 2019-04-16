package com.example.disasteroutlast.weatherinfo.common;

import android.location.Location;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Common {
    public static final String API_Weather = "464b9064e8bab16ce2b34af8a97beefe";

    public static Location currentLocation = null;

    public static String convertUnixToDate(String dt) {
        Date date = new Date(Integer.parseInt(dt)*1000L);
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm EEE MM yyy");
        String formatted = sdf.format(date);
        return formatted;
    }

    public static String convertUnixToHour(String sunrise) {
        Date date = new Date(Integer.parseInt(sunrise)*1000L);
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        String formatted = sdf.format(date);
        return formatted;
    }
}
