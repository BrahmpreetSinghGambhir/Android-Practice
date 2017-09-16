package com.example.brahmpreetsingh.sn_rotnway2_v187_189;
                                                                //Destructible//
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;


public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ListView jlistview;
    EditText jedittext;
    String[] ListOfImages;
    ProgressBar jprogressbar;
    LinearLayout jlinearLoadingSection;
    Handler handler123;
    NonUITaskFragment fragment123;


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




        if(savedInstanceState==null)                    //savedInstanceState is null only when Activity is running for the first time (fragment isnt added)
        {
        fragment123=new NonUITaskFragment();                                                        //Fragment insttantiated.
        getSupportFragmentManager().beginTransaction().add(fragment123,"FragmentTag").commit();     //Fragment added to Activity
        }
        else                                            //savedInstanceState not null means that activity was already created and we rotated the screen
        {
        fragment123 = (NonUITaskFragment) getSupportFragmentManager().findFragmentByTag("FragmentTag");   //Just found the alreeady existing Fragment
        }



        //This code is just to keep or make ProgressBar visible while Asynctask is running
        if(fragment123!=null)
        {
            if(fragment123.MyAsyncTaskObject!=null && fragment123.MyAsyncTaskObject.getStatus()== AsyncTask.Status.RUNNING)
            {
                jprogressbar.setVisibility(View.VISIBLE);
            }
        }
    }




    //This method wil respond when 'download Image' button will be clicked and now is not responsible for starting the MyAsynctask
    public void downloadImage(View v) {
        String url = jedittext.getText().toString();
        fragment123.beginTask(url);
    }






    //This method is handling what to do when an item on ListView is clicked.
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id)
    {
        jedittext.setText(ListOfImages[position]);
    }


/*******************************************************************************************************************************************************************************/
    //We have created these two methods here in MainActivity as we cant have direct acccess to ProgressBar from MyAsyncTask and we will be calling these
    // methods from respective methods of Asynctask to perform these respective operations. So we're not performing these tasks in AsyncTask itself but
    // instead we have latest reference to activity and we're calling certain methods on that refernce within MainActivity

    public void showProgressBarBeforeDownloading()
    {
    if(fragment123.MyAsyncTaskObject!=null)                  //Here we're making sure that an AyncTask is running as progress bar is to be made visible then only
    {
        {
            if(jprogressbar.getVisibility()==View.INVISIBLE && jprogressbar.getProgress()!=jprogressbar.getMax())  //Here we are making sure that neither ProgressBar
            {                                                                                                      // is Visible and nor its progress is 100%
                            jprogressbar.setVisibility(View.VISIBLE);
            }
        }
    }
    }


    public void hideProgressBarAfterDownloading()
    {
        if(fragment123.MyAsyncTaskObject!=null)                  //Here we're making sure that an AyncTask is running as progress bar is to be made visible then only.
        {
            {
                if(jprogressbar.getVisibility()==View.VISIBLE)  //Here we are making sure that neither ProgressBar  is Visible and nor its progress is 100%
                {
                    jprogressbar.setVisibility(View.INVISIBLE);
                }
            }
        }
    }
/*******************************************************************************************************************************************************************************/

    //Correspong method to onProgressUpdate() in MyAsyncTask class as we dont have access of ProgressBar in there.
    public void progressUpdate(int progress)
    {
    jprogressbar.setProgress(progress);
    }
}

