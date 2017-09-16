package com.example.brahmpreetsingh.sn_filestorgv157_158;

import android.content.Intent;
import android.os.Environment;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    EditText jedittext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        jedittext=(EditText)findViewById(R.id.xeditText);

    }

    public void saveInternalCache(View v)
    {
        File filepath123 = getCacheDir();                                           //Getting filepath (folder) via getCacheDir() method.
        File file123 = new File(filepath123,"myData1.txt");                         //Making File by specifying 'filepath' object and 'filename' as 2 parameters
        String data = jedittext.getText().toString();   //Saving text into 'data' variable from the java reference of edittext so that this can be passed to writeData()
        writeData(file123,data);                                            //Calling writeData() by passing 2 parameters. 1. filename we created, 2. editText input

        Toast.makeText(this,"Internal cache (save) was clciked",Toast.LENGTH_LONG).show();
    }

    public void saveExternalCache(View v)
    {
        File filepath123 = getExternalCacheDir();
        File file123 = new File(filepath123,"myData2.txt");
        String data = jedittext.getText().toString();
        writeData(file123,data);

        Toast.makeText(this,"External cache (save) was clciked",Toast.LENGTH_LONG).show();
    }

    public void saveExternalPrivate(View v)
    {
        File filepath123 = getExternalFilesDir("SlidenerdFolder");
        File file123 = new File(filepath123,"myData3.txt");
        String data = jedittext.getText().toString();
        writeData(file123,data);

        Toast.makeText(this,"External Private (save) was clciked",Toast.LENGTH_LONG).show();
    }

    public void saveExternalPublic(View v)                                 //This is not working as i dont have Downloads folder in external location I believe.
    {
        File filepath123 = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS);
        File file123 = new File(filepath123,"myData4.txt");
        String data = jedittext.getText().toString();
        writeData(file123,data);

        Toast.makeText(this,"External Public (save) was clciked",Toast.LENGTH_LONG).show();
    }


    //This method is common among the 4 operations & is responsible for writing into respective textfiles we have created.
    public void writeData(File file,String data)            //Method taking 2 parameters as input. 1. TextFile we created 2. Text we input into EditText
    {
        FileOutputStream fos = null;
        try
        {
            fos=new FileOutputStream(file);           //Here we got objectified FileOutputStram, with reference to passed filename received in writeData method
            fos.write(data.getBytes());               //Here we're writing byte format of data we received in writeData() into 'fos' object
            message(data+" was written sucessfuly to "+file.getAbsolutePath());

        }
        catch (FileNotFoundException e)             //Handling exceptions
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                if(fos!=null)
                {
                    fos.close();                    //Closing resources.
                }
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }

    //Method to display normal toast message and this method can be called simply anywhere passing string as parameter.
    public void message(String message)                         //Recieving string as parameter (input)
    {
    Toast.makeText(this,message,Toast.LENGTH_LONG).show();
    }

    //To go to ActivityB
    public void next(View v)
    {
        Intent objintent = new Intent(this,ActivityB.class);
        startActivity(objintent);
    }
}
