package com.example.brahmpreetsingh.sn_frgmntjavav116;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by brahmpreet.singh on 11/29/2016.
 */
public class MyFragmentJavaApproach extends Fragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.my_fragment_java_approach_layout,container,false);                       //Appearance link defined.
    }
}
