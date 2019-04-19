package com.example.disasteroutlast.weatherinfo.AdapterPager;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.disasteroutlast.R;
import com.example.disasteroutlast.weatherinfo.common.Common;
import com.example.disasteroutlast.weatherinfo.model.ForcastWeather;
import com.squareup.picasso.Picasso;

public class WeatherForecastAdapter extends RecyclerView.Adapter<WeatherForecastAdapter.MyViewHolder> {

    Context context;
    ForcastWeather forcastWeather;

    public WeatherForecastAdapter(Context context, ForcastWeather forcastWeather) {
        this.context = context;
        this.forcastWeather = forcastWeather;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.item_weather_forecast,viewGroup, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        /*Picasso.get().load(new StringBuilder("https://openweathermap.org/img/w/")
                .append(forcastWeather.getList()[i].getWeather()[0].getIcon())
                .append(".png").toString()
        )
                .resize(175,175)
                .into(myViewHolder.img_weather);*/

        myViewHolder.txt_description.setText(new StringBuilder(forcastWeather.getList()[i].getWeather()[0].getDescription()).toString());
        myViewHolder.txt_date_tym.setText(new StringBuilder(Common.convertUnixToDate(forcastWeather.getList()[i].getDt())));
        myViewHolder.txt_temperature.setText(new StringBuilder(String.valueOf(forcastWeather.getList()[i].getMain().getTemp())).append("°C"));
    }

    @Override
    public int getItemCount() {
        return forcastWeather.getList().length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView txt_date_tym, txt_description, txt_temperature;
        ImageView img_weather;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            img_weather = (ImageView)itemView.findViewById(R.id.img_weather);
            txt_date_tym = (TextView)itemView.findViewById(R.id.text_date_time);
            txt_description = (TextView)itemView.findViewById(R.id.text_description);
            txt_temperature = (TextView)itemView.findViewById(R.id.text_temparature);
        }


    }


}
