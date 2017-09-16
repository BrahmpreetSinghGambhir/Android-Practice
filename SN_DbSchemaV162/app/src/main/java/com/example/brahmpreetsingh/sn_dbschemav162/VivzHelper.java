package com.example.brahmpreetsingh.sn_dbschemav162;


/****************************************************THIS IS FOR VIDEO 161. BY MISTAKE I RENAMED IT 162*******************************************************/


import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by brahmpreet.singh on 12/24/2016.
 */
public class VivzHelper extends SQLiteOpenHelper
{
    private static final String DATABASE_NAME = "VIVZDATABASE";
    private static final String TABLE_NAME = "VIVZTABLE";
    private static final String UID = "_id";
    private static final String NAME = "NAME";
    private static final int DATABASE_VERSION = 1;
    Context c;

    VivzHelper(Context context)                                                 //Constructor which is must to define. We're recieving context here that
    {                                                                           // we passed in MainActivity while objectifying 'VivzHelper' class.
        super(context,DATABASE_NAME,null,DATABASE_VERSION);      //To constructor we've passed 4 parameters as we can see (3rd parameter is for cursor,if any)
        this.c = context;
        Toast.makeText(context,"Constructor called",Toast.LENGTH_LONG).show();
    }


    //In this method we're creating the table (Structurally) and this method takes our SQLiteDatabase object as parameter that we've created in MainActivity.
    @Override
        public void onCreate(SQLiteDatabase db)
    {
        //db.execSQL("CREATE TABLE VIVZTABLE (_ID INTEGER PRIMARY KEY AUTOINCREMENT , NAME VARCHAR(255);");
        try{
            //executing query on received SQLitedatabase object 'db'
            db.execSQL("CREATE TABLE "+TABLE_NAME+" ("+UID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+NAME+" VARCHAR(255);");
            Toast.makeText(c,"Table with name"+NAME+" was created",Toast.LENGTH_LONG).show();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //In this method we'll be upgrading the table and this method will be called when we need to upgrade the table by changing 'DATABASE_VERSION'
    //This method takes 3 parameters - 1. Our SQLiteDatabase object 2. Database version old 3. Database version new
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        try {
            Toast.makeText(c,"onUpgrade called",Toast.LENGTH_LONG).show();
            //executing query on received SQLitedatabase object 'db'
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
            onCreate(db);

        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

    }
}
