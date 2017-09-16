package com.example.brahmpreetsingh.sn_dbinsertv163;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by brahmpreet.singh on 12/28/2016.
 */


//OUTER CLASS -- (Outer class can have access to private variables of Inner class that we couldnt do from MainActivity i.e. couldnt have access to private variables)
public class VivzDatabaseAdapter
{
    VivzHelper helperobject;


    //Constructor defined so as to do instantiate VivzHelper class here itself instead of doing it in MainActivity as 'VivzHelper' is an inner class to
    // 'VivzDatabaseAdapter' and cant be instantiated in MainActivity. I mean it can be done with setters getters but we want to keep private things that are private.
    public VivzDatabaseAdapter(Context context)
    {
        helperobject=new VivzHelper(context);                           //VivzHelper class instantiated by receiving context from the MainActivity while we were
                                                                        //instantiating 'VivzDataBaseAdapter'
    }





    //This method is to insert data into table recieving two Strings from MainActivity. VivzHelper class cant be instantiated in this method as it ll need a context.
    //So we instantiated VivzHelper class in the constructor above.
    public long insertData(String name,String password)
    {
        SQLiteDatabase db = helperobject.getWritableDatabase();                 //SQLiteDatabase object retrieved via object of VivzHelper

        ContentValues contentvalues123 = new ContentValues();                   //ContentValues class instantiated
        contentvalues123.put(helperobject.NAME,name);                           //Now we are able to access the private variables(columns) of VivzHelper class &
        contentvalues123.put(helperobject.PASSWORD,password);                   //here we're putting key-values pairs i.e. column-values, respectively.

        long rowid = db.insert(helperobject.TABLE_NAME,null,contentvalues123);  //Putting contentvalues into table.

        return rowid;
    }





    //We have made 'VivzHelper' the inner class to 'VivzDatabaseAdapter' so that the private variables inside the inner class 'VivzHelper' get accessible to
    //outer class 'VivzdatabaseAdapter'

    /****************************************************INNER CLASS (VivzHelper) to VivzDatabaseAdapter*******************************************************/

//We've made this class 'static' as we dont want this class to have access to non-static variables of outer class. But it can access static ones of outer class.
    static public class VivzHelper extends SQLiteOpenHelper
    {
        private static final String DATABASE_NAME = "VIVZDATABASE";
        private static final String TABLE_NAME = "VIVZTABLE";
        private static final String UID = "_ID";
        private static final String NAME = "NAME";
        private static final String PASSWORD = "PASSWORD";
        private static final int DATABASE_VERSION = 1;
        Context c;
        private static final String Create_Table = "CREATE TABLE "+TABLE_NAME+" ("+UID+" INTEGER PRIMARY KEY AUTOINCREMENT, "
                                                    +NAME+" VARCHAR(255), "
                                                    +PASSWORD+" VARCHAR(255))";
        private static final String Drop_Table = "DROP TABLE IF EXISTS "+TABLE_NAME+"";

        //Constructor must to get the Database.
        public VivzHelper(Context context)
        {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
            this.c=context;
            Toast.makeText(context,"Constructor called",Toast.LENGTH_LONG).show();
        }



        @Override
        public void onCreate(SQLiteDatabase db)
        {
        try
        {
            db.execSQL(Create_Table);
            Toast.makeText(c,"onCreate called",Toast.LENGTH_LONG).show();
        }
            catch(SQLException e)
            {
                e.printStackTrace();
            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            try
            {
                db.execSQL(Drop_Table);
                onCreate(db);
                Toast.makeText(c,"onUpgrade called",Toast.LENGTH_LONG).show();
            }
            catch(SQLException e)
            {
                e.printStackTrace();
            }
        }
    }
    /*******************************************************************************************************************************************************************/
}
