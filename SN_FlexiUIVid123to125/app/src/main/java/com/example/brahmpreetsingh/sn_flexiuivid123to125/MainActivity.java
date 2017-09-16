package com.example.brahmpreetsingh.sn_flexiuivid123to125;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends Activity implements FragmentA.Communicator {

    android.app.FragmentManager manager123;
    FragmentA f1;
    FragmentB f2;

    /*Using this method we are objectifying FragmentA as it is common in both modes (Portrait & Landscape)
    * Morover we have passed MainActivity object itself to setCommunicator() method but yet it was accepted by setCommunicator() method because
    * 'MainActivity' class is implememnting the Communicator interface.*/
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        manager123 = getFragmentManager();
        f1 = (FragmentA) manager123.findFragmentById(R.id.fragmenta);
        f1.setCommunicator(this);
    }


    /*In this method we are checking if mode is Portrait or Landscape, thereby we either are making a new activity pop out(Portrait case)
      or we're making change to adjacent FragmentB (Landscape mode)*/
    @Override
    public void respond(int i)
    {                                                                   //Landscape
        f2 = (FragmentB) manager123.findFragmentById(R.id.fragmentb);
        if (f2 != null && f2.isVisible())
        {
            f2.changeText(i);
        }
        else
        {                                                                 //Portrait
            Intent objintent = new Intent(this,AnotherActivity.class);
            objintent.putExtra("IntentKey",i);                   //Putting i's value (position) into objinent which can be reffered via keyname 'IntentKey'
            startActivity(objintent);                            //ActivityStarted to which this intent shall go to (AnotherActivity).
        }
    }
}
