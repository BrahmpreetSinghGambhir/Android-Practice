package com.example.brahmpreetsingh.sn_fragmentsexplv119;

import android.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements Communicator {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void respond(String data)
    {
        android.app.FragmentManager manager123 = getFragmentManager();
        FragmentB f2 =  (FragmentB) manager123.findFragmentById(R.id.jfragmentb);      //Here we got the object of FragmentB using FragmentManager's object
                                                                                       //'manager123' & 'findFragmentById()'
        f2.changeText(data);                                                           //Here we've passed the data to FragmentB's method 'changeText()' via 'f2'

    }
}
