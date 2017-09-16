package com.example.brahmpreetsingh.sn_frgmntbackstackv129;

import android.app.FragmentTransaction;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/*
    *************************************************************************************************************************************************************
    On writing addToBackStack() method we will become able to undo last transaction that we processed. (Each Fragment Transaction saved in Backstack)
    Earlier manager was just getting us out of Activity when we were pressing Back Button. Now its letting us undo Fragment operations too by saving last state.
    *************************************************************************************************************************************************************
*/

/*We're implementing this interface to showcase changes made to BackStack*/
public class MainActivity extends AppCompatActivity implements android.app.FragmentManager.OnBackStackChangedListener{  /*We're implementing this interface
                                                                                                                          to showcase changes made to BackStack*/

    android.app.FragmentManager manager123;                    //As FragmentManager's object is to be used in all methods, we have got its reference outside
    TextView jtextview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        manager123=getFragmentManager();                        //Under onCreate() method we've objectified the reference.
        jtextview = (TextView)findViewById(R.id.xmessage);

        /*We need to make 'manager123' aware of the 'BackStackChangedListener' as 'manager123' is responsible for BackStack processing.
          Here we've set/added BackStackChangedListener to 'manager123' (This step is must as to let Manager know that which method is to be called
          when there is a change in BackStack)*/
        manager123.addOnBackStackChangedListener(this);
    }


    public void addA(View v)
    {
        FragmentA f1 = new FragmentA();                                                 //FragmentA's java object created
        FragmentTransaction transaction123 = manager123.beginTransaction();             //FragmentTransaction objectified
        transaction123.add(R.id.groupmain,f1,"A");                                      //Using FragmentTransaction object & add() added FragmentA to MainActivity

        transaction123.addToBackStack("ST_addA");                             //By writing this, we are adding this transaction to BackStack
                                                                              //and thereby letting Manager consider this transaction when user press Back button

        transaction123.commit();                                                        //Transaction commited.
    }


    public void removeA(View v)
    {
        FragmentA foundfragmentA1 = (FragmentA)manager123.findFragmentByTag("A");       //Here we're trying to find FragmentA with reference "A"
        FragmentTransaction transaction123 = manager123.beginTransaction();
        if(foundfragmentA1!=null)                                                       //Here we're checking if FragmentA is already existing in Activity
        {
            transaction123.remove(foundfragmentA1);                                     //Using FragmentTransaction object & remove(), 'foundFragmentA' is removed

            transaction123.addToBackStack("ST_removeA");

            transaction123.commit();                                                    //Transaction commited.
        }
        else
        {
            Toast.makeText(this,"FragmentA not added yet",Toast.LENGTH_LONG).show();
        }
    }


    public void addB(View v)
    {
        FragmentB f2=new FragmentB();
        FragmentTransaction transaction123 = manager123.beginTransaction();
        transaction123.add(R.id.groupmain,f2,"B");

        transaction123.addToBackStack("ST_addB");                       //By writing this, we are adding this transaction to BackStack
                                                                        //and thereby letting Manager consider this transaction when user press Back button

        transaction123.commit();
    }


    public void removeB(View v)
    {
        FragmentB foundfragmentB1 = (FragmentB) manager123.findFragmentByTag("B");                  //Here we're trying to find FragmentB with tag 'B'
        FragmentTransaction transaction123 = manager123.beginTransaction();
        if(foundfragmentB1!=null)                                                                   //Here we're checking if FragmentB even exists?
        {
            transaction123.remove(foundfragmentB1);

            transaction123.addToBackStack("ST_removeB");                //By writing this, we are adding this transaction to BackStack
                                                                        //and thereby letting Manager consider this transaction when user press Back button

            transaction123.commit();
        }
        else
        {
            Toast.makeText(this,"FragmentB not added yet",Toast.LENGTH_LONG).show();
        }
    }


    public void replaceAB(View v)
    {
        FragmentA f1 = (FragmentA) manager123.findFragmentByTag("A");
        FragmentB f2 = new FragmentB();
        FragmentTransaction transaction123 = manager123.beginTransaction();
        if(f1!=null) {                                                                //Here we're making sure that the FragmentA to be replaced does exist
            transaction123.replace(R.id.groupmain, f2, "B");                          //It could take 2 parameters too

            transaction123.addToBackStack("ST_replaceAB");              //By writing this, we are adding this transaction to BackStack
                                                                        //and thereby letting Manager consider this transaction when user press Back button

            transaction123.commit();
        }
        else
        {
            Toast.makeText(this,"FragmentA doesnt exist",Toast.LENGTH_LONG).show();
        }
    }


    public void replaceBA(View v)
    {
        FragmentA f1 = new FragmentA();
        FragmentB f2 = (FragmentB) manager123.findFragmentByTag("B");
        FragmentTransaction transaction123 = manager123.beginTransaction();
        if(f2!=null)
        {
            transaction123.replace(R.id.groupmain, f1, "A");

            transaction123.addToBackStack("ST_replaceBA");              //By writing this, we are adding this transaction to BackStack
                                                                        //and thereby letting Manager consider this transaction when user press Back button


            transaction123.commit();
        }
        else
        {
            Toast.makeText(this,"FragmentB doesnt exist",Toast.LENGTH_LONG).show();
        }
    }


    public void attachA(View v)
    {
        FragmentA f1 = (FragmentA) manager123.findFragmentByTag("A");
        FragmentTransaction transaction123 = manager123.beginTransaction();
        if(f1!=null)
        {
            transaction123.attach(f1);                                     //Due to execution of this method, onAttach() method in FragmentA wont be called

            transaction123.addToBackStack("ST_attachA");                    //By writing this, we are adding this transaction to BackStack
                                                                            //and thereby letting Manager consider this transaction when user press Back button

            transaction123.commit();
        }
        else
        {
            Toast.makeText(this,"FragmentA is null",Toast.LENGTH_LONG).show();
        }
    }

    public void detachA(View v)
    {
        FragmentA f1 = (FragmentA) manager123.findFragmentByTag("A");
        FragmentTransaction transaction123 = manager123.beginTransaction();
        if(f1!=null)
        {
            transaction123.detach(f1);                                          //Due to execution of this method, onDetach () method in FragmentA wont be called

            transaction123.addToBackStack("ST_detachA");                        //By writing this, we are adding this transaction to BackStack
                                                                                //and thereby letting Manager consider this transaction when user press Back button

            transaction123.commit();
        }
    }



    //(Implementing Unimplemented method to implement interface) Everytime there will be a change in Backstack this method shall be called
    @Override
    public void onBackStackChanged()
    {
        jtextview.setText(jtextview.getText()+"\n");
        jtextview.setText(jtextview.getText()+"Current status of Backstack"+"\n");

        int transaction_count = manager123.getBackStackEntryCount();       //By this we are retrieving no. of transactions present in BackStack
        for(int j=transaction_count-1;j>=0;j--)                            //As first entry of Transaction is at the bottom of BackStack we're looping from the last
        {
            //Here we're getting objectified reference to the transaction entry at a particular index via manager123 (We objectified BackStackEntry class here)
            android.app.FragmentManager.BackStackEntry entry123 = (android.app.FragmentManager.BackStackEntry) manager123.getBackStackEntryAt(j);

            //Via 'BackStackEntry' class object 'entry123' we're retrieving name(Tag) of the Fragment that was passed to 'addToBackStack()' method earlier
            jtextview.setText(jtextview.getText()+" "+entry123.getName()+"\n");
        }

    }

    public void back(View v)
    {
        manager123.popBackStack();                                          //THis will make custom back button remove last transaction done
    }

    public void popAddB(View v)
    {
        manager123.popBackStack("ST_addB",0);                                              //This will help us directly pop to transaction with tag 'ST_addB'

        //This will pop out transacttion done BEFORE -------> transaction with tag 'ST_addB' (As this will remove transaction with tag 'ST_addB' too
        // manager123.popBackStack("ST_addB", android.app.FragmentManager.POP_BACK_STACK_INCLUSIVE);
    }
}


