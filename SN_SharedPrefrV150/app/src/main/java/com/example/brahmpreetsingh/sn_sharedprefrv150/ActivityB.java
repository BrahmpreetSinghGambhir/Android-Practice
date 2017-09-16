package com.example.brahmpreetsingh.sn_sharedprefrv150;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ActivityB extends AppCompatActivity {

    EditText jeditTextNameB;
    EditText jeditTextPasswordB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_b);
        jeditTextNameB = (EditText)findViewById(R.id.xeditTextNameB);
        jeditTextPasswordB = (EditText)findViewById(R.id.xeditTextPasswordB);


    }
    public void retrieve(View v)
    {
        SharedPreferences SP_object2 = getSharedPreferences("MyDataFile",MODE_PRIVATE);             //Here we again got object reference to our file by
                                                                                                    // passing matching parameters

        String nameVariable = SP_object2.getString("KeyName","N/A");                           //Here we're simply retrieving text with Key "KeyName" from the
                                                                                               // matched object of SharedPreference into a variable 'nameVariable'.
                                                                                               //Parameter 1 -> Key of whose value is to be retrieved
                                                                                               //Parameter 2 -> If not found this will be default value returned.
        String passwordVariable = SP_object2.getString("KeyPassword","N/A");




        if(nameVariable=="N/A" || passwordVariable=="N/A")                                      //Handling case where input is purely empty
        {
            Toast.makeText(this,"The data file is empty",Toast.LENGTH_LONG).show();
        }
        else                                                                                    //Task to be performed when there is a proper input in MainActivity
        {
            jeditTextNameB.setText(nameVariable);                                       //Setting text to 'jeditTextNameB' java reverence of EditText in ActivityB
            jeditTextPasswordB.setText(passwordVariable);                               //Setting text to 'jeditTextPasswordB' java reverence of EditText in ActivityB

            Toast.makeText(this, "Information retrieved", Toast.LENGTH_LONG).show();
        }
    }

    //This method is to take us to MainActivity
    public void goToA(View v)
    {
        Intent objintent2 = new Intent(this,MainActivity.class);
        startActivity(objintent2);
        Toast.makeText(this,"GoToA button was clicked",Toast.LENGTH_LONG).show();
    }
}
