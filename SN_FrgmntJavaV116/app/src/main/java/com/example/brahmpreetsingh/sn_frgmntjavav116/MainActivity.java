package com.example.brahmpreetsingh.sn_frgmntjavav116;

import android.app.FragmentTransaction;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        MyFragmentJavaApproach FragmentObject=new MyFragmentJavaApproach();                //Object of Fragment class created
        android.app.FragmentManager manager123 = getFragmentManager();                     //FragmentManager object created
        FragmentTransaction transaction123 = manager123.beginTransaction();                //Transaction begun using FragmentManager's object
        transaction123.add(R.id.xmyrelativelayout,FragmentObject,"TransactionKey");        //Addition operation performed to RelativeLayout in activity_main.xml
        transaction123.commit();                                                           //Transaction commited


    }
}
