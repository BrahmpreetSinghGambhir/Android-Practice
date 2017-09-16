package com.example.brahmpreetsingh.sn_frgmntbackstackv129;

/**
 * Created by brahmpreet.singh on 12/12/2016.
 */
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by brahmpreet.singh on 12/11/2016.
 */
public class FragmentA extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.layout_fragment_a,container,false);
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d("BrahmTag","OnActivityCreated called in FragmentA");
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.d("BrahmTag","OnAttach called in FragmentA");
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d("BrahmTag","OnSaveInstanceState called in FragmentA");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d("BrahmTag","OnStart called in FragmentA");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d("BrahmTag","OnStop called in FragmentA");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d("BrahmTag","OnPause called in FragmentA");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("BrahmTag","OnDestroy called in FragmentA");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d("BrahmTag","OnDestroyView called in FragmentA");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d("BrahmTag","OnDetach called in FragmentA");
    }
}
