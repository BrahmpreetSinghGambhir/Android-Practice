package com.example.brahmpreetsingh.sn_dbselectqryv165;
                                                                                    //Video 165 , 166 , 168 //
                                              //In this code, we discussed how to  SELECT ALL and SELECT WITH WHERE from a table & UPDATE & DELETE//

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText jusernameET;
    EditText jpasswordET;
    EditText jwhereET;

    VivzDatabaseAdapter databaseAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        jusernameET=(EditText)findViewById(R.id.xusernameET);
        jpasswordET=(EditText)findViewById(R.id.xpasswordET);
        jwhereET=(EditText)findViewById(R.id.xwhereET);

        databaseAdapter = new VivzDatabaseAdapter(this);
    }

    //Method invoked when 'Add User' button is clicked.
    public void adduser(View v)
    {
        String username=jusernameET.getText().toString();
        String password=jpasswordET.getText().toString();


        long rowid = databaseAdapter.insertData(username,password);
        if(rowid<0)
        {
            Toast.makeText(this,"Insertion Unsucessful",Toast.LENGTH_LONG).show();
        }
        else
        {
            Toast.makeText(this,"Row ssucessfully inserted",Toast.LENGTH_LONG).show();
        }
    }






    //Video 165
    //Method invoked when 'View All Details' button is clicked.
    public void viewAllDetails(View v)
    {
        String receivedData = databaseAdapter.getAllData();         //Calling 'getAllData()' via databaseAdapter and receiving returned String in String variable.
        Toast.makeText(this,receivedData,Toast.LENGTH_LONG).show();      //Displaying data as Toast.
    }





    //Video 166
    //Method invoked when 'View Limited Details as per edit text' button is clicked.
    public void viewLimitedDetails(View v)
    {
        String whereText = jwhereET.getText().toString();                       //Retrieved text input by user in editText field.

        //Breaking input string into substrings
        String sub1=whereText.substring(0,whereText.indexOf(" "));
        String sub2=whereText.substring(whereText.indexOf(" ")+1);              //No need to specify second parameter as it by default will go till end.

        //Passed 2 substrings to getLimitedDetails() in VivzDatabaseAdapter class and receiving returned data into variable.
        String receivedData = databaseAdapter.getLimitedDetails(sub1,sub2);

        //Displaying recieved data
        Toast.makeText(this,receivedData,Toast.LENGTH_LONG).show();
    }





    //Video 168
    //Method invoked when 'Update (programatically)' button is clicked
    public void update(View v)
    {
        int count = databaseAdapter.updateName("Brahmpreet","Jackson");           //Calling updateName() method and receiving & saving returned int value.
                                                                                  //And passing two parameters i.e. 1. oldName 2. newName
        Toast.makeText(this,"No. of rows updated ="+count,Toast.LENGTH_LONG).show();
    }


    //Method invoked when 'Delete (programatically)' button is clicked
    public void delete(View v)
    {
        int count = databaseAdapter.deleteRow("Jackson");                          //Calling deleteRow() method and receiving & saving returned int value.
                                                                                   //And passing one parameters i.e. 'name'
        Toast.makeText(this,"No. of rows deleted = "+count,Toast.LENGTH_LONG).show();
    }

}
