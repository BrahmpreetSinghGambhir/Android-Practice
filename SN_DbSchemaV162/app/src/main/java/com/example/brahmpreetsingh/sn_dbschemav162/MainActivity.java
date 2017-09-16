package com.example.brahmpreetsingh.sn_dbschemav162;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        VivzHelper vivzHelperObject = new VivzHelper(this);                           //Class VivzHelper objectified & context passed as 'this' to constructor
        SQLiteDatabase sqLiteDatabaseObject = vivzHelperObject.getWritableDatabase(); //Applying 'getWritableDatabase()' method on 'vivzHelperObject' we got
                                                                                      //the objectified reference of ur database which we will be passing to two
                                                                                      //methods onCreate() and onUpgrade() in the VivzHelper class where actions
                                                                                      //will be performed to them.
    }
}
