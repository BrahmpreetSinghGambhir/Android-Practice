package com.example.brahmpreetsingh.sn_btnonclickvid15;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void doSomething(View v)                     //doSomething() method that was to be called when button clicked, defined. Here We need to pass View's object "v" as View's object "v" contains info about
    {                                                  //which Button is clicked.
    if(v.getId()==R.id.xbutton1)                                            //Here we're comparing id information in View's object "v" (Clicked button id info in "v" object)
    {                                                                        // with the ids we have in our xml file.
        Log.d("Brahm","Button 1 clicked");
    }
        if(v.getId()==R.id.xbutton2)
        {
            Log.d("Brahm","Button 2 clicked");
        }
    }
}
