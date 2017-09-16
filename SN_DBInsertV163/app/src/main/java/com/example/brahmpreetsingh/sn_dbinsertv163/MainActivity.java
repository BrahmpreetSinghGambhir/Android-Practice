package com.example.brahmpreetsingh.sn_dbinsertv163;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    VivzDatabaseAdapter vivzDatabaseAdapterobject;
    EditText jusernameET;
    EditText jpasswordET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vivzDatabaseAdapterobject=new VivzDatabaseAdapter(this);                //Objectifying 'VivzDatabaseAdapter' and thereby passing context to its constructor
                                                                                //in VivzDatabaseAdapter where we ll be objectifying inner class 'VivzHelper'
                                                                                //as its possible to do it there only and not in MainActivity.

        jusernameET = (EditText)findViewById(R.id.xusernameET);
        jpasswordET = (EditText)findViewById(R.id.xpasswordET);

    }

    //This method will be called when 'Add user' button will be clicked.
    public void adduser(View view)
    {
        //Fetching input by user after user clicks 'Add User' button as only then values will be there in respective EditTexts
        String username = jusernameET.getText().toString();
        String password = jpasswordET.getText().toString();

        long rowid = vivzDatabaseAdapterobject.insertData(username,password);               //Here we have called insertData() via object of 'VivzDatabaseAdapter'
        if(rowid<0)
        {
            Toast.makeText(this,"Adding data to table unsucessful",Toast.LENGTH_LONG).show();
        }
        else
        {
            Toast.makeText(this,"Data to Table inserted sucessfully",Toast.LENGTH_LONG).show();
        }
    }
}
