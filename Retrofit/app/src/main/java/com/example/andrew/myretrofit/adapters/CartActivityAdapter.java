package com.example.andrew.myretrofit.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.andrew.myretrofit.R;
import com.example.andrew.myretrofit.entities.EntityCart;
import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by Andrew on 10.04.2017.
 */

public class CartActivityAdapter extends BaseAdapter {

    private List<EntityCart> entityCartList;
    private Context context;

    private Picasso picasso;

    public CartActivityAdapter(List<EntityCart> entityCartList, Context context) {
        this.entityCartList = entityCartList;
        this.context = context;
        this.picasso = Picasso.with(context);
    }

    @Override
    public int getCount() {
        return entityCartList.size();
    }

    @Override
    public Object getItem(int position) {
        return entityCartList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;
        ViewHolder holder;

        if (v == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            v = inflater.inflate(R.layout.cart_activity_item, parent, false);

            holder = new ViewHolder(v);
            v.setTag(holder);
        } else {
            holder = (ViewHolder) v.getTag();
        }

        //picasso.load(entityCartList.get(position))
        //holder.textDescription.setText();

        return v;
    }

    class ViewHolder {
        private ImageView imageView;
        private TextView textDescription;
        private TextView textPrice;

        public ViewHolder(View v) {
            this.imageView = (ImageView) v.findViewById(R.id.cart_activity_item_card_view_image);
            this.textDescription = (TextView) v.findViewById(R.id.cart_activity_item_card_view_text_title);
            this.textPrice = (TextView) v.findViewById(R.id.cart_activity_item_card_view_text_price);
        }
    }
}
