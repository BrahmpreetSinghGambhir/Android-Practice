package com.example.brahmpreetsingh.sn_flexiuivid123to125;

import android.app.Fragment;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by brahmpreet.singh on 12/10/2016.
 */
public class FragmentB extends Fragment {
    TextView jtextview;

    //To link layout File and java file for FragmentB
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.layout_fragment_b,container,false);
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }



    /*Changes to be done on 'fragmentb' are defined in this method.
    And because in our program we have two ways (Landscape & Portrait) to change FragmentB's component TextView. So it is must to objectify
    this component in changeText() method itself.*/
    public void changeText(int i)
    {
        jtextview = (TextView) getActivity().findViewById(R.id.xtextView1);     //it is must to objectify this component (TextView) in changeText() method itself.
        Resources res=getResources();
        String[] discriptions = res.getStringArray(R.array.Discriptions);
        jtextview.setText(discriptions[i]);
    }
}
