
package com.example.brahmpreetsingh.sn_intrnstorgv152_153;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ActivityB extends AppCompatActivity
{

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
        /*
           What you see?
           Brahmpreet Pass
           What actually is in file?
           124 234 345 456 321 432 345 345 237 678 000 898 787 454 232           //ASCII codes
        */
        int read = -1;
        StringBuffer stringbuffer123 = new StringBuffer();                                //We have taken object of StringBuffer so that we can keep on appending
                                                                                          // this object 'buffer123' in while loop.
        try
        {
            FileInputStream fis = openFileInput("MyDataFile.txt");                 //Here we got the referece to FileInputStream using openFileInput() that returns
                                                                                   //'fileInputStream' type object.

            while((read = fis.read())!=-1)                                         //'fis.read()' method gives one byte eg '000' at a time. It will return '-1' if
            {                                                                      //file is empty. We have got while loop here to retrieve complete byte values
                                                                                   //While loop till '-1' means that we want loop to go till EOF
                stringbuffer123.append((char)read);                //Here we are putting byte values one by one into StringBuffer object. ('read' is int type)
                                                                   //We used String buffer instead of String as only StringBuffer lets us append its values
            }
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }


        String text1 = stringbuffer123.substring(0,stringbuffer123.indexOf(" "));                           //'substring()' method will let us extract partial text-
        String text2 = stringbuffer123.substring(stringbuffer123.indexOf(" ")+1,stringbuffer123.length());  // - Parameter 1 : start, Parameter 2: End

        jeditTextNameB.setText(text1);                                                                      //Setting texts to respective EditText java references.
        jeditTextPasswordB.setText(text2);


        Toast.makeText(this, "Information retrieved", Toast.LENGTH_LONG).show();
    }





    //This method is to take us to MainActivity
    public void goToA(View v)
    {
        Intent objintent2 = new Intent(this,MainActivity.class);
        startActivity(objintent2);
        Toast.makeText(this,"GoToA button was clicked",Toast.LENGTH_LONG).show();
    }
}
