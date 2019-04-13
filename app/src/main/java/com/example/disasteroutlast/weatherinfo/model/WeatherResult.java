package com.example.disasteroutlast.weatherinfo.model;

public class WeatherResult {
    private String dt;

    private Rain rain;

    private Coord coord;

    private Weather[] weather;

    private String name;

    private String cod;

    private Main main;

    private Clouds clouds;

    private String id;

    private Sys sys;

    private String base;

    private Wind wind;

    public String getDt ()
    {
        return dt;
    }

    public void setDt (String dt)
    {
        this.dt = dt;
    }

    public Rain getRain ()
    {
        return rain;
    }

    public void setRain (Rain rain)
    {
        this.rain = rain;
    }

    public Coord getCoord ()
    {
        return coord;
    }

    public void setCoord (Coord coord)
    {
        this.coord = coord;
    }

    public Weather[] getWeather ()
    {
        return weather;
    }

    public void setWeather (Weather[] weather)
    {
        this.weather = weather;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public String getCod ()
    {
        return cod;
    }

    public void setCod (String cod)
    {
        this.cod = cod;
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

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public Sys getSys ()
    {
        return sys;
    }

    public void setSys (Sys sys)
    {
        this.sys = sys;
    }

    public String getBase ()
    {
        return base;
    }

    public void setBase (String base)
    {
        this.base = base;
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
        return "ClassPojo [dt = "+dt+", rain = "+rain+", coord = "+coord+", weather = "+weather+", name = "+name+", cod = "+cod+", main = "+main+", clouds = "+clouds+", id = "+id+", sys = "+sys+", base = "+base+", wind = "+wind+"]";
    }
}
