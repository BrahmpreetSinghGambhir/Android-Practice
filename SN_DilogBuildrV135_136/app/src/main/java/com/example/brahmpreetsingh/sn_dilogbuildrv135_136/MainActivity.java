package com.example.brahmpreetsingh.sn_dilogbuildrv135_136;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //This method will respond when the 'show dialog' button will be clicked.
    public void showDialog(View v)
    {
        MyAlertDialog dialogobject = new MyAlertDialog();               //Here we've objectified the Fragment and thus we have retrieved the Dialog's object
                                                                        //as the 'MyAlertDialog' class is returning object of Dialog.
        dialogobject.show(getFragmentManager(),"AlertDialog");          //Here we've shown the object of Dialog and passed the two parameters
    }




    //This method will respond when 'Show Method in Fragment itself' will be clicked. 'Method for bringing normal fragment to activity in LinearLayout.
    public void showFragment(View v)
    {
        MyAlertDialog dialogobject = new MyAlertDialog();
        android.app.FragmentManager manager123 = getFragmentManager();
        FragmentTransaction transaction123 = manager123.beginTransaction();
        transaction123.add(R.id.xgroupmain,dialogobject,"fragment_normal");
        transaction123.commit();
    }
}
