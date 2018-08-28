package com.example.android.myapplication;


import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.android.myapplication.data.DiscountContract.DiscountEntry;
import com.example.android.myapplication.data.DiscountDbHelper;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class DiscountFragment extends Fragment {

    ArrayList<Discount> discounts = new ArrayList<>();
    private DiscountDbHelper mDbHelper;

    public DiscountFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.activity_discount, container, false);
        mDbHelper = new DiscountDbHelper(getActivity());


        DiscountAdapter adapter = new DiscountAdapter(getActivity(), discounts);

        ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getActivity(), SingleDiscount.class);
                startActivity(intent);
            }
        });

        return rootView;
    }
    @Override
    public void onResume() {
        super.onResume();
        updateDisplay();
    }

    private void updateDisplay(){
        SQLiteDatabase db = mDbHelper.getReadableDatabase();

        String[] project = {
                DiscountEntry._ID,
                DiscountEntry.COLUMN_DISCOUNT,
                DiscountEntry.COLUMN_PUB,
                DiscountEntry.COLUMN_DATE,
                DiscountEntry.COLUMN_QR
        };

        Cursor cursor = db.query(
                DiscountEntry.TABLE_NAME,
                project,
                null,
                null,
                null,
                null,
                null);

        int discountColumnIndex = cursor.getColumnIndex(DiscountEntry.COLUMN_DISCOUNT);
        int pubColumnIndex = cursor.getColumnIndex(DiscountEntry.COLUMN_PUB);
        int dateColumnIndex = cursor.getColumnIndex(DiscountEntry.COLUMN_DATE);
        int QRColumnIndex = cursor.getColumnIndex(DiscountEntry.COLUMN_QR);

        while (cursor.moveToNext()){
            String currentDiscount = cursor.getString(discountColumnIndex);
            String currentPub = cursor.getString(pubColumnIndex);
            String currentDate = cursor.getString(dateColumnIndex);

            discounts.add(new Discount(currentDiscount, currentPub, R.drawable.beer));
        }
    }
}
