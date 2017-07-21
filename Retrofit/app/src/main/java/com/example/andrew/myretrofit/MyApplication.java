package com.example.andrew.myretrofit;

import android.app.Application;

import com.example.andrew.myretrofit.entities.EntityFood;
import com.example.andrew.myretrofit.entities.EntityUser;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Andrew on 03.04.2017.
 */

public class MyApplication extends Application {

    private Retrofit retrofit;
    private static MyRetroApi myRetroApi;

    private static EntityUser entityUser;
    private static EntityFood entityFood;

    @Override
    public void onCreate() {
        super.onCreate();

        entityUser = new EntityUser();

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        retrofit = new Retrofit.Builder().baseUrl(Constants.SERVER_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        myRetroApi = retrofit.create(MyRetroApi.class);
    }

    public static MyRetroApi getMyRetroApi() {
        return myRetroApi;
    }

    public static EntityUser getEntityUser() {
        return entityUser;
    }

    public static void setEntityUser(EntityUser entityUser) {
        MyApplication.entityUser = entityUser;
    }

    public static EntityFood getEntityFood() {
        return entityFood;
    }

    public static void setEntityFood(EntityFood entityFood) {
        MyApplication.entityFood = entityFood;
    }
}
