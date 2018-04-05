package com.example.hassanmalik.echallan.sergeant.databases;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.hassanmalik.echallan.sergeant.Model.CitizenList;

/**
 * Created by Administrator on 4/5/2018.
 */

public class AddCitizens {

    private static final int VERSION_DB = 1;

    /**
     * Represents the database name
     */
    private static final String NOM_BDD = "echallan_addcitizens.db";
    /**
     * Represents the tabale name
     */
    private static final String Table_Add_Citizens = "add_citizens";


    /**
     * Represents column ID in the tabale
     */
    private static final String Col_Auto_Id = "Auto_Id";
    /**
     * Represents position column ID in the tabale
     */
    private static final int NUM_COL_ID = 0;
    /**
     * Represents column Agent Id in the tabale
     */
    private static final String Col_Citizens_Id = "Citizens_Id";
    /**
     * Represents position column Agent Id in the tabale
     */
    private static final int Num_Col_Agent_Id = 1;

    /**
     * Represents column Agent_Name in the tabale
     */
    private static final String Col_Citizens_Name = "Citizens_Name";
    /**
     * Represents position column Agent_Name in the tabale
     */
    private static final int Num_Col_Citizens_Name = 2;

    /**
     * Represents the current database
     */
    private SQLiteDatabase bdd;
    /**
     * Represents the base sqlite
     */
    private MyBaseSQLite myBaseSQLite;

    /**
     * Represents the context : Activity
     */
    private Context context;

    /**
     * Class Constructor
     *
     * @param context(in), @Activity represents the activity
     */
    public AddCitizens(Context context) {
        myBaseSQLite = new MyBaseSQLite(context, NOM_BDD, VERSION_DB);
        this.context = context;
    }
    /**
     * Allows to open database
     */
    public void open() {
        //on ouvre la BDD en écriture
        bdd = myBaseSQLite.getWritableDatabase();
    }
    /**
     * Allows to close database
     */
    public void close() {
        //on ferme l'accès à la BDD
        bdd.close();
    }
    /**
     * Returns an instance o fdatabase
     *
     * @return(out), @SQLite
     */
    public SQLiteDatabase getBDD() {
        return bdd;
    }

    /**
     * //TODO Add Citizens
     * Allows to register a add agents in the database
     */
    public long insertCitizen(int citizenId,String cityName) {
        ContentValues contentValues = new ContentValues();


        contentValues.put(Col_Citizens_Id, citizenId);
        contentValues.put(Col_Citizens_Name, cityName);

        return bdd.insert(Table_Add_Citizens, null, contentValues);

    }
}
