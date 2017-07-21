package com.example.andrew.myretrofit;

import com.example.andrew.myretrofit.entities.EntityCart;
import com.example.andrew.myretrofit.entities.EntityFood;
import com.example.andrew.myretrofit.entities.EntityFoodCategory;
import com.example.andrew.myretrofit.entities.EntityUser;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by Andrew on 03.04.2017.
 */

public interface MyRetroApi {

    @POST("api/users")
    Call<EntityUser> createUser(@Body EntityUser entityUser);

    @GET("api/users/device-id/{device_id}")
    Call<EntityUser> getUserByDeviceId(@Path("device_id") String deviceId);

    @GET("api/food-categories")
    Call<List<EntityFoodCategory>> getFoodCategoryes();

    @GET("api/food-categories/{id}")
    Call<List<EntityFood>> getFoodByCategoryId(@Path("id") String id);

    @POST("api/cart-save")
    Call<EntityCart> sendCartEntity(@Body EntityCart entityCart);

    @GET("api/history/{device_id}")
    Call<List<EntityCart>> getListHistory(@Path("device_id") String deviceId);
}
