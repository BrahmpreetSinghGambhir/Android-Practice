package com.example.brahmpreetsingh.sn_dilogfragmtv133;

import android.app.Activity;
import android.app.DialogFragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by brahmpreet.singh on 12/13/2016.
 */
public class FragmentWithDialogBox extends DialogFragment implements View.OnClickListener{

    Button jbuttonyes;
    Button jbuttonno;
    Communicator comm;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.layout_fragment_with_dialog_box,null);                   //Here we have passed second parameter as NULL as Dialog box is
                                                                                                    //entirely an independent View that we're returning. Here we
                                                                                                    //used to pass the 'container' as second parameter refering to
                                                                                                    //layout like 'Relative layout/LinearLayout' in which the view
                                                                                                    //that we're returning is to be inflated.

        jbuttonno=(Button) v.findViewById(R.id.xbuttonno);
        jbuttonyes=(Button) v.findViewById(R.id.xbuttonyes);

        jbuttonyes.setOnClickListener(this);
        jbuttonno.setOnClickListener(this);

        setCancelable(false);

        return v;                                                                                   //After operations on 'V' we've returned the view
    }


    @Override
    public void onAttach(Activity activity) {                                         //We're using 'onAttach()' method to recieve object of MainActivity
                                                                                      //that will be usable to get the object of Communicator
        super.onAttach(activity);
        this.comm=(Communicator)activity;                                             //Here we're converting MainActivity's object to object of
                                                                                      // 'Communicator' form so that we can access the 'onDialogMessage()'
                                                                                      // method that we implemented during interface implementation.
                                                                                      //(Reason that this MAinActivity conversion to Communicator has become possible)

    }

    @Override
    public void onClick(View v)
    {
        if(v.getId()==R.id.xbuttonno) {

            dismiss();                                                                      //This will dismiss the dialog box

                                                                                                    //COMMUNICATOR APPROACH
            comm.onDialogMessage("No was clicked");                                         //Calling 'onDialogMessage()' method implemented in MainActivity
                                                                                            // via object of Communicator

            // Toast.makeText(getActivity(), "No", Toast.LENGTH_LONG).show();                       //DIRECT EASY APPROACH
        }

        else
        {
            dismiss();                                                                      //This will dismiss the dialog box

                                                                                                    //COMMUNICATOR APPROACH
            comm.onDialogMessage("Yes was clicked");                                        //Calling 'onDialogMessage()' method via object of Communicator
                                                                                            // via object of Communicator

            // Toast.makeText(getActivity(),"Yes",Toast.LENGTH_LONG).show();                        //DIRECT EASY APPROACH
        }
    }
}

interface Communicator                                                                      //Interface declared under Fraagment
{
    public void onDialogMessage(String message);                                            //Unimplemented method declared.
}