package com.example.andrew.myretrofit.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.andrew.myretrofit.MyApplication;
import com.example.andrew.myretrofit.R;
import com.example.andrew.myretrofit.entities.EntityCart;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Andrew on 08.04.2017.
 */

public class CartActivity extends AppCompatActivity {

    private CartActivity cartActivity;
    private List<EntityCart> entityCartList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cart_activity);

        entityCartList = new ArrayList<>();

        MyApplication.getMyRetroApi().getListHistory(MyApplication.getEntityUser().getDeviceId()).enqueue(new Callback<List<EntityCart>>() {
            @Override
            public void onResponse(Call<List<EntityCart>> call, Response<List<EntityCart>> response) {
                entityCartList.addAll(response.body());

            }

            @Override
            public void onFailure(Call<List<EntityCart>> call, Throwable t) {

            }
        });
    }
}
