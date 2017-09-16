package com.example.brahmpreetsingh.sn_frgmntlifecyclev113;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class MyFragment extends Fragment {                                          //Step 1
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.d("Brahm","onAttach called<Fragment>");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("Brahm","onCreate called<Fragment>");
    }




    //Here we are performing the STEP 3 of linking the xml layout with the fragment by returning the java object of xml file of which we want appearance.
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.d("Brahm","onCreateView called<Fragment>");
        return inflater.inflate(R.layout.my_fragment_layout,container,false);
        }



    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d("Brahm","onActivityCreated called<Fragment>");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d("Brahm","onStart called<Fragment>");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d("Brahm","onResume called<Fragment>");
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d("Brahm","onSavedInstanceState called<Fragment>");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d("Brahm","onPause called <Fragment>");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d("Brahm","onStop called <Fragment>");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d("Brahm","onDestroyView called<Fragment>");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("Brahm","onDestroy called<Fragment>");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d("Brahm","onDetach called<Fragment>");
    }
}
