package com.example.brahmpreetsingh.sn_orientdispvid14;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {                         //This method gets called when AndroidManifest.xml file tells javacode that a change is encountered.

        // Log.d("Brahm",""+newConfig.orientation);  -----> This will return integer only wrt to Orientation.

        if(newConfig.orientation==Configuration.ORIENTATION_LANDSCAPE)                    //"newConfig" object passed to method contains all the information regarding changes.
        {
            Log.d("Brahm","Welcome to landscape config.");
        }

        if(newConfig.orientation==Configuration.ORIENTATION_PORTRAIT)             //"Configuration" is an inbuilt object that is having static fields like "ORIENTATION_LANDSCAPE" & "ORIENTATION_PORTRAIT"
        {                                                                         //We could've passed integers too eg 1,2
            Log.d("Brahm","Welcome to portrait config.");
        }

        super.onConfigurationChanged(newConfig);
    }
}
