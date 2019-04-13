package com.example.disasteroutlast.weatherinfo.model;

public class Rain {
    private String _3h;

    public String get_3h ()
    {
        return _3h;
    }

    public void set3h (String _3h)
    {
        this._3h = _3h;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [3h = "+_3h+"]";
    }
}
