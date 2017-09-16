package com.example.brahmpreetsingh.sn_fragmentsexplv119;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by brahmpreet.singh on 12/4/2016.
 */
public class FragmentB extends Fragment {
    TextView jtextview;
    String data2;                                           //We've create dthis variable to be used in 'savedInstanceState()'



    //Linking Layout and java file + for setting initial text to TextView n case of orientation change.
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.layout_fragment_b,container,false);      //We've created this reference variable 'v' just to use it to refer to TextView


        if(savedInstanceState==null)
        {

        }
        else
        {
            data2=savedInstanceState.getString("TextKey");                                    //We've retrieved value in 'data2' variable.
            TextView myText = (TextView) v.findViewById(R.id.xtextView1);                     //We've got a variable referencing to component
            myText.setText(data2);                                                            //Here we've setText to the java reference of the component.
        }

        return inflater.inflate(R.layout.layout_fragment_b,container,false);                                    //Writing this we've linked layoutB and javafileB.
    }




    //Creating reference to component
    @Override
    public void onActivityCreated(Bundle savedInstanceState)                                        //We cant use onCreate() method so we used onActivityCreated()
    {                                                                                               //as we're working with fragment and not with MainActivity.
        super.onActivityCreated(savedInstanceState);
        jtextview=(TextView)getActivity().findViewById(R.id.xtextView1);                            //Reference to 'button' component created.
    }





    //Handling what to do put in TextView (Fragment B )
    public void changeText(String data)
    {
        this.data2=data;                                //We've put the data we're recieving in 'data' variable into 'data2' to use it in 'saveInstanceState()
        jtextview.setText(data);
    }


    // This is to save the last text in TextView of FragmentB
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("TextKey",data2);           //Here we're putting 'data2' content into 'outState' variable.

    }
}
