package com.example.brahmpreetsingh.sn_listfragmentv131;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Here we could have added Fragment by using the FragmentTransaction component by instead in current program we've directly placed the Fragment to xml file.
        /*
        FragmentManager manager123= getFragmentManager();
        FragmentTransaction transaction123 = manager123.beginTransaction();
        MyFragmentWithList f1=new MyFragmentWithList();
        transaction123.add(R.id.xrelativelayout,f1,"MyFragmentWithList");
        transaction123.addToBackStack("ST_MyFragmentWithList");
        transaction123.commit();
        */
    }
}
