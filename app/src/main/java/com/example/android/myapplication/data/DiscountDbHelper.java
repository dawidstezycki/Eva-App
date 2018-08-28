package com.example.android.myapplication.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.android.myapplication.CounterFragment;
import com.example.android.myapplication.data.DiscountContract.DiscountEntry;

/**
 * Created by macbook on 12.04.2018.
 */

public class DiscountDbHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "wallet";
    private static final int DATABASE_VERSION = 1;

    public DiscountDbHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL_CREATE_TABLE = "CREATE TABLE " + DiscountEntry.TABLE_NAME + "("
                + DiscountEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + DiscountEntry.COLUMN_DISCOUNT + " TEXT NOT NULL, "
                + DiscountEntry.COLUMN_PUB + " TEXT NOT NULL, "
                + DiscountEntry.COLUMN_DATE + " TEXT NOT NULL, "
                + DiscountEntry.COLUMN_QR + " INTEGER NOT NULL);";

        db.execSQL(SQL_CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
