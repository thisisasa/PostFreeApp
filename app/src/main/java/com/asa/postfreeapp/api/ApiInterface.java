package com.asa.postfreeapp.api;

import com.asa.postfreeapp.models.requests.RegisterRequest;
import com.asa.postfreeapp.models.response.BaseResponse;
import com.asa.postfreeapp.models.response.PostResponse;
import com.asa.postfreeapp.models.response.PostsItem;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiInterface {
    @GET("/posts")
    Call<PostResponse> getAllPosts();
    @GET("/posts/{id}")
    Call<PostsItem> getPostById(@Path("id") int id);

    @POST("/api/oauth/register")
    Call<BaseResponse<String>> registerUser(@Body RegisterRequest request);
}
