package com.example.andrew.myretrofit.adapters;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.andrew.myretrofit.R;
import com.example.andrew.myretrofit.entities.EntityFoodCategory;
import com.example.andrew.myretrofit.fragments.FoodCategoriesFragment;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Andrew on 04.04.2017.
 */

public class MainActivityAdapter extends BaseAdapter {

    private Picasso picasso;

    private List<EntityFoodCategory> entityFoodCategoryList;
    private Context context;
    FoodCategoriesFragment foodCategoriesFragment;

    public MainActivityAdapter(List<EntityFoodCategory> entityFoodCategoryList, Context context, FoodCategoriesFragment foodCategoriesFragment) {
        this.entityFoodCategoryList = entityFoodCategoryList;
        this.context = context;
        picasso = Picasso.with(foodCategoriesFragment.getContext());
        this.foodCategoriesFragment = foodCategoriesFragment;
    }

    @Override
    public int getCount() {
        return entityFoodCategoryList.size();
    }

    @Override
    public Object getItem(int position) {
        return entityFoodCategoryList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;
        ViewHolder viewHolder;
        if (v == null) {
            LayoutInflater inflater = LayoutInflater.from(foodCategoriesFragment.getContext());
            v = inflater.inflate(R.layout.food_categories_item, parent, false);

            viewHolder = new ViewHolder(v);
            v.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) v.getTag();
        }

        viewHolder.textView.setText(entityFoodCategoryList.get(position).getName());
        picasso.load(entityFoodCategoryList.get(position).getLink()).placeholder(R.drawable.im_android).into(viewHolder.imageView);

        return v;
    }

    private class ViewHolder {
        private TextView textView;
        private ImageView imageView;

        public ViewHolder(View v) {
            textView = (TextView) v.findViewById(R.id.food_categories_fragment_item_text_view);
            imageView = (ImageView) v.findViewById(R.id.food_categories_fragment_item_image);
        }
    }
}
