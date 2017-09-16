package com.example.brahmpreetsingh.sn_asynctaskegv184;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{
    ListView jlistview;
    String[] names ={"Text 1","Text 2","Text 3","Text 4","Text 5","Text 6","Text 7","Text 8",
            "Text 9","Text 10","Text 11","Text 12","Text 13","Text 14","Text 15","Text 16",
            "Text 17","Text 18","Text 19","Text 20","Text 21","Text 22","Text 23","Text 24",
            "Text 17","Text 18","Text 19","Text 20","Text 21","Text 22","Text 23","Text 24",
            "Text 17","Text 18","Text 19","Text 20","Text 21","Text 22","Text 23","Text 24",
            "Text 17","Text 18","Text 19","Text 20","Text 21","Text 22","Text 23","Text 24",
            "Text 17","Text 18","Text 19","Text 20","Text 21","Text 22","Text 23","Text 24",
            "Text 17","Text 18","Text 19","Text 20","Text 21","Text 22","Text 23","Text 24"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_PROGRESS);                          //To enable inbuilt ProgressBar near the title of app
        setContentView(R.layout.activity_main);

        jlistview=(ListView)findViewById(R.id.xlistView);

        //ArrayAdapter created with empty ArrayList containing no entry
        ArrayAdapter<String> adapter123 = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,new ArrayList<String>());

        //Adapter set to ListView
        jlistview.setAdapter(adapter123);

        MyAsyncTask MyAsyncTaskObject = new MyAsyncTask();
        MyAsyncTaskObject.execute();                                    //The moment this command will be executed, onPreExecute() method will be called

    }

    public class MyAsyncTask extends AsyncTask<Void,String,Void>        //3 parameters ---> 1. Void as doInBackground() isnt receiving any parameter
    {                                                                   //                  2. String as onProgressUpdate() is receiving a String parameter
                                                                        //                  3. Void as onPostExecute() isnt receiving any parameter
        ArrayAdapter<String> adapter456;
        int count = 0;







        @Override
        protected void onPreExecute()                                       //First method to be executed
        {
        adapter456 = (ArrayAdapter<String>) jlistview.getAdapter();         //We got the adapter here that was set to jlistview
        setProgressBarIndeterminate(false);                                 //We have made the ProgressBar determinate
        setProgressBarVisibility(true);                                     //We have set visiblity of PregressBar to be true
        }








        @Override
        protected Void doInBackground(Void... params)                       //Second method to be executed (Running in Background Thread)
        {
            for(String item: names)
            {
            publishProgress(item);                                      //Passing a string indirectly to onProgressUpdate() as this will call onProgressUpdate()
            }

            try
            {
                Thread.sleep(6000);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            return null;
        }









        @Override                                                        //Third method to be executed
        protected void onProgressUpdate(String... values)       //Have to make receiving poarameter as String as doInBackground() method is sending a String
        {
        adapter456.add(values[0]);                                     //Adding items to Adapter. 'values[0]' as we have just one value that we're receiving
        count++;
        setProgress((int)(((double)(count/names.length))*10000));      //Setting progress to inbuilt ProgressBar
        }







        @Override
        protected void onPostExecute(Void aVoid)                        //Fourth method to be executed
        {
            setProgressBarVisibility(false);
            Toast.makeText(MainActivity.this,"Items added to list ",Toast.LENGTH_LONG).show();
        }
    }
}
