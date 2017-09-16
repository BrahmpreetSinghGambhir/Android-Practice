package com.example.brahmpreetsingh.sn_intnttakepicv109;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    private File imagefile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }

    public void process(View v)
    {
        //Step 1 : Intent defined along with Action
        Intent objintent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);                      //Action specified to Imtent object.

        //Step 2 : Object of File created specifying 'Location' & 'File name'
        imagefile = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES),"gursimran.jpg"); //Parameter 1 : Where to save
                                                                                                                             //Paameter 2 : ImageName to be saved


        /* Now that our image file is ready we need to make a 'uri' out of it using 'fromFile()' method i.e 'uri.fromFile()' which takes the object of file
           i.e 'imagefile' and will return the uri format. We will save this uri in the object of Uri ie 'uritemp123'  */



        //Step 3 : Create a Uri object out of 'imagefile'
        Uri uritemp123 = Uri.fromFile(imagefile);


        //Step 4 : Setting properties to objintent (Teliing intent to do this)
        objintent.putExtra(MediaStore.EXTRA_OUTPUT,uritemp123);                     //'EXTRA_OUTPUT' here tells where ImageFile is to be stored .
                                                                                    //ie in the second parameter we need to pass the value (Uri defined).

        objintent.putExtra(MediaStore.EXTRA_VIDEO_QUALITY,1);                       //'EXTRA_VIDEO_QUALITY' here tells what quality we want
                                                                                    //i.e. in the second parameter we need to tell the quality value (0 or 1)


        //Step 5 : StartActivity using 'startActivityForResult(P1,P2)' where P1 -> object of intent & P2 -> RequestCode that tells who sent request
        startActivityForResult(objintent,0);
    }



        //Stem 6 : Override 'onActivityResult()' method. As on starting activity ie calling 'startingActivityForResult()' method this will
        // return the captured imagefile.

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==0)                                           //Here we're confirming if the object we're getting in return was sent by our activity
        {
            switch (resultCode)                                     //I believe 'resultCode' tells if User used and clicked with camera or not
            {


                case Activity.RESULT_OK:                            // If its 'RESULT_OK' in the 'resultCode'
                {
                    if (imagefile.exists())                         //This is checking if the imagefile is stored at the location defined or not.
                    {
                        Toast.makeText(this, "Imagefile saved at : " + imagefile.getAbsolutePath(), Toast.LENGTH_LONG).show();
                    }
                    else
                    {
                        Toast.makeText(this,"User cancelled at the last moment",Toast.LENGTH_LONG).show();
                    }
                    break;
                }


                case Activity.RESULT_CANCELED:                      //If its 'RESULT_CANCELED' in 'resultCode'
                {
                    break;
                }
            }
        }
    }
}
