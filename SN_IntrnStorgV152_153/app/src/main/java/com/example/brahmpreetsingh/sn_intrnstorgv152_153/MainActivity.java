package com.example.brahmpreetsingh.sn_intrnstorgv152_153;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity
{
    EditText jeditTextNameA;
    EditText jeditTextPasswordA;

    String NameVariable;
    String PasswordVariable;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        jeditTextNameA=(EditText)findViewById(R.id.xeditTextNameA);
        jeditTextPasswordA=(EditText)findViewById(R.id.xeditTextPasswordA);

    }

    //This method we've created to save dat into input storage (String to Binary form).
    public void save(View v)
    {
        NameVariable = jeditTextNameA.getText().toString();                 //After user has input the data, we re reteriving data into variable 'NameVariable'
        PasswordVariable = jeditTextPasswordA.getText().toString();         //After user has input the data, we re reteriving data into variable 'PasswordVariable'
        NameVariable = NameVariable+" ";                                               // To seperate name and password inputs
        FileOutputStream fos = null;                                        //Getting a reference to 'FileOutputStream' that will let us write on file.
        File filepath = getFilesDir();                                      //This will help us know path of the file (MyDataFile.txt) where it is saved.

        try
        {
            fos = openFileOutput("MyDataFile.txt",MODE_PRIVATE);           //'openFileOutput()' let us write data into file specified and mode specified
                                                                           //'openFileOutput()' returns object of 'FileOutputStream' type.
            fos.write(NameVariable.getBytes());                            //Here we're writing into file via object of FileOutputStream i.e. 'fos'
            fos.write(PasswordVariable.getBytes());
        }
                catch (FileNotFoundException e)                            //Handling exception if file  not found
                {
                    e.printStackTrace();
                }
                catch (IOException e)                                       //Handling exception in case when for some reason IO operation was not possible.
                {
                    e.printStackTrace();
                }


        finally                                                             //This code shall execute no matter what happens in above code.
        {
            try
            {
                fos.close();                                                //Here we have closed the stream (resources).
            }
                    catch (IOException e)                                   //Handling exception if caused during closing Resources.
                    {
                        e.printStackTrace();
                    }
        }

        Toast.makeText(this,"Input saved to internal storage at "+filepath,Toast.LENGTH_LONG).show();
    }

    //This method is to take us to ActivityB
    public void goToB(View v)
    {
        Intent objintent = new Intent(this,ActivityB.class);
        startActivity(objintent);
        Toast.makeText(this,"GoToB button clicked",Toast.LENGTH_LONG).show();
    }
}
