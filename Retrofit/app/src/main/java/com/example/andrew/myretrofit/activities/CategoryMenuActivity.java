package com.example.andrew.myretrofit.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.andrew.myretrofit.MyApplication;
import com.example.andrew.myretrofit.R;
import com.example.andrew.myretrofit.adapters.CategoryMenuAdapter;
import com.example.andrew.myretrofit.entities.EntityFood;

import java.util.LinkedList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Andrew on 05.04.2017.
 */

public class CategoryMenuActivity extends AppCompatActivity {

    private static final String TAG = CategoryMenuActivity.class.getSimpleName();

    private int position;

    private ListView listView;
    private Toolbar toolbar;

    private List<EntityFood> entityFoodList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.category_menu_activity);



        final Bundle bundle = getIntent().getExtras();
        position = bundle.getInt("position") + 1;

        entityFoodList = new LinkedList<>();
        Log.v(TAG, "hello");

        listView = (ListView) findViewById(R.id.category_menu_activity_list_view);

        MyApplication.getMyRetroApi().getFoodByCategoryId(position + "").enqueue(new Callback<List<EntityFood>>() {
            @Override
            public void onResponse(Call<List<EntityFood>> call, Response<List<EntityFood>> response) {
                entityFoodList.addAll(response.body());
                listView.setAdapter(new CategoryMenuAdapter(entityFoodList, CategoryMenuActivity.this));
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        MyApplication.setEntityFood(entityFoodList.get(position));
                        startActivity(new Intent(CategoryMenuActivity.this, DescriptionFoodItemActivity.class));
                    }
                });
                for (EntityFood each : entityFoodList) {
                    Log.v(TAG, each.toString());
                }
            }

            @Override
            public void onFailure(Call<List<EntityFood>> call, Throwable t) {

            }
        });
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
