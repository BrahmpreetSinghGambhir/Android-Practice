package com.example.brahmpreetsingh.sn_dilogfragmtv133;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements Communicator {                       //MainActivity implementing interface Communicator

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void showDialog(View v)                                                              //Implementing onClick() method applicable to 'ShowDialog' button
    {
        FragmentWithDialogBox d1 = new FragmentWithDialogBox();                                 //Fragment objectified
        android.app.FragmentManager manager123 = getFragmentManager();                          //FragmentManager objectified.
        d1.show(manager123,"DialogKey");                                                        //show() method executed on Fragment's object passing,
                                                                                                //Parameter 1 = Manager's object, Parameter 2 = Name tag to Dialog
    }

    @Override
    public void onDialogMessage(String message) {                                               //Interface Communicator's method implementation which will receive
                                                                                                // parameter from onClick() method in Fragment
        Toast.makeText(this,""+message,Toast.LENGTH_LONG).show();
    }
}
