package com.example.brahmpreetsingh.sn_flexiuivid123to125;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by brahmpreet.singh on 12/10/2016.
 */
public class FragmentA extends Fragment implements AdapterView.OnItemClickListener {
    Communicator comm;
    ListView jlistview;


    //To link Layout file and XML file
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.layout_fragment_a,container,false);
    }

    //To set content to list in FragmentA
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        jlistview=(ListView)getActivity().findViewById(R.id.xlistView1);
        ArrayAdapter adapter123 = ArrayAdapter.createFromResource(getActivity(),R.array.Chapters,android.R.layout.simple_list_item_1);
        jlistview.setAdapter(adapter123);
        jlistview.setOnItemClickListener(this);

    }

    //To receive communicator's object from MainActivity & saving it in a variable.
    public void setCommunicator(Communicator c) {
        this.comm = c;
    }

    //Interface Communicator uderFragment \A
    public interface Communicator
    {
        public void respond(int i);
    }

    //Usng that variable 'comm' itself, we got able to access method respond() present in MainActivity and thus passed position of item in list clicked.
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id)
    {
    comm.respond(position);
    }
}