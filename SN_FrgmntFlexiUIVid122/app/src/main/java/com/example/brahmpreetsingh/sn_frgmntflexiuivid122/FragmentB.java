package com.example.brahmpreetsingh.sn_frgmntflexiuivid122;

import android.app.Fragment;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created by brahmpreet.singh on 12/9/2016.
 */
public class FragmentB extends Fragment {

    TextView jtextview;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        jtextview = (TextView)getActivity().findViewById(R.id.xtextView);

        }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.layout_fragment_b,container,false);
    }

    public void changeText(int i)
    {
        Resources res123 = getResources();             //Here we're using 'Resaources' class as we need array in user-defined method and not in a Lifecycle method.
        String[] discriptions123 = res123.getStringArray(R.array.Discriptions);  //Here we got the array in the array variable discriptions123
        jtextview.setText(discriptions123[i]);
    }
}
