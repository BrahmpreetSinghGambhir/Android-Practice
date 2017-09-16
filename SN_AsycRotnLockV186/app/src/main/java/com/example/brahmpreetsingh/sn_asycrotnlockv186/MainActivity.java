package com.example.brahmpreetsingh.sn_asycrotnlockv186;
                                                    /*************************************************/
                                                              //Just Look at ROTATION LOCK code //
                                                    /*************************************************/
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.graphics.drawable.GradientDrawable;
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
        MyAsyncTaskObject.execute(url);
    }






    //This method is handling what to do when an item on ListView is clicked.
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id)
    {
        jedittext.setText(ListOfImages[position]);
    }









    //AsyncTask Sub-class which is an INNER CLASS
    class MyAsyncTask extends AsyncTask<String,Integer,Boolean>
    {
        int contentLength=-1;
        int counter=0;
        int calculatedProgress=0;





        @Override
        protected void onPreExecute()
        {
            jlinearLoadingSection.setVisibility(View.VISIBLE);

/*****************************************************************************************************************************************************************************************/
            //getConfiguration() contains all the information including orientation etc.
            //setRequestedOrientation() will lock the orientation to parameter passed to it.

            //Here we're freezing the orientation.
            if(MainActivity.this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT)
            {
                MainActivity.this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
            }
            else
            {
                MainActivity.this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

            }
        }
/***********************************************************************************************************************************************************************************************/




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
                URLobject = new URL(params[0]);
                connection = (HttpURLConnection) URLobject.openConnection();

                contentLength = connection.getContentLength();

                IS_object = connection.getInputStream();
                byte[] buffer123 = new byte[1024];



                Uri uriobject = Uri.parse(params[0]);
                File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).getAbsolutePath()+
                        "/"+uriobject.getLastPathSegment());

                fos=new FileOutputStream(file);;

                while((read=IS_object.read(buffer123))!= -1)
                {
                    fos.write(buffer123,0,read);
                    counter=counter+read;
                    publishProgress(counter);
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
            calculatedProgress=(int)(((double)values[0]/contentLength)*100);
            jprogressbar.setProgress(calculatedProgress);

        }






        @Override
        protected void onPostExecute(Boolean aBoolean) {
            jlinearLoadingSection.setVisibility(View.GONE);
/********************************************************************************************************************************************************************************************/

            MainActivity.this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR);                  //This command will re-activate the screen sensor
                                                                                                                //responsible for changing orientation of screen

/********************************************************************************************************************************************************************************************/
        }


    }

}
