package com.example.brahmpreetsingh.sn_frgmntflexiuivid122;

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
    public void respond(int i)
    {
        android.app.FragmentManager manager123 = getFragmentManager();
        FragmentB f2 = (FragmentB) manager123.findFragmentById(R.id.fragmentb);
        f2.changeText(i);


    }
}
