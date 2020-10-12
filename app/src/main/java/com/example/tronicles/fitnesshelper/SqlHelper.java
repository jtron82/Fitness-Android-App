package com.example.tronicles.fitnesshelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andrzej on 4/16/2018.
 */

public class SqlHelper extends SQLiteOpenHelper {

    // Database Version
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_Name = "ExcercisessInfo";
    // Excercises table name
    private static final String TABLE_ExcercisesS = "Excercisess";
    // Excercisess Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_Name = "Name";
    private static final String KEY_EX_LENGTH = "Excerciselength";
    private static final String KEY_TIME="Timetoexcercise";

    public SqlHelper(Context context) {
        super(context, DATABASE_Name, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_ExcercisesS + "("
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," + KEY_Name + " TEXT, "
                + KEY_EX_LENGTH + " TEXT, " +KEY_TIME+" TEXT "+ ")";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
// Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ExcercisesS);
// Creating tables again
        onCreate(db);
    }

    // Adding new Excercises
    public void addExcercise(Excercises Excercises) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_Name, Excercises.getName()); // Excercises Name
        values.put(KEY_EX_LENGTH, Excercises.getExcerciselength()); // Excercises Excerciselength
        values.put(KEY_TIME,Excercises.getTimetoexcercise());//Excercises Timetoexcercise
// Inserting Row
        db.insert(TABLE_ExcercisesS, null, values);
        db.close(); // Closing database connection
    }

    // Getting one Excercises
    public Excercises getExcercise(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_ExcercisesS, new String[]{KEY_ID,
                        KEY_Name, KEY_EX_LENGTH,KEY_TIME}, KEY_ID + " =?",
                new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Excercises contact = new Excercises(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), Integer.parseInt(cursor.getString(2)),(cursor.getString(3)));
// return Excercises
        return contact;
    }

    // Getting All Excercisess
    public List<Excercises> getAllExcercisess() {
        List<Excercises> ExcercisesList = new ArrayList<Excercises>();
// Select All Query
        String selectQuery = "SELECT * FROM "+TABLE_ExcercisesS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

// looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Excercises Excercises = new Excercises();
                Excercises.setId(Integer.parseInt(cursor.getString(0)));
                Excercises.setName(cursor.getString(1));
                Excercises.setExcerciselength(Integer.parseInt(cursor.getString(2)));
                Excercises.setTimetoexcercise((cursor.getString(3)));
// Adding contact to list
                ExcercisesList.add(Excercises);
            } while (cursor.moveToNext());
        }

// return contact list
        return ExcercisesList;
    }
    // Updating a Excercises
    public int updateExcercises(Excercises Excercises) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_Name, Excercises.getName());
        values.put(KEY_EX_LENGTH, Excercises.getExcerciselength());
        values.put(KEY_TIME, Excercises.getTimetoexcercise());
// updating row
        return db.update(TABLE_ExcercisesS, values, KEY_ID + " = ?",
                new String[]{String.valueOf(Excercises.getId())});
    }

    // Deleting a Excercises
    public void deleteExcercise(int  id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_ExcercisesS, KEY_ID + " = ?",
                new String[]{String.valueOf(id)});
        db.close();
    }

}
