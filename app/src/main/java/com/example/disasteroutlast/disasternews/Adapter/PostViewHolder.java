package com.example.disasteroutlast.disasternews.Adapter;


import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.TextView;

import com.example.disasteroutlast.R;


public class PostViewHolder extends ViewHolder {

    TextView txt_title, txt_content, txt_crisis_level,txt_country, txt_population, txt_start_date, txt_type_disaster;

    public PostViewHolder(@NonNull View itemView) {
        super(itemView);

        txt_title = (TextView)itemView.findViewById(R.id.txt_title);
        txt_type_disaster = (TextView)itemView.findViewById(R.id.txt_type_disaster);
        txt_content = (TextView)itemView.findViewById(R.id.txt_content);
        txt_crisis_level = (TextView)itemView.findViewById(R.id.txt_crisis_level);
        txt_population = (TextView)itemView.findViewById(R.id.txt_population);
        txt_country = (TextView)itemView.findViewById(R.id.txt_country);
        txt_start_date = (TextView)itemView.findViewById(R.id.txt_start_date);

    }
}
