package com.zybooks.MyWeight;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
/*
 *===================================================================================================
 * The DBHelper class is where the database is created, updated, weight data is inserted, weight list
 * is grabbed, updates on date/weight data is performed, deletes on date/weight data is performed,
 * and where checks on the existence of the date and weight field are in the database.
 *
 * BEFORE CHANGES:
 * The original applications DBHelper class was using three databases to
 * store information. There was even an entirely unused database. There was unused code present,
 * the update features were incorrectly implemented causing a dialog to say that weight or date
 * update was successful even if it wasn't.
 *
 * AFTER CHANGES:
 * The databases were reworked and user login was removed due to design
 * choices. The goal database was removed and instead a shared preferences for goal was used in
 * HomeActivity and AddWeights. Unused code and databases were removed, only one database is in use
 * now, update functions were reworked and now properly function.
 *
 *===================================================================================================
 */

public class DBHelper extends SQLiteOpenHelper {

    //Database name
    private static final String DBNAME = "MyWeight.db";

    //Database version
    private static final int DATABASE_VERSION = 1;

    //Database Table names
    private static final String TABLE_USERS = "userData";

    //Table columns
    public static final String ID = "userId";
    public static final String DATE = "date";
    public static final String WEIGHT = "weight";

    public DBHelper(Context context) {
        super(context, DBNAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase MyDB) {
        //Creates a table for the users login info
        MyDB.execSQL("create Table userData("+ ID + " INTEGER primary key autoincrement, "+ DATE + " TEXT, "+ WEIGHT + " TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int i, int i1) {
        //Drops tables on upgrade
        MyDB.execSQL("drop Table if exists "+ TABLE_USERS);
        onCreate(MyDB);
    }

    //Inserts date and weight into a table
    public Boolean insertWeightData(String date, String weight) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        //Create ContentValues
        ContentValues contentValues = new ContentValues();
        contentValues.put(DATE, date);
        contentValues.put(WEIGHT, weight);
        //Insert data into database
        long result = MyDB.insert(TABLE_USERS,null, contentValues);
        return result != -1;
    }

    //Populates list view with user entered dates and corresponding weights
    public ArrayList<User> getWeightList(){
        ArrayList<User> arrayList = new ArrayList<>();
        SQLiteDatabase MyDB = this.getReadableDatabase();
        @SuppressLint("Recycle") Cursor cursor = MyDB.rawQuery("Select * from userData", null); // closing cursor here causing issues. Hence the suppression.

        //Iterate through the array list
        while(cursor.moveToNext()){
            int id = cursor.getInt(0);
            String date = cursor.getString(1);
            String weight = cursor.getString(2);
            User user = new User(id,date,weight);
            arrayList.add(user);
        }
        return arrayList;
    }

    //Updates the date value
    public void updateDate(String newDate, String getID){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(DATE,newDate);
        MyDB.update(TABLE_USERS, contentValues, "userId = ?", new String[] {getID});
    }

    //Updates weight to new weight value
    public void updateWeight(String newWeight, String getID){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(WEIGHT,newWeight);
        MyDB.update(TABLE_USERS, contentValues, "userId = ?", new String[] {getID});
    }

    /*
    ================================================================================================
    * Checks to verify date or weight exists in the table.
    ================================================================================================
    */
    //Checks if date exists in table
    public Boolean checkDate(String date) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        @SuppressLint("Recycle") Cursor cursor = MyDB.rawQuery("Select date from userData where "+ DATE +" = ?", new String[] {date});
        return cursor.getCount() > 0;
    }

    //Checks if weight exists in table
    public Boolean checkWeight(String weight) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        @SuppressLint("Recycle") Cursor cursor = MyDB.rawQuery("Select weight from userData where "+ WEIGHT +" = ?", new String[] {weight});
        return cursor.getCount() > 0;
    }

    /*
    ================================================================================================
    * These are necessary to verify the location of the date and weight in the database from the
    * UpdateView activity.
    ================================================================================================
    */
    //Pull ID from table where data matches
    public int getDateID(String getDate){
        SQLiteDatabase MyDB = this.getReadableDatabase();
        Cursor cursor = MyDB.rawQuery("SELECT userId FROM userData WHERE date=?", new String[]{getDate});
        int id = -1;
        if (cursor.moveToFirst()) id = cursor.getInt(0);
        cursor.close();
        MyDB.close();
        return id;
    }

    //Pull ID from table where data matches
    public int getWeightID(String getWeight){
        SQLiteDatabase MyDB = this.getReadableDatabase();
        Cursor cursor = MyDB.rawQuery("SELECT userId FROM userData WHERE weight=?", new String[]{getWeight});
        int id = -1;
        if (cursor.moveToFirst()) id = cursor.getInt(0);
        cursor.close();
        MyDB.close();
        return id;
    }

    /*
    ================================================================================================
    * These will delete both the date and weight from the database in that row. The reason for both
    * is in case the user only wants to enter one of the fields.
    ================================================================================================
    */
    //Delete date from database
    public void deleteDate(String oldDate){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        MyDB.delete(TABLE_USERS, "date = ?", new String[] {oldDate});
    }

    //Delete weight from database
    public void deleteWeight(String oldWeight){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        MyDB.delete(TABLE_USERS, "weight = ?", new String[] {oldWeight});
    }


}

