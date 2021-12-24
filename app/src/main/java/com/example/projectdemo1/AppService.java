package com.example.projectdemo1;


import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface AppService {
    @GET("/coffee/hot")
    Call<List<Coffee>> getCoffee();
}
