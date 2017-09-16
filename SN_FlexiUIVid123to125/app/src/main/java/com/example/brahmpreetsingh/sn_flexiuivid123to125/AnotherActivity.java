package com.example.brahmpreetsingh.sn_flexiuivid123to125;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by brahmpreet.singh on 12/10/2016.
 */

//This defines the activity that is to be called when any iteem on list is clicked in Portrait mode.
public class AnotherActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_another_activity);                           //This is must.

        Intent objintent = getIntent();
        int IndexReceived = objintent.getIntExtra("IntentKey",0);                  //In case no index is received then default value set to 0
        android.app.FragmentManager manager = getFragmentManager();
        FragmentB f2 = (FragmentB) manager.findFragmentById(R.id.fragmentb);       //Took reference to FragmentB
        if(f2!=null)
        {
            f2.changeText(IndexReceived);                                                //Using reference we passed the IndexValue received through Intent
                                                                                         //to changeText() method present in FragmentB
        }
    }
}
