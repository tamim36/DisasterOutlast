package com.example.disasteroutlast.weatherinfo.model;

public class List {
    private String dt;

    private String dt_txt;

    private Weather[] weather;

    private Main main;

    private Clouds clouds;

    private Sys sys;

    private Wind wind;

    public String getDt ()
    {
        return dt;
    }

    public void setDt (String dt)
    {
        this.dt = dt;
    }

    public String getDt_txt ()
    {
        return dt_txt;
    }

    public void setDt_txt (String dt_txt)
    {
        this.dt_txt = dt_txt;
    }

    public Weather[] getWeather ()
    {
        return weather;
    }

    public void setWeather (Weather[] weather)
    {
        this.weather = weather;
    }

    public Main getMain ()
    {
        return main;
    }

    public void setMain (Main main)
    {
        this.main = main;
    }

    public Clouds getClouds ()
    {
        return clouds;
    }

    public void setClouds (Clouds clouds)
    {
        this.clouds = clouds;
    }

    public Sys getSys ()
    {
        return sys;
    }

    public void setSys (Sys sys)
    {
        this.sys = sys;
    }

    public Wind getWind ()
    {
        return wind;
    }

    public void setWind (Wind wind)
    {
        this.wind = wind;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [dt = "+dt+", dt_txt = "+dt_txt+", weather = "+weather+", main = "+main+", clouds = "+clouds+", sys = "+sys+", wind = "+wind+"]";
    }
}
