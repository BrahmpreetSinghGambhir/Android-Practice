package com.example.brahmpreetsingh.sn_interprocessv171a;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    EditText jET1_app1;
    TextView jTV1_app1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        jET1_app1=(EditText)findViewById(R.id.xET1_app1);
        jTV1_app1=(TextView)findViewById(R.id.xTV1_app1);
    }


    //Method to write into file in app1 using simple methodology.
    public void saveToFile(View v)
    {
        String edittext = jET1_app1.getText().toString();
        File file = null;
        FileOutputStream fos=null;
        try
        {
            file = getFilesDir();
            fos=openFileOutput("vivz.txt",MODE_PRIVATE);
            fos.write(edittext.getBytes());
            jTV1_app1.setText(edittext+" written to "+file.getAbsolutePath());
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }
}
