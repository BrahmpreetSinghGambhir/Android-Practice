package com.example.brahmpreetsingh.sn_sharedprefrv150;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    EditText jeditTextNameA;
    EditText jeditTextPasswordA;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        jeditTextNameA=(EditText)findViewById(R.id.xeditTextNameA);
        jeditTextPasswordA=(EditText)findViewById(R.id.xeditTextPasswordA);
    }

    //This method we've created to save key pair values into SharedPreferences file.
    public void save(View v)
    {
        SharedPreferences SP_object = getSharedPreferences("MyDataFile",MODE_PRIVATE);   //Here we have got object reference to SharedPreferences
                                                                                         //Parameter 1 -> File name that we want, Parameter 2 -> Accesibility mode
        SharedPreferences.Editor Editor_Object = SP_object.edit();                       //Via 'SP_object' we called 'edit()'method thereby got acess to Editor
                                                                                         //which is responsible for commiting all the edits. (Now via this object,
                                                                                         //we will be able to edit our file.

        Editor_Object.putString("KeyName",jeditTextNameA.getText().toString());                 //Putting key-value pair to Editor_object
        Editor_Object.putString("KeyPassword",jeditTextPasswordA.getText().toString());         //Putting key-value pair to Editor_object

        Editor_Object.commit();                                                                 //Commiting changes made to 'Editor_object'

        Toast.makeText(this,"Input saved to shared preference file",Toast.LENGTH_LONG).show();
    }

    //This method is to take us to ActivityB
    public void goToB(View v)
    {
        Intent objintent = new Intent(this,ActivityB.class);
        startActivity(objintent);
        Toast.makeText(this,"GoToB button clicked",Toast.LENGTH_LONG).show();
    }
}
