package com.example.brahmpreetsingh.sn_imeoptionsvid106;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements TextView.OnEditorActionListener{

    EditText jedittext;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        jedittext=(EditText)findViewById(R.id.xeditText);
        jedittext.setOnEditorActionListener(this);          //Here we have set Listener to the EditText component. And by passing 'this' here it means that
                                                            //we're saying we ll be implementing OnEditorActionListener class in MainActivity.
    }

    @Override                                                                   //We ll be returning 'true' or 'false' as this method is returning boolean type.
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event)    //Parameter 1 'v' contains the view that was clicked.
    {                                                                          //Parameter 2 'actionId' contains the imeId of the Button clicked
                                                                               //Parameter 3 is null for all other keys except 'Enter' key

        if(actionId == EditorInfo.IME_ACTION_DONE)                          //Here 'EditoInfo' is the class that contains Constants signifying the Button clicked.
        {
            Toast.makeText(this,"U clicked: Done",Toast.LENGTH_LONG).show();
            return true;
        }
        else
        {
            return false;
        }
    }
}
