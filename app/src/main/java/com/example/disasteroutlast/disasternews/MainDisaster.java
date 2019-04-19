package com.example.disasteroutlast.disasternews;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.disasteroutlast.R;
import com.example.disasteroutlast.disasternews.Adapter.PostAdapter;
import com.example.disasteroutlast.disasternews.Model.Post;
import com.example.disasteroutlast.disasternews.Retrofit.RetrofitBuilder;
import com.example.disasteroutlast.disasternews.Retrofit.RetrofitClient;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

public class MainDisaster extends AppCompatActivity {

    RetrofitClient iClient;
    RecyclerView recyclerView_posts;
    CompositeDisposable compositeDisposable = new CompositeDisposable();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_disaster);

        //init Api
        Retrofit retrofit = RetrofitBuilder.getRetrofit();
        iClient = retrofit.create(RetrofitClient.class);

        //For Recycler view and card view
        recyclerView_posts = (RecyclerView)findViewById(R.id.recycler_post);
        recyclerView_posts.setHasFixedSize(true);
        recyclerView_posts.setLayoutManager(new LinearLayoutManager(this));

        fetchData();
    }

    private void fetchData() {
        compositeDisposable.add(iClient.getPostfromWeb("YDYkcpwWYdeqNsAckzGs",1, "short", new String[]{"earthquakes", "floods", "cyclones"})
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<Post>>() {
                               @Override
                               public void accept(List<Post> posts) throws Exception {
                                   displayData(posts);
                               }
                           }, new Consumer<Throwable>() {
                               @Override
                               public void accept(Throwable throwable) throws Exception {
                                   Toast.makeText(MainDisaster.this, ""+throwable.getMessage(), Toast.LENGTH_SHORT).show();
                               }
                           }
                )
        );
    }

    private void displayData(List<Post> posts) {
        PostAdapter adapter = new PostAdapter(this, posts);
        recyclerView_posts.setAdapter(adapter);
    }

    @Override
    protected void onStop() {
        compositeDisposable.clear();
        super.onStop();
    }
}
