package com.example.projectdemo1;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AppApi {
    public static AppService appService;
    public static AppService getAppService(){
        if(appService == null){
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://api.sampleapis.com")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            appService = retrofit.create(AppService.class);
        }
        return appService;
    }
}
