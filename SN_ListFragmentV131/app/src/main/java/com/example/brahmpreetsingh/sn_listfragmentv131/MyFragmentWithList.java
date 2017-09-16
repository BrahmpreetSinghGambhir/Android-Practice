package com.example.brahmpreetsingh.sn_listfragmentv131;

import android.app.ListFragment;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

/**
 * Created by brahmpreet.singh on 12/13/2016.
 */
public class MyFragmentWithList extends ListFragment implements AdapterView.OnItemClickListener              //Here we've extended 'ListFragment' class
{                                                                                                           //and thereby, have turned class into LsitFragment


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.layout_my_fragment_with_list,container,false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // Here we've created the adapter as per our requirement.
        ArrayAdapter adapter123 = ArrayAdapter.createFromResource(getActivity(),R.array.Heroes,android.R.layout.simple_list_item_1);

        // Adapter is always set on the component to set the data to it. Using 'getListView()' method we got the reference to the List component
        // and then adapter is set to it.
        getListView().setAdapter(adapter123);

        // Here we're telling the ListView that do what 'onItemClick()' method is telling u to do when user clicks item.
        getListView().setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(getActivity(),"Item no "+position, Toast.LENGTH_LONG).show();
    }
}
