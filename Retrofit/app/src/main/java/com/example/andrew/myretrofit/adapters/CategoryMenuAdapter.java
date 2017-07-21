package com.example.andrew.myretrofit.adapters;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.andrew.myretrofit.R;
import com.example.andrew.myretrofit.activities.DescriptionFoodItemActivity;
import com.example.andrew.myretrofit.entities.EntityFood;
import com.squareup.picasso.Picasso;

import java.util.LinkedList;
import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by Andrew on 08.04.2017.
 */

public class CategoryMenuAdapter extends BaseAdapter {

    private List<EntityFood> entityFoodList = new LinkedList<>();
    private Context context;

    private Picasso picasso;

    public CategoryMenuAdapter(List<EntityFood> entityFoodList, Context context) {
        this.entityFoodList = entityFoodList;
        this.context = context;
        picasso = Picasso.with(context);
    }

    @Override
    public int getCount() {
        return entityFoodList.size();
    }

    @Override
    public Object getItem(int position) {
        return entityFoodList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        View v = convertView;
        ViewHolder holder;
        if (v == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            v = inflater.inflate(R.layout.category_menu_item, parent, false);

            holder = new ViewHolder(v);
            v.setTag(holder);
        } else {
            holder = (ViewHolder) v.getTag();
        }

        picasso.load(entityFoodList.get(position).getLink()).into(holder.imageView);
        holder.textView.setText(entityFoodList.get(position).getDescription());
        String s = entityFoodList.get(position).getPrice() + "$";
        holder.textViewPrice.setText(s);

        return v;
    }

    class ViewHolder {
        private ImageView imageView;
        private TextView textView;
        private TextView textViewPrice;

        public ViewHolder(View v) {
            this.imageView = (ImageView) v.findViewById(R.id.category_menu_item_card_view_image);
            this.textView = (TextView) v.findViewById(R.id.category_menu_item_card_view_text);
            this.textViewPrice = (TextView) v.findViewById(R.id.category_menu_item_card_view_text_price);
        }
    }
}
