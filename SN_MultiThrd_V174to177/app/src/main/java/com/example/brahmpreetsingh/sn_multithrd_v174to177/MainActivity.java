package com.example.brahmpreetsingh.sn_multithrd_v174to177;

import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Connection;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener
{
   ListView jlistview;
   EditText jedittext;
   String[] ListOfImages;
   ProgressBar jprogressbar;
   LinearLayout jlinearLoadingSection;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        jlistview=(ListView)findViewById(R.id.xlistview);
        jedittext=(EditText)findViewById(R.id.xedittext);
        jprogressbar=(ProgressBar)findViewById(R.id.xprogressbar);
        jlinearLoadingSection=(LinearLayout)findViewById(R.id.xLinearLoadingSection);
        ListOfImages=getResources().getStringArray(R.array.imageUrls);

        jlistview.setOnItemClickListener(this);

    }


    //This method wil respond when 'download Image' button will be clicked
    public void downloadImage(View v)
    {
        String url = jedittext.getText().toString();                //Here we're retriving text from edittext that got populated when user clicked item on listview
        Thread myThread = new Thread(new SeperateThread(url));      //Here we have got objectified reference of Thread and also have passed object of inner class
                                                                    //'SeperateThread' and thereby have passed object of 'Runnable' indirectly as it contains
                                                                    //implementation of Runnable in its definition. We have also passed retrieved url.
        myThread.start();                                           //Here we've started the thread by applying start() on thread's object.
    }




    //This method is responsible for performing the task of downloading via url. (This method is running in Background(seperate) thread)
    public boolean downloadImageUsingThread(String url)
    {
        /*

        Steps
        * 1. Create the URL class object that will represent the url
        * 2. Open connection using the URL object
        * 3. Read data using InputStream object into a byte array
        * 4. Open a FileOutputStream to save data on sd card
        * 5. Write data to FileOutputStream
        * 6. Close the connection



        // Note : We need to take 'android.permission.INTERNET' in AndroidManifest.xml after making seperate Thread for doing network based task
        // Note : We need to take 'android.permission.WRITE_EXTERNAL_STORAGE' in AndroidManifest.xml to make sure that we could write in external storage.

        */


        URL URLobject;
        HttpURLConnection connection=null;
        InputStream IS_object=null;
        FileOutputStream fos=null;
        boolean successfulStatus=false;
        int read=-1;

        try
        {
            //Running this on MainThread we are getting exception 'NetworkOnMainThreadException' - i.e we're trying to do network things on MainThread
            //which is not recommended.

            //Step 1
            URLobject = new URL(url);
            //Step 2
            connection = (HttpURLConnection) URLobject.openConnection();
            //Step 3
            IS_object = connection.getInputStream();
            byte[] buffer123 = new byte[1024];


            //Step 4
            //We're creating Uri object just to fetch the last text that comes in url link of image so that we could name our file with it.

            Uri uriobject = Uri.parse(url);                         //Here parse() is an inbuilt method in class Uri that parses url string and give Uri object

            //In 'uriobject.getLastPathSegment()', 'getLastPathSegment()' is an inbuilt method in Uri class that gives us last text as required.

            File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).getAbsolutePath()+"/"+uriobject.getLastPathSegment());

            //while((read=IS_object.read())!=-1)            //Slower approach as here we're reading one byte at a time

            fos=new FileOutputStream(file);;

            while((read=IS_object.read(buffer123))!= -1)     //By passing 'buffer123' here we're reading 1024 bytes at a time and here read() will return no. of bytes
            {                                               //that it read at a time from image
            fos.write(buffer123,0,read);                    //Here we're writing into 'fos' as per the count returned of read bytes in variable 'read'
            }
            successfulStatus=true;
        }


        catch (MalformedURLException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }



        finally
        {
        if(connection!=null)
        {
            connection.disconnect();
        }

            if(IS_object!=null)
            {
                try {
                    IS_object.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if(fos!=null)
            {
                try
                {
                    fos.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }

                this.runOnUiThread(new Runnable()                         //Performing task on UI thread when download is completed.
                {
                @Override
                    public void run() {
                        jlinearLoadingSection.setVisibility(View.GONE);
                    }
                });
        }
        return successfulStatus;
    }





    //INNER CLASS for seperate thread setup. By making this we have made a seperate thread and we ll pass object of this class and thereby have passed
    // Runnable object indirectly to Thread's constructor while objectifying a Thread under 'downloadImage()' method.
    public class SeperateThread implements Runnable
    {
        String dynamicUrl;

        //Constructor
        SeperateThread(String url)
        {
            this.dynamicUrl=url;                            //Here I placed the received url, that we got because of objectifying Seperate thread, in a variable.
        }
        @Override
        public void run()
        {
            downloadImageUsingThread(dynamicUrl);            //Here we have called the 'downloadImageUsingThread()' to be run on Seperate Thread.
                                                             //i.e. now the network tasks will be perform on Seperate Thread as we should.
                                                             //Also we've passed the URL to the method responsible for downloading the image.

            // MainActivity.this.jlinearLoadingSection.setVisibility(View.VISIBLE);      //By writing this we're asking LinearLoadingSection to get visible.
                                                                                         //But writing this we are modifying UI in the same thread but we need a
                                                                                         //seperate thread to do this.

            MainActivity.this.runOnUiThread(new Runnable() {                            //By calling runOnUiThread() method we're making the task to perform on
                @Override                                                               //Main thread (UI thread)
                public void run()
                {
                jlinearLoadingSection.setVisibility(View.VISIBLE);
                }
            });
        }
    }





    //This method is handling what to do when an item on ListView is clicked.
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id)
    {
    jedittext.setText(ListOfImages[position]);
    }
}
