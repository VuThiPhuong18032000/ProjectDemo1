package com.example.projectdemo1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    List<Coffee> list ;

    String TAG = MainActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AppApi.getAppService().getCoffee().enqueue(new Callback<List<Coffee>>() {
            @Override
            public void onResponse(Call<List<Coffee>> call, Response<List<Coffee>> response) {
                list=response.body();
                display();
                Log.d(TAG, "onResponse: ");
            }

            @Override
            public void onFailure(Call<List<Coffee>> call, Throwable t) {
                Log.d(TAG, "onFailure: ");
            }
        });

    }
    private void display(){
        RecyclerView recyclerView = findViewById(R.id.rc_Coffee);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplication(), 2);
        gridLayoutManager.setOrientation(GridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(gridLayoutManager);
        AdapterCoffee adapter = new AdapterCoffee(list);
        recyclerView.setAdapter(adapter);
    }
}