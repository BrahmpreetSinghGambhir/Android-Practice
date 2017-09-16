package com.example.brahmpreetsingh.sn_frgmntflexiuivid122;

import android.app.Fragment;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by brahmpreet.singh on 12/9/2016.
 */
public class FragmentA extends Fragment implements AdapterView.OnItemClickListener{

    ListView jlist;
    Communicator comm;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        jlist=(ListView)getActivity().findViewById(R.id.xlistView);

        comm=(Communicator)getActivity();

        ArrayAdapter adapter123 = ArrayAdapter.createFromResource(getActivity(),R.array.Titles,android.R.layout.simple_list_item_1); //3rd parameter defines appearnce
        jlist.setAdapter(adapter123);
        jlist.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id)
    {
         comm.respond(position);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.layout_fragment_a,container,false);
    }
}
