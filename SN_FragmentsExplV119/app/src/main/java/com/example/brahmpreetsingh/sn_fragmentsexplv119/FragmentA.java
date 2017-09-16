package com.example.brahmpreetsingh.sn_fragmentsexplv119;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by brahmpreet.singh on 12/4/2016.
 */
public class FragmentA extends Fragment implements View.OnClickListener{                  //Using OnClickListener approach instead of xml onClick attribute way
    Button jbutton;
    int counter = 0;
    Communicator comm;




    // To put in the designated value to counter variable after 'onSaveInstanceState()' is done with its work
    @Override
    public void onCreate(Bundle savedInstanceState) {                                      //Here we're recieving the 'outState' variable in 'savedInstanceState'
        super.onCreate(savedInstanceState);
        if (savedInstanceState==null)                                                      //This is checking if this is first time program is running
        {
            counter=0;
        }
        else                                                                               //else statement to get the counter value from 'savedInstanceState'
        {
            counter = savedInstanceState.getInt("CounterKey");
        }
    }




    //Linking Layout and java file
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.layout_fragment_a,container,false);                                    //Writing this we've linked layoutA and javafileA.

    }




    //Creating reference to component
    @Override
    public void onActivityCreated(Bundle savedInstanceState)                                 //We cant use onCreate() method so we used onActivityCreated()
    {                                                                                        //as we're working with fragment and not with MainActivity.
        super.onActivityCreated(savedInstanceState);
        jbutton=(Button) getActivity().findViewById(R.id.xbutton1);                          //Reference to 'button' component created.
        jbutton.setOnClickListener(this);
        comm = (Communicator) getActivity();                                                 //Here we got the Communicator object 'comm' containing MainActivity
    }





    //Handling what to do when button will be clicked.
    @Override
    public void onClick(View v) {                                                             //Inplementing onClick()
        counter++;
        comm.respond("Button is clicked "+counter+" times");                            //Using the 'comm' object we accesed/called subclass method respond()
                                                                                        //i.e we passed String value to it. (to method in MainActivity)
                                                                                        //(After this step we need to go to MainActivity and then in the repond()
                                                                                        // pass the value to FragmentB after by using 'FragmentManager'
    }


    //To save the 'counter' variable state into 'outState' variable
    @Override
    public void onSaveInstanceState(Bundle outState) {                                  //This method will help us save Counter variable's state
        super.onSaveInstanceState(outState);
        outState.putInt("CounterKey",counter);                                          //Here we've put 'counter' variable into 'outState' Bundle variable
    }
}
