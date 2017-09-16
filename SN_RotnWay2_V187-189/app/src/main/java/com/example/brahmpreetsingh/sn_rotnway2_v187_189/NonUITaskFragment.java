package com.example.brahmpreetsingh.sn_rotnway2_v187_189;
                                                                    //NON Destructible//
import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;



/***********************************************************************************************************************************************************************/
/*Out target is to make The AsyncTask know that which is the Latest activity bein processed after orirntation change and let it process ProgressBar on New Activity*/
/**********************************************************************************************************************************************************************/


public class NonUITaskFragment extends Fragment
{

    Activity activityF;                                     //Reference created for Activity in which Fragment is currently placed (It changes when
                                                            //Orientation changes) as earlier activity gets destroyed.
    MyAsyncTask MyAsyncTaskObject;

    //In this method, we are making the fragment indestructible
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setRetainInstance(true);                                                    //This statement wont let onCreate() & onDestroy() method to run
        //making the Fragment indestructible. Earlier before writing this statement
        //these two methods were getting called on Rotation of screen and Fragment was
        //also getting destroyed like Activity.
    }






    //EVERYTIME THE ACTIVITY WILL GET DESTROYED on rotation of screen, this 'onAttach()' method will be called after other Lifecycle methods and
    //with this method only, Fragment will be attached to Activity i.e to NEW Activity's reference.
    @Override
    public void onAttach(Activity activity)                 //Here 'activity' parameter signifies the latest 'activity' in our possession that we got after
    {                                                       //previous one was destroyed and this one came into existence
        super.onAttach(activity);
        Log.d("Brahm","onAttach() called");
        this.activityF=activity;
        if(MyAsyncTaskObject!=null)                         //If the user didnt start the task earlier the AsyncTask is going to be null, ie we not update
        {                                                   //activity. But if it is not null we need to update 'activity' in AsyncTask ie we will let
                                                            //AsyncTask know that which activity is active by calling its onAttach() method and passing active
                                                            //activity

            MyAsyncTaskObject.onAttach(activity);                   //By this command, we're sending the active activity reference
                                                                    //on the lifecycle methods in Fragment to Asynctask
                                                                    //(similar method) and thereby letting AsyncTask know
                                                                    //which Activity is active after change in orientation.

        }
    }


    @Override
    public void onDetach() {
        super.onDetach();
        if(MyAsyncTaskObject!=null)                  //Here we are checking if the user started a new task?
        {                                            //If no, then MyAsyncTaskObject =null, else the earlier activity was destroyed, which means that we
                                                     // can update the AsyncTask for the same.

            MyAsyncTaskObject.onDetach();            //By calling onDeatach() method of MyAsyncTask here in Fragment means that we want to tell AsyncTask that
                                                     //this new activity is also getting destroyed and you ll get a new active activity soon ie. one another time.
        }
    }


    //beginTask()------> We want to make Fragment responsible for starting task. So we will be writing this
    //                    method to start the AsyncTask & we dont want to start AsyncTask in MainActivity.




    public void beginTask(String...Params)                      //Here we're receiving the URL from MainActivity's onClick method 'downloadImage()'
    {
        MyAsyncTaskObject=new MyAsyncTask(activityF);     //MyAsyncTask class instantiated with latest activity passed as parameter. So MyAsynctask
                                                          // will act on latest activity only.
        MyAsyncTaskObject.execute(Params);                //Instantiated class Executed, making AsyncTask class's methods run and act on Latest activity passed.
    }




}
