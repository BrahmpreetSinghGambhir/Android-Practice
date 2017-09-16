package com.example.brahmpreetsingh.sn_dbselectqryv165;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by brahmpreet.singh on 12/29/2016.
 */
public class VivzDatabaseAdapter
{
    VivzHelper helperObject;



    //Constructor
    public VivzDatabaseAdapter(Context context)
    {
        helperObject = new VivzHelper(context);
    }




    public long insertData(String name,String password)
    {
    SQLiteDatabase db = helperObject.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(helperObject.NAME,name);
        contentValues.put(helperObject.PASSWORD,password);
        long rowid = db.insert(helperObject.TABLE_NAME,null,contentValues);
        return rowid;
    }





    //Video 165
    //This method is to handle the data that came out as result-set after executing 'query()' ie Select statement.
    public String getAllData()
    {
        SQLiteDatabase db = helperObject.getWritableDatabase();
        String[] columns = {helperObject.UID,helperObject.NAME,helperObject.PASSWORD};          //The column data we want to see
        Cursor cur = db.query(helperObject.TABLE_NAME,columns,null,null,null,null,null);        //'query()' method returns Cursor
        StringBuffer buff = new StringBuffer();                                        //As we need whole data while traversing through cursor, so String buffer

        //Using cursor object to traverse through result-set and saving data to StringBuffer object.
        while(cur.moveToNext())
        {
            //Retrieving data out of cursor into variables. Instead of inputing column index directly we can retrive column index and saving it in a variable
            //by typing like -----> int index1=cur.getColumnIndex(helperObject.UID); and then passing this 'index1' as parameter to getint() or getString().
            int cid = cur.getInt(0);
            String Name = cur.getString(1);
            String Password = cur.getString(2);

            //Appending data into StringBuffer object everytime loop loops.
            buff.append(cid+" "+Name+" "+Password);
        }

        return buff.toString();
    }




    //Video 166
    //This method is to provide limited data that came out as result-set after executing 'query()' ie Select statement.
    public String getLimitedDetails(String name, String Password)
    {
        SQLiteDatabase db = helperObject.getWritableDatabase();
        String[] columns = {helperObject.UID};                              //The column data we want to see
        String[] selectionargs = {name,Password};                           //This variable will fill '?' left in 3rd parameter in query() below.

        Cursor cur = db.query(helperObject.TABLE_NAME, columns, helperObject.NAME+" =? AND "+helperObject.PASSWORD+" =?", selectionargs,null,null,null);

        StringBuffer buff = new StringBuffer();                                        //As we need whole data while traversing through cursor, so String buffer
        while(cur.moveToNext())
        {
            //Retrieving data out of cursor into variable.
            int index0 = cur.getColumnIndex(helperObject.UID);
            int cid = cur.getInt(index0);

            //Appending data into StringBuffer object everytime loop loops.
            buff.append("|"+cid+"|"+" ");
        }

        return buff.toString();
    }



                                                        //'new String[]{name}' is equivalent to 'String[] name = {"Brahmpreet"};'



    //Video 168
    public int updateName(String oldName, String newName)
    {
        SQLiteDatabase db = helperObject.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(helperObject.NAME,newName);                                                    //Putting newName into 'ContenValues' to respective column.

        int count = db.update(helperObject.TABLE_NAME,cv,helperObject.NAME+"=?",new String[]{oldName});    //4 parameters

        return count;
    }

    public int deleteRow(String name)
    {
        SQLiteDatabase db = helperObject.getWritableDatabase();

        int count = db.delete(helperObject.TABLE_NAME,helperObject.NAME+"=?",new String[]{name});           //3 parameters

        return count;
    }




    //Inner class
    public class VivzHelper extends SQLiteOpenHelper
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


        public VivzHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
            this.c=context;
            Toast.makeText(context,"Constructor called",Toast.LENGTH_LONG).show();
        }

        @Override
        public void onCreate(SQLiteDatabase db)
        {
        db.execSQL(Create_Table);
        Toast.makeText(c,"onCreate() called",Toast.LENGTH_LONG).show();
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
        {
        db.execSQL(Drop_Table);
        onCreate(db);
        Toast.makeText(c,"onUpgrade() called",Toast.LENGTH_LONG).show();
        }
    }
}
