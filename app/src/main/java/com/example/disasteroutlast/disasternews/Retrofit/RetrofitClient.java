package com.example.disasteroutlast.disasternews.Retrofit;


import com.example.disasteroutlast.disasternews.Model.Post;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetrofitClient {
    @GET("crises.json")
    Observable<List<Post>> getPostfromWeb(@Query("auth_token") String api_key,
                                          @Query("page") int page_no,
                                          @Query("output") String output_type,
                                          @Query("type") String[] type_disaster
    );
}
