package com.example.sn_interprocess171b;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MainActivity extends AppCompatActivity
{
    TextView jTV1_app2;
    EditText jET_app2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        jET_app2=(EditText)findViewById(R.id.xET1_app2);
        jTV1_app2=(TextView)findViewById(R.id.xTV1_app2);

    }


    //Method to load file (know file's path) from app1
    public void loadFile(View v)
    {
        PackageManager packageManager = getPackageManager();  //getting PackageManager's object as it knows about all the applications installed in project
        try
        {
            //getting ApplicationInfo and location of file of app1
            ApplicationInfo AI_object = packageManager.getApplicationInfo("com.example.brahmpreetsingh.sn_interprocessv171",PackageManager.GET_META_DATA);
            String fullpath = AI_object.dataDir+"/files/vivz.txt";
            readFile(fullpath);                    //Calling readFile() method to read file from passed 'fullpath'
        }
        catch (PackageManager.NameNotFoundException e)
        {
            e.printStackTrace();
        }
    }



    //Method to read from file in app1
    public void readFile(String path)
    {
        File file=new File(path);
        int read=-1;
        try
        {
            FileInputStream fis=new FileInputStream(file);
            StringBuffer buff = new StringBuffer();
            while((read = fis.read())!=-1)
            {
                buff.append((char)read);
            }
            String retrievedTextFromFile = buff.toString();
            jTV1_app2.setText(retrievedTextFromFile);
        }
        catch (FileNotFoundException e)
        {
            jTV1_app2.setText(""+e);
        }
        catch (IOException e)
        {
            jTV1_app2.setText(""+e);
        }

    }
}
