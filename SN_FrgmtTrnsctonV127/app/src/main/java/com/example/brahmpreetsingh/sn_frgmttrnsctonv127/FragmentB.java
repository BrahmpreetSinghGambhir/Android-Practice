package com.example.brahmpreetsingh.sn_frgmttrnsctonv127;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by brahmpreet.singh on 12/11/2016.
 */
public class FragmentB extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.layout_fragment_b,container,false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d("BrahmTag","OnActivityCreated called in FragmentB");
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.d("BrahmTag","OnAttach called in FragmentB");
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d("BrahmTag","OnSaveInstanceState called in FragmentB");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d("BrahmTag","OnStart called in FragmentB");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d("BrahmTag","OnStop called in FragmentB");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d("BrahmTag","OnPause called in FragmentB");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("BrahmTag","OnDestroy called in FragmentB");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d("BrahmTag","OnDestroyView called in FragmentB");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d("BrahmTag","OnDetach called in FragmentB");
    }
}
