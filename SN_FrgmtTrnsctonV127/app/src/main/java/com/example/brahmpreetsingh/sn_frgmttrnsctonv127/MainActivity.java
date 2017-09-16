package com.example.brahmpreetsingh.sn_frgmttrnsctonv127;

import android.app.FragmentTransaction;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    android.app.FragmentManager manager123;                    //As FragmentManager's object is to be used in all methods, we have got its reference outside


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        manager123=getFragmentManager();                        //Under onCreate() method we've objectified the reference.
    }


    public void addA(View v)
    {
        FragmentA f1 = new FragmentA();                                                 //FragmentA's java object created
        FragmentTransaction transaction123 = manager123.beginTransaction();             //FragmentTransaction objectified
        transaction123.add(R.id.groupmain,f1,"A");                                      //Using FragmentTransaction object & add() added FragmentA to MainActivity
        transaction123.commit();                                                        //Transaction commited.
    }


    public void removeA(View v)
    {
        FragmentA foundfragmentA1 = (FragmentA)manager123.findFragmentByTag("A");       //Here we're trying to find FragmentA with reference "A"
        FragmentTransaction transaction123 = manager123.beginTransaction();
        if(foundfragmentA1!=null)                                                       //Here we're checking if FragmentA is already existing in Activity
        {
            transaction123.remove(foundfragmentA1);                                     //Using FragmentTransaction object & remove(), 'foundFragmentA' is removed
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
        transaction123.commit();
    }


    public void removeB(View v)
    {
        FragmentB foundfragmentB1 = (FragmentB) manager123.findFragmentByTag("B");                  //Here we're trying to find FragmentB with tag 'B'
        FragmentTransaction transaction123 = manager123.beginTransaction();
        if(foundfragmentB1!=null)                                                                   //Here we're checking if FragmentB even exists?
        {
            transaction123.remove(foundfragmentB1);
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
            transaction123.commit();
        }
    }
}
