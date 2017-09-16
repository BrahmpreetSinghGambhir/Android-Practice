package com.example.brahmpreetsingh.sn_filestorgv157_158;

import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ActivityB extends AppCompatActivity {

    EditText jedittext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_b);
        jedittext=(EditText)findViewById(R.id.xeditText);
    }

    public void loadInternalCache(View v)
    {
        File filepath123 = getCacheDir();                                    //Getting filepath (folder) via getCacheDir() method.
        File file123 = new File(filepath123,"myData1.txt");                  //Reaching File by specifying 'filepath' object and 'filename' as 2 parameters
        String data = readData(file123);                                //Reading from the found file and saving the read data into variable data
                                                                        //by CALLING readData() method and passing objectified file reference to it.
        jedittext.setText(data);                    //Setting retrived 'data' content that we retrieved from readData() to editText's objectified reference
    }

    public void loadExternalCache(View v)
    {
        File filepath123 = getExternalCacheDir();
        File file123 = new File(filepath123,"myData2.txt");
        String data = readData(file123);
        jedittext.setText(data);
    }

    public void loadExternalPrivate(View v)
    {
        File filepath123 = getExternalFilesDir("SlidenerdFolder");
        File file123 = new File(filepath123,"myData3.txt");
        String data = readData(file123);
        jedittext.setText(data);
    }

    public void loadExternalPublic(View v)
    {
        File filepath123 = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        File file123 = new File(filepath123,"myData4.txt");
        String data = readData(file123);
        jedittext.setText(data);
    }

    //This method is responsible plainly for reading data from found file passed to it.
    public String readData(File file)                       //This method is returning string format variable i.e. the read data from file.
    {
        FileInputStream fis=null;                           //FileInputStram is meant to read data from file
        StringBuffer buf123 = new StringBuffer();           //Getting object of StringBuffer so we can append it with while loop
        int read=-1;
        try {                                               //Handling exception
            fis=new FileInputStream(file);
            while((read=fis.read())!=-1)
            {
                buf123.append((char)read);                  //Appending 'buf123' under while loop
            }
        }

        catch (java.io.IOException e)
        {
            e.printStackTrace();
        }

        finally
        {
            if(fis!=null)
            {
                try
                {
                    fis.close();
                }
                    catch (IOException e)
                    {
                        e.printStackTrace();
                    }
            }

        }

        String data = buf123.toString();        //Converting 'buf123' content into string format and saving it in the string format 'data' variable.
        return data;                            //Returning String format data that we read from file which will be set to edittext.
    }

    //Method to go back to MainActivity.
    public void back(View v)
    {
        Intent objintent = new Intent(this,MainActivity.class);
        startActivity(objintent);
    }
}
