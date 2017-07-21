package com.example.andrew.myretrofit.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;

import com.example.andrew.myretrofit.activities.CartActivity;
import com.example.andrew.myretrofit.adapters.MainActivityAdapter;
import com.example.andrew.myretrofit.MyApplication;
import com.example.andrew.myretrofit.R;
import com.example.andrew.myretrofit.activities.CategoryMenuActivity;
import com.example.andrew.myretrofit.activities.MainMenuActivity;
import com.example.andrew.myretrofit.entities.EntityFoodCategory;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Andrew on 03.04.2017.
 */

public class FoodCategoriesFragment extends Fragment {

    private static final String TAG = FoodCategoriesFragment.class.getSimpleName();

    private List<EntityFoodCategory> entityFoodCategoryList;

    private GridView gridView;
    private Button button;

    private Context context;

    private Picasso picasso;

    private MainMenuActivity mainMenuActivity;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
        mainMenuActivity = (MainMenuActivity) context;
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View v = inflater.inflate(R.layout.food_categories_fragment, null);

        Log.v("fragment -------->", "Fragment!!!!!!!");

        //entityFoodCategoryList = mainMenuActivity.getEntityFoodCategoryList();
        entityFoodCategoryList = new ArrayList<>();

        MyApplication.getMyRetroApi().getFoodCategoryes().enqueue(new Callback<List<EntityFoodCategory>>() {
            @Override
            public void onResponse(Call<List<EntityFoodCategory>> call, Response<List<EntityFoodCategory>> response) {
                entityFoodCategoryList.addAll(response.body());

                MainActivityAdapter mainActivityAdapter = new MainActivityAdapter(entityFoodCategoryList, context, FoodCategoriesFragment.this);
                gridView = (GridView) v.findViewById(R.id.food_categories_fragment_grid_layout);
                gridView.setAdapter(mainActivityAdapter);
                gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent intent = new Intent(context, CategoryMenuActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("position", position);
                        intent.putExtras(bundle);
                        startActivity(intent);
                    }
                });

                for (EntityFoodCategory each : entityFoodCategoryList) {
                    Log.v(TAG, each.toString());
                }
            }

            @Override
            public void onFailure(Call<List<EntityFoodCategory>> call, Throwable t) {

            }
        });



        button = (Button) v.findViewById(R.id.food_categories_fragment_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(context, CartActivity.class));
            }
        });

        Log.v("fragment -------->", "Fragment2222222!!!!!!!");

        return v;
    }
}
