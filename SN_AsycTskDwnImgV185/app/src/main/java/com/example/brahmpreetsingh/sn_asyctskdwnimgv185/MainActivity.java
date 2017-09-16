package com.example.brahmpreetsingh.sn_asyctskdwnimgv185;

                                                                //Download Image (AsyncTask approach) //

import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.support.annotation.BoolRes;
import android.support.v7.app.AppCompatActivity;
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
import java.net.URL;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ListView jlistview;
    EditText jedittext;
    String[] ListOfImages;
    ProgressBar jprogressbar;
    LinearLayout jlinearLoadingSection;
    Handler handler123;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        jlistview = (ListView) findViewById(R.id.xlistview);
        jedittext = (EditText) findViewById(R.id.xedittext);
        jprogressbar = (ProgressBar) findViewById(R.id.xprogressbar);
        jlinearLoadingSection = (LinearLayout) findViewById(R.id.xLinearLoadingSection);
        ListOfImages = getResources().getStringArray(R.array.imageUrls);
        handler123 = new Handler();

        jlistview.setOnItemClickListener(this);

    }


    //This method wil respond when 'download Image' button will be clicked
    public void downloadImage(View v) {
        String url = jedittext.getText().toString();

        MyAsyncTask MyAsyncTaskObject = new MyAsyncTask();
        MyAsyncTaskObject.execute(url);                         //This command will make AsyncTask class's method onPreExecute() to run and
                                                                //also will pass String 'url' to doInBackground()
    }






    //This method is handling what to do when an item on ListView is clicked.
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id)
    {
        jedittext.setText(ListOfImages[position]);
    }









    //AsyncTask Sub-class which is an INNER CLASS
    class MyAsyncTask extends AsyncTask<String,Integer,Boolean>  //Parameter 1 --> String, as doInBackground is receiving String parameter
    {                                                            //Parameter 2 --> Integer, as onUpdateProgress() is receiving Integer value from doInBackground()
                                                                 //Parameter 3 --> Boolean, as 'onPostExecute()' is receiving Boolean from 'doInBackground()'
                                                                    // These parameters in a way signifies receiver's type in respective methods.
        int contentLength=-1;
        int counter=0;
        int calculatedProgress=0;





        @Override
        protected void onPreExecute() {
            jlinearLoadingSection.setVisibility(View.VISIBLE);
        }





        @Override
        protected Boolean doInBackground(String... params) {

            URL URLobject;
            HttpURLConnection connection=null;
            InputStream IS_object=null;
            FileOutputStream fos=null;
            boolean successfulStatus=false;
            int read=-1;


            try
            {
                URLobject = new URL(params[0]);                             //Here we passed 'params[0]' as this is the variable in which we're recieving url
                connection = (HttpURLConnection) URLobject.openConnection();

                contentLength = connection.getContentLength();              //This will tell us the total size of url to be downloaded

                IS_object = connection.getInputStream();
                byte[] buffer123 = new byte[1024];



                Uri uriobject = Uri.parse(params[0]);                       //Here we passed 'params[0]' as this is the variable in which we're recieving url
                File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).getAbsolutePath()+
                                     "/"+uriobject.getLastPathSegment());

                fos=new FileOutputStream(file);;

                while((read=IS_object.read(buffer123))!= -1)
                {
                    fos.write(buffer123,0,read);
                    counter=counter+read;                                           //Here we are saving the number of bytes read in a variable
                    publishProgress(counter);                                       //Side by side we're calling onProgressUpdate() indirectly.
                                                                                    // Morover we are passing an int value & thereby calling onProgressUpdate()
                                                                                    //  so we need to change parameter type of onProgressUpdate() that its receiving
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


            }
            return successfulStatus;
        }





        //This method will be called when publishProgress() will be called in doInbackground() will be called.
        @Override
        protected void onProgressUpdate(Integer... values)
        {
            calculatedProgress=(int)(((double)values[0]/contentLength)*100);            //We're doing basic calculation as per which simultaneous update will
                                                                                        //be done to Progressbar
            jprogressbar.setProgress(calculatedProgress);                               //Setting progress to java reference of ProgressBar

        }






        @Override
        protected void onPostExecute(Boolean aBoolean) {
            jlinearLoadingSection.setVisibility(View.GONE);
        }


    }

}

