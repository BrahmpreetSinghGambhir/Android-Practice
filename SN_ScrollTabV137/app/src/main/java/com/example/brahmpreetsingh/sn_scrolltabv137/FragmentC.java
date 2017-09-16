package com.example.brahmpreetsingh.sn_scrolltabv137;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by brahmpreet.singh on 12/15/2016.
 */
public class FragmentC extends android.support.v4.app.Fragment                     //Make sure to extend 'android.support.v4.app.Fragment' while working with tabs
{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.layout_fragment_c,container,false);
    }
}
