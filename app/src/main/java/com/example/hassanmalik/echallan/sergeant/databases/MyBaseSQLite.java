package com.example.hassanmalik.echallan.sergeant.databases;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.io.File;

/**
 * Created by Administrator on 1/6/2018.
 */

public class MyBaseSQLite extends SQLiteOpenHelper {

    /**
     * Represents an activity
     */
    private Context context;
    /**
     * Reepresents the table name
     */
    private static final String Table_Add_Citizens = "add_citizens";
    /**
     * Represents the column ID
     */
    private static final String Col_Auto_Id = "Auto_Id";
    /**
     * Represents the column Agent_Id
     */
    private static final String Col_Citizens_Id = "Citizens_Id";
    /**
     * Represents column Agent_Name in the tabale
     */
    private static final String Col_Citizens_Name = "Citizens_Name";




    private static final String REQUEST_CREATE_RIDES_TABLE = "CREATE TABLE IF NOT EXISTS "
            +Table_Add_Citizens+" ("+
            Col_Auto_Id +" INTEGER PRIMARY KEY AUTOINCREMENT, "+
            Col_Citizens_Id+" TEXT NOT NULL DEFAULT '0',"+
            Col_Citizens_Name+" TEXT NOT NULL DEFAULT '0');";


    /**
     * Class constructor
     * @param context(in), @Activity represents activity
     * @param nameDB(in), @String is the database name
     * @param version(in), @Integer is the database version
     */
    public MyBaseSQLite(Context context, String nameDB, int version){
        super(context, nameDB, null, version);
        //Log.i("Adneom"," in constructor DB ");
        SQLiteDatabase db = getWritableDatabase();
        long size = new File(db.getPath()).length();
        Log.v("DB SIZE", "Percentage database space used: " + size);
    }
    /**
     * Allows to create the tables in database.
     * @param db(in), @SQLite represents the database instnace
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(REQUEST_CREATE_RIDES_TABLE);

    }
    //call when we change version
    /**
     * Allows to re create a new database with a neww version. SQLiteOpenHelepr method basic.
     * @param db(in), @SQLite represents the instance database
     * @param oldVersion(in), @Integer represents the previous database version
     * @param newVersion(in), @Integer represents the new database version
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //Log.i("Adneom"," drop table ");

        Log.i("onUpgrade", "Update Schema to version: "+Integer.toString(oldVersion)+"->"+Integer.toString(newVersion));
        try{


            if(newVersion > oldVersion){
                db.execSQL(REQUEST_CREATE_RIDES_TABLE);
                /*db.execSQL("ALTER TABLE " + Table_Add_Agents + " ADD COLUMN " + Col_Form_Status + " INTEGER DEFAULT 0");*/

            }
        }catch (SQLException e){

        }



    }
}
