package com.example.brahmpreetsingh.sn_scrolltabv137;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by brahmpreet.singh on 12/15/2016.
 */
public class FragmentA extends android.support.v4.app.Fragment          //Make sure to extend 'android.support.v4.app.Fragment' while working with tabs
{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.layout_fragment_a,container,false);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        if (savedInstanceState==null)
        {
            Log.d("Brahm", "onCreate called FIRST time");
        }
        else
        {
            Log.d("Brahm","onCreate called SUBSEQUENT time");
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        Log.d("Brahm","onAttach called");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d("Brahm","onActivityCreated called");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("Brahm","onDestroy called");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d("Brahm","onStart called");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d("Brahm","onPause called");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d("Brahm","onDestroyView called");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d("Brahm","onDetach called");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d("Brahm","onResume called");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d("Brahm","onStop called");
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d("Brahm","onSaveInstanceState called");
    }
}
