package com.example.disasteroutlast.disasternews.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.disasteroutlast.R;
import com.example.disasteroutlast.disasternews.Model.Post;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostViewHolder> {

    Context context;
    List<Post> postList;

    public PostAdapter(Context context, List<Post> postList) {
        this.context = context;
        this.postList = postList;
    }


    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.post_layout, viewGroup, false);
        return new PostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder postViewHolder, int i) {
        postViewHolder.txt_title.setText(String.valueOf(postList.get(i).getDc_title()));
        postViewHolder.txt_content.setText(new StringBuilder(postList.get(i).getDc_description().substring(0,20).toString()));

        if (postList.get(i).getGn_parentCountry().length != 0)
            postViewHolder.txt_country.setText(String.valueOf(postList.get(i).getGn_parentCountry()[0]));

        postViewHolder.txt_crisis_level.setText(String.valueOf(postList.get(i).getCrisis_alertLevel()));
        postViewHolder.txt_population.setText(String.valueOf(postList.get(i).getCrisis_population()));
        postViewHolder.txt_start_date.setText(String.valueOf(postList.get(i).getSchema_startDate()));
        postViewHolder.txt_type_disaster.setText(String.valueOf(postList.get(i).getSubject()));
    }

    @Override
    public int getItemCount() {
        return postList.size();
    }
}
