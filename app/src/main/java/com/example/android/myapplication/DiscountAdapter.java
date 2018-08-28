package com.example.android.myapplication;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by macbook on 20.02.2018.
 */

public class DiscountAdapter extends ArrayAdapter<Discount> {
    public DiscountAdapter(Activity context, ArrayList<Discount> discounts){
        super(context,0, discounts);
    }

    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);
        }

        Discount currentDiscount = getItem(position);

        TextView amountTextView = (TextView) listItemView.findViewById(R.id.amount);
        amountTextView.setText("Discount: " + currentDiscount.getAmount());

        TextView pubTextView = (TextView) listItemView.findViewById(R.id.pub);
        pubTextView.setText(currentDiscount.getPub());

        TextView dateTextView = (TextView) listItemView.findViewById(R.id.date);
        dateTextView.setText("Expiry date: " + currentDiscount.getExpiryDate());

        ImageView iconImageView = (ImageView) listItemView.findViewById(R.id.image);
        iconImageView.setImageResource(currentDiscount.getImageResourceId());

        return listItemView;
    }
}
