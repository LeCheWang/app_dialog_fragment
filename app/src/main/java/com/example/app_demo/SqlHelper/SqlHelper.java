package com.example.app_demo.SqlHelper;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.app_demo.Models.Hike;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SqlHelper extends SQLiteOpenHelper {
    static final String DB_NAME = "hike_db";
    static final int DB_VERSION = 1;

    static final String TB_HIKE = "hike";
    static final String TB_OBSERVATION = "observation";

    SQLiteDatabase sqLiteDatabase;
    ContentValues contentValues;

    public SqlHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query1 = "CREATE TABLE " + TB_HIKE + "(id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, name TEXT, location TEXT, dateOfTheHike TEXT, parkingAvailable TEXT, lengthOfTheHike NUMBER, difficultLevel TEXT, description TEXT)";

        String query2 = "CREATE TABLE " + TB_OBSERVATION + "(id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, name TEXT, time TEXT, comment TEXT, hike_id INTEGER)";

        db.execSQL(query1);
        db.execSQL(query2);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion != newVersion){
            db.execSQL("DROP TABLE IF EXISTS " + TB_HIKE);
            db.execSQL("DROP TABLE IF EXISTS " + TB_OBSERVATION);
            onCreate(db);
        }
    }

    public void insertHike(Hike hike){
        sqLiteDatabase = getWritableDatabase();
        contentValues = new ContentValues();

        contentValues.put("name", hike.getName());
        contentValues.put("location", hike.getLocation());
        contentValues.put("dateOfTheHike", hike.getDateOfTheHike());
        contentValues.put("parkingAvailable", hike.isParkingAvailable() + "");
        contentValues.put("lengthOfTheHike", hike.getLengthOfTheHike());
        contentValues.put("difficultLevel", hike.getDifficultLevel());
        contentValues.put("description", hike.getDescription());

        sqLiteDatabase.insert(TB_HIKE, null, contentValues);
        sqLiteDatabase.close();
    }

    public List<Hike> getHikes(){
        List<Hike> hikes = new ArrayList<>();
        sqLiteDatabase = getReadableDatabase();

        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + TB_HIKE, new String[]{});

        while(cursor.moveToNext()){
            @SuppressLint("Range") int id = cursor.getInt(cursor.getColumnIndex("id"));
            @SuppressLint("Range") String name = cursor.getString(cursor.getColumnIndex("name"));
            @SuppressLint("Range") String location = cursor.getString(cursor.getColumnIndex("location"));
            @SuppressLint("Range") String dateOfTheHike = cursor.getString(cursor.getColumnIndex("dateOfTheHike"));
            @SuppressLint("Range") boolean parkingAvailable = Boolean.parseBoolean(cursor.getString(cursor.getColumnIndex("parkingAvailable")));
            @SuppressLint("Range") int lengthOfTheHike = cursor.getInt(cursor.getColumnIndex("lengthOfTheHike"));
            @SuppressLint("Range") String difficultLevel = cursor.getString(cursor.getColumnIndex("difficultLevel"));
            @SuppressLint("Range") String description = cursor.getString(cursor.getColumnIndex("description"));

            hikes.add(new Hike(id, name, location, dateOfTheHike, parkingAvailable, lengthOfTheHike, difficultLevel, description));
        }
        sqLiteDatabase.close();

        return hikes;
    }

    public void deleteHike(int id){
        sqLiteDatabase = getWritableDatabase();
        sqLiteDatabase.delete(TB_HIKE, "id=?", new String[]{id+""});
        sqLiteDatabase.close();
    }

    public void updateHike(Hike hike){
        sqLiteDatabase = getWritableDatabase();
        contentValues = new ContentValues();

        contentValues.put("name", hike.getName());
        contentValues.put("location", hike.getLocation());
        contentValues.put("dateOfTheHike", hike.getDateOfTheHike());
        contentValues.put("parkingAvailable", hike.isParkingAvailable() + "");
        contentValues.put("lengthOfTheHike", hike.getLengthOfTheHike());
        contentValues.put("difficultLevel", hike.getDifficultLevel());
        contentValues.put("description", hike.getDescription());

        sqLiteDatabase.update(TB_HIKE, contentValues, "id=?", new String[]{hike.getId()+""});
        sqLiteDatabase.close();
    }

//    observation
//    public List<Objects> getObservationByHikeId(int hike_id){
//
//    }
//
//    public void createObservation(){
//
//    }
}
