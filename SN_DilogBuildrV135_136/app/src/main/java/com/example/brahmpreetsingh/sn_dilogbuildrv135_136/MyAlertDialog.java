package com.example.brahmpreetsingh.sn_dilogbuildrv135_136;

import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.app.AlertDialog;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

/**
 * Created by brahmpreet.singh on 12/14/2016.
 */
public class MyAlertDialog extends DialogFragment
{

    /*If we want dialog box to just simply appear in the activity as a simple fragment and not as a pop-oout dialog Box we need to make sure that
    * 1. 'onCreateDialog()' method is not executed & neither the Dialog object should be created while working with this Fragment,
    * 2. only 'onCreateView()' method is executed in which Processing of Fragment shall be done..*/


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.layout_for_dialog_box,null);
        return v;
    }









/*^^^^^^^^^^^^^^^^^^We have commented this 'onCreateDialog()' as its muct not to have onCreateDialog() while bringing Fragment normally to activity^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^*/


//    @Override
//    public Dialog onCreateDialog(Bundle savedInstanceState)                     //Under this method we will be making Dialog object


///*************************************|||||||||||||||||||To make a simple dialog box with required View||||||||||||||||||||||***********************************/

//        {
//            AlertDialog.Builder builder123 = new AlertDialog.Builder(getActivity());
//
//            LayoutInflater inflater123 = getActivity().getLayoutInflater();
//            View v = inflater123.inflate(R.layout.layout_for_dialog_box, null);                          //We've got the required view in 'v' object
//            builder123.setView(v);                                                                      //Here we've set the view to 'builder123'
//            Dialog d1 = builder123.create();                                                            //Dialog box objectified
//            return d1;
//        }

/****************************************************************************************************************************************************************/








/*************************************|||||||||||||||||||To make a simple dialog box with checkboxes, Yes,No & Title||||||||||||||||||||||*********************

    {
        AlertDialog.Builder builder123 = new AlertDialog.Builder(getActivity());

        builder123.setTitle("Android App");
        builder123.setMultiChoiceItems(R.array.Days, null, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                Toast.makeText(getActivity(),"item number: "+which+"is clicked "+isChecked,Toast.LENGTH_LONG).show();
            }
        });
        builder123.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getActivity(),"Cancel was clicked",Toast.LENGTH_LONG).show();
            }
        });
        builder123.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getActivity(),"Ok was clicked",Toast.LENGTH_LONG).show();
            }
        });

        Dialog d1 = builder123.create();
        return d1;
    }

****************************************************************************************************************************************************************/







/*************************************|||||||||||||||||||To make a simple dialog box with list,Yes,No & Title||||||||||||||||||||||*********************************

    {
        final AlertDialog.Builder builder123 = new AlertDialog.Builder(getActivity());

        builder123.setTitle("Android app");
        builder123.setItems(R.array.Days, new DialogInterface.OnClickListener() {                                 //Here we have setitems in array to appear as list
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getActivity(),"The day clicked position is : "+which,Toast.LENGTH_LONG).show();
            }
        });
        builder123.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getActivity(),"cancel was clicked",Toast.LENGTH_LONG).show();
            }
        });
        builder123.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getActivity(),"ok was clicked",Toast.LENGTH_LONG).show();
            }
        });

        Dialog d1 = builder123.create();
        return d1;
    }

************************************************************************************************************************************************************************/







/*******************************************|||||||||||||||||||To make a simple dialog box with Yes,No & Title||||||||||||||||||||||*************************************

 {
        AlertDialog.Builder builder123 = new AlertDialog.Builder(getActivity());                               //With the help of Builder class we created object

//Setting properties to builder object and thereby modifying the dialog box.

        builder123.setTitle("Android app");
        builder123.setNegativeButton(R.string.cancel,new DialogInterface.OnClickListener() {            //NegativeButton & Positive button on an Builder(Dialog Box)-
            @Override                                                                                   //only listens to only special listener i.e  -
            public void onClick(DialogInterface dialog, int which) {                                    //'DialogInterface.OnClickListener()' and not to-
                Toast.makeText(getActivity(),"Cancel was clicked",Toast.LENGTH_LONG).show();            // 'View.OnClickListener()'.
            }
        });
        builder123.setPositiveButton(R.string.ok,new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getActivity(),"OK was clicked",Toast.LENGTH_LONG).show();
            }
        });

        Dialog d1 = builder123.create();                                                   //Here we've made dialog's object with the help of Builder object & create()
        return d1;                                                                         //Dialog's object returned.
   }

***********************************************************************************************************************************************************************/



}
