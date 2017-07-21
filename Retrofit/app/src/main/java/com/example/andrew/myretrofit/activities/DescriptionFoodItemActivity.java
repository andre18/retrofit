package com.example.andrew.myretrofit.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.andrew.myretrofit.MyApplication;
import com.example.andrew.myretrofit.R;
import com.example.andrew.myretrofit.entities.EntityFood;
import com.squareup.picasso.Picasso;

/**
 * Created by Andrew on 08.04.2017.
 */

public class DescriptionFoodItemActivity extends AppCompatActivity {

    private ImageView imageView;
    private TextView textTitle, textPrice, textDescription, textIngredients, textRating;
    private Button button;

    private Picasso picasso;

    private EntityFood entityFood;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.description_food_item_activity);

        picasso = Picasso.with(this);
        entityFood = MyApplication.getEntityFood();

        imageView = (ImageView) findViewById(R.id.description_food_item_activity_image);
        textTitle = (TextView) findViewById(R.id.description_food_item_activity_text_title);
        textPrice = (TextView) findViewById(R.id.description_food_item_activity_text_price);
        textDescription = (TextView) findViewById(R.id.description_food_item_activity_text_description);
        textIngredients = (TextView) findViewById(R.id.description_food_item_activity_text_ingredients);
        textRating = (TextView) findViewById(R.id.description_food_item_activity_text_rating);
        button = (Button) findViewById(R.id.description_food_item_activity_button_add_to_cart);

        picasso.load(entityFood.getLink()).into(imageView);
        textTitle.setText(entityFood.getTitle());
        String s = "Price: " + entityFood.getPrice() + "$";
        textPrice.setText(s);
        textDescription.setText(entityFood.getDescription());
        textIngredients.setText(entityFood.getIngredients());
        s = "Orders: " + entityFood.getRating();
        textRating.setText(s);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DescriptionFoodItemActivity.this, CartActivity.class));
            }
        });
    }
}
