package com.example.android.myapplication;

import android.text.format.DateFormat;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by macbook on 20.02.2018.
 */

public class Discount {
    private String amount;
    private String pub;
    private Date currentDate;
    private Date expiryDate;
    private String expiryDateString;
    private Calendar currentCalendar;
    private int imageResourceId;


    public Discount(String disAmount, String disPub, int disImageResourceId){
        amount = disAmount;
        pub = disPub;
        imageResourceId = disImageResourceId;
        currentDate = new Date();
        currentCalendar = Calendar.getInstance();
        currentCalendar.setTime(currentDate);
        currentCalendar.add(Calendar.DATE, 7);
        expiryDate = currentCalendar.getTime();
        expiryDateString = DateFormat.format("yyyy.MM.dd",expiryDate).toString();
    }

    public String getAmount(){
        return amount;
    }

    public String getPub(){
        return pub;
    }

    public int getImageResourceId(){
        return imageResourceId;
    }

    public String getExpiryDate(){
        return expiryDateString;
    }
}
