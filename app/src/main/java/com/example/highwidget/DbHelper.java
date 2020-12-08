package com.example.highwidget;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {
    private static String DB_PATH = "/data/data/com.example.highwiget/databases";

    //코드에서 만들어야 제대로 만들어짐.
    //private static String DB_NAME = "highdb";

    public DbHelper(Context context){
        super(context, "highdb2", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //table을 만들때!
        sqLiteDatabase.execSQL("create table groupTBL (gName char(20) primary key, gNumber integer)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        //table을 삭제할 때!
        sqLiteDatabase.execSQL("drop table groupTBL");
    }
}
