package com.example.android.myapplication.data;

import android.provider.BaseColumns;

/**
 * Created by macbook on 12.04.2018.
 */

public final class DiscountContract {
    public static abstract class DiscountEntry implements BaseColumns{
        public static final String TABLE_NAME = "discounts";
        public static final String COLUMN_DISCOUNT = "discount";
        public static final String COLUMN_PUB = "pub";
        public static final String COLUMN_DATE = "date";
        public static final String COLUMN_QR = "qr";

    }
}
