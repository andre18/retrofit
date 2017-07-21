package com.example.andrew.myretrofit.activities;

import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.example.andrew.myretrofit.MyApplication;
import com.example.andrew.myretrofit.R;
import com.example.andrew.myretrofit.entities.EntityFoodCategory;
import com.example.andrew.myretrofit.entities.EntityUser;
import com.example.andrew.myretrofit.fragments.FoodCategoriesFragment;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Andrew on 05.04.2017.
 */

public class MainMenuActivity extends AppCompatActivity {

    private static final String TAG = MainMenuActivity.class.getSimpleName();

    private List<EntityFoodCategory> entityFoodCategoryList;

    private EntityUser entityUser;
    private String deviceId;

    private Toolbar toolbar;

    private FragmentTransaction transaction;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu_activity);

        //initBar();

        deviceId = Settings.Secure.getString(getContentResolver(), Settings.Secure.ANDROID_ID);
        entityUser = MyApplication.getEntityUser();
        entityUser.setDeviceId(deviceId);

        MyApplication.getMyRetroApi().getUserByDeviceId(entityUser.getDeviceId()).enqueue(new Callback<EntityUser>() {
            @Override
            public void onResponse(Call<EntityUser> call, Response<EntityUser> response) {
                Log.v(TAG, "response.code() --> " + response.code());
                if (response.code() == 404) {
                    createNewUser();
                } else if (response.code() == 200) {
                    entityUser = response.body();
                    MyApplication.setEntityUser(entityUser);
                    Log.v(TAG, entityUser.toString());
                }
            }

            @Override
            public void onFailure(Call<EntityUser> call, Throwable t) {
                Log.v(TAG, "createUser Throwable --> " + t.toString());
            }
        });


        transaction = getSupportFragmentManager().beginTransaction();
        FoodCategoriesFragment foodCategoriesFragment = new FoodCategoriesFragment();
        transaction.add(R.id.main_menu_activity, foodCategoriesFragment);
        transaction.commit();
    }

    private void createNewUser() {
        MyApplication.getMyRetroApi().createUser(entityUser).enqueue(new Callback<EntityUser>() {
            @Override
            public void onResponse(Call<EntityUser> call, Response<EntityUser> response) {
                entityUser = response.body();
                MyApplication.setEntityUser(entityUser);
                Log.v(TAG, entityUser.toString());
            }

            @Override
            public void onFailure(Call<EntityUser> call, Throwable t) {

            }
        });
    }

    public List<EntityFoodCategory> getEntityFoodCategoryList() {
        return entityFoodCategoryList;
    }

    private void initBar() {
        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
        toolbar.setTitle(R.string.app_name);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                return false;
            }
        });

        toolbar.inflateMenu(R.menu.menu);
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }
}
