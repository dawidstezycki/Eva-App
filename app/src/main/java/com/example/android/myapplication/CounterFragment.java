package com.example.android.myapplication;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.myapplication.data.DiscountContract.DiscountEntry;
import com.example.android.myapplication.data.DiscountDbHelper;
import com.example.android.myapplication.data.MessageEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * A simple {@link Fragment} subclass.
 */
public class CounterFragment extends Fragment {

    int points = 0;
    int total = 0;
    String mMessage;

    TextView pointDisplay;
    TextView totalDisplay;


    ImageView Leaf1;
    ImageView Leaf2;
    ImageView Leaf3;
    ImageView Leaf4;
    ImageView Leaf5;
    ImageView Leaf6;
    ImageView Leaf7;
    ImageView Leaf8;
    ImageView Leaf9;
    ImageView Leaf10;

    DiscountDbHelper mDbHelper;


    public CounterFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.activity_counter, container, false);

        pointDisplay = (TextView) rootView.findViewById(R.id.point_counter);
        totalDisplay = (TextView) rootView.findViewById(R.id.totalcigarettes);
        Leaf1 = (ImageView) rootView.findViewById(R.id.leaf1);
        Leaf2 = (ImageView) rootView.findViewById(R.id.leaf2);
        Leaf3 = (ImageView) rootView.findViewById(R.id.leaf3);
        Leaf4 = (ImageView) rootView.findViewById(R.id.leaf4);
        Leaf5 = (ImageView) rootView.findViewById(R.id.leaf5);
        Leaf6 = (ImageView) rootView.findViewById(R.id.leaf6);
        Leaf7 = (ImageView) rootView.findViewById(R.id.leaf7);
        Leaf8 = (ImageView) rootView.findViewById(R.id.leaf8);
        Leaf9 = (ImageView) rootView.findViewById(R.id.leaf9);
        Leaf10 = (ImageView) rootView.findViewById(R.id.leaf10);

        mDbHelper = new DiscountDbHelper(getActivity());

        pointDisplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addPoints(rootView);
            }
        });

        return rootView;
    }

    public void addPoints(View view){

        points += 1;

        if (points == 1){
            Leaf1.setVisibility(View.VISIBLE);
        }

        if (points == 2){
            Leaf2.setVisibility(View.VISIBLE);
        }

        if (points == 3){
            Leaf3.setVisibility(View.VISIBLE);
        }

        if (points == 4){
            Leaf4.setVisibility(View.VISIBLE);
        }

        if (points == 5){
            Leaf5.setVisibility(View.VISIBLE);
        }

        if (points == 6){
            Leaf6.setVisibility(View.VISIBLE);
        }

        if (points == 7){
            Leaf7.setVisibility(View.VISIBLE);
        }

        if (points == 8){
            Leaf8.setVisibility(View.VISIBLE);
        }

        if (points == 9){
            Leaf9.setVisibility(View.VISIBLE);
        }

        if (points == 10){
            Leaf10.setVisibility(View.VISIBLE);
        }

        if (points > 10){
            points = 1;
            Toast.makeText(getActivity(),"New discount added!",Toast.LENGTH_SHORT).show();
            Leaf2.setVisibility(View.INVISIBLE);
            Leaf3.setVisibility(View.INVISIBLE);
            Leaf4.setVisibility(View.INVISIBLE);
            Leaf5.setVisibility(View.INVISIBLE);
            Leaf6.setVisibility(View.INVISIBLE);
            Leaf7.setVisibility(View.INVISIBLE);
            Leaf8.setVisibility(View.INVISIBLE);
            Leaf9.setVisibility(View.INVISIBLE);
            Leaf10.setVisibility(View.INVISIBLE);

            insertDiscount();
        }

        pointDisplay.setText("" + points);
    }

    private void insertDiscount(){
        SQLiteDatabase db = mDbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DiscountEntry.COLUMN_DISCOUNT , "5%");
        values.put(DiscountEntry.COLUMN_PUB , "Murphy's Irish Pub");
        values.put(DiscountEntry.COLUMN_DATE, "15.05");
        values.put(DiscountEntry.COLUMN_QR, R.drawable.beer);

        long newRowId = db.insert(DiscountEntry.TABLE_NAME, null, values);

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(MessageEvent event) {
        points += 1;

        if (points == 1){
            Leaf1.setVisibility(View.VISIBLE);
        }

        if (points == 2){
            Leaf2.setVisibility(View.VISIBLE);
        }

        if (points == 3){
            Leaf3.setVisibility(View.VISIBLE);
        }

        if (points == 4){
            Leaf4.setVisibility(View.VISIBLE);
        }

        if (points == 5){
            Leaf5.setVisibility(View.VISIBLE);
        }

        if (points == 6){
            Leaf6.setVisibility(View.VISIBLE);
        }

        if (points == 7){
            Leaf7.setVisibility(View.VISIBLE);
        }

        if (points == 8){
            Leaf8.setVisibility(View.VISIBLE);
        }

        if (points == 9){
            Leaf9.setVisibility(View.VISIBLE);
        }

        if (points == 10){
            Leaf10.setVisibility(View.VISIBLE);
        }

        if (points > 10){
            points = 1;
            Toast.makeText(getActivity(),"New discount added!",Toast.LENGTH_SHORT).show();
            Leaf2.setVisibility(View.INVISIBLE);
            Leaf3.setVisibility(View.INVISIBLE);
            Leaf4.setVisibility(View.INVISIBLE);
            Leaf5.setVisibility(View.INVISIBLE);
            Leaf6.setVisibility(View.INVISIBLE);
            Leaf7.setVisibility(View.INVISIBLE);
            Leaf8.setVisibility(View.INVISIBLE);
            Leaf9.setVisibility(View.INVISIBLE);
            Leaf10.setVisibility(View.INVISIBLE);

            insertDiscount();
        }

        pointDisplay.setText("" + points);
    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        EventBus.getDefault().unregister(this);
        super.onStop();
    }

}
