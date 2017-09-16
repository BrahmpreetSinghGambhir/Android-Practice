package com.example.brahmpreetsingh.sn_rotnway2_v187_189;

import android.app.Activity;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Environment;
import android.util.Log;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by brahmpreet.singh on 1/3/2017.
 */
class MyAsyncTask extends AsyncTask<String,Integer,Boolean>
{
    int contentLength=-1;
    int counter=0;
    int calculatedProgress=0;

    Activity activityT;

    //CONSTRUCTOR which will be called by Fragment when it will instantiate this class 'MyAsyncTask' and thus thereby activity will be updated here in Async task
    // as per active activity in Fragment. (2nd way that active Activity will come into AsyncTask)
    public MyAsyncTask(Activity activity)
    {

    onAttach(activity);    //We have called onAttach() method (The one present in MyAsyncTask class itself) here in Constructor of MyAsyncTask class so that if
                           // user tries to objectify MyAsyncTask in Fragment, he'll be able to pass an activity as a parameter which will be forwarded to onAttach()
                           //where we will retrive the latest activity into a variable.
    }





    //2 Corresponding methods to Lifecycle methods present in Fragment
    public void onAttach(Activity activity)
    {
    this.activityT=activity;               //Here we have saved the received instance of new Activity (Active activity) from Fragment.
    }


    public void onDetach()             //Reason that we've placed this method here is that to tell MyAsyncTask that this activity is dead. Make it null.
    {                                                   //and new Activity will be coming soon to your onAttach()
    activityT=null;
    }







    //Here we are making ProgressBar visible before downloading. (We cant have direct access to components of MainActivity. So we made corresponding methods
    //                                                           in MainActivity to whom we can refer via 'Activity' object available to us via Typecasting it
    @Override
    protected void onPreExecute()
    {
        if(activityT!=null) {                                                  //Optional just to make sure this doesnt execute in timegap
            ((MainActivity) activityT).showProgressBarBeforeDownloading();     //In the Async Task itself we got the activity and we did save it in activityT,
        }                                              //so to access any component from MainActivity we first need to TYPE-CAST it
                                                                          //and then call the required method from MainActivity.
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





    //This method will be called when publishProgress() will be called in doInbackground() will be called & is intended to update ProgressBar with calculatedProgress.
    //But we're not going to do this here. Insetad we'll make MainActivity do this task by making corresponding method over there. (As we dont have access to
    // ProgressBar here)
    @Override
    protected void onProgressUpdate(Integer... values)
    {


        //As we know that onProgressUpdate is being called simutaneously so there can be a chance there is a small time gap betwween onDetach() and onAttach()
        //To handle that we're writing if condition here.
        if(activityT==null)
        {
            Log.d("Brahm","Skipping Progress updation....");
        }
        else
        {
            calculatedProgress=(int)(((double)values[0]/contentLength)*100);
            ((MainActivity)activityT).progressUpdate(calculatedProgress);       //Calling corresponding method present in MainActivity that has access to ProgressBar
        }

    }





    //This method is intended to hide ProgressBar after downloading
    @Override
    protected void onPostExecute(Boolean aBoolean) {
        if (activityT != null)                                  //Optional just to make sure this doesnt execute in timegap that comes between lifecycle methods.
        {
            ((MainActivity) activityT).hideProgressBarAfterDownloading();
        }
    }


}