package com.example.brahmpreetsingh.sn_txtwtchredittxtv73;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements TextWatcher {                                                        //'TextWatcher' class being implemented

    TextView jtv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        jtv1 = (TextView) findViewById(R.id.xtv1);                                                                          //Reference to EditText created
        jtv1.addTextChangedListener(this);                                                                                  //Listener assigned to 'jtv1'
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        Toast.makeText(this, "Before text change", Toast.LENGTH_LONG);
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        Toast.makeText(this, "On text change", Toast.LENGTH_LONG);
    }

    @Override
    public void afterTextChanged(Editable s) {                                          //Here object 's' contains the value passed by user to EditText ie jtv1
        try                                                                                             //We've used try here as there can be chance that textfield is empty in that case
        {                                                                                               //if we'll use parseInt coversion it will throw 'NumberFormatException' error.
            int number = Integer.parseInt(s.toString());
            if (number >= 101) {
                s.replace(0, s.length(), "100");                        //Here we've specified the initial final position of text to be replaced
            }                                                           //by "100"
        }
        catch (NumberFormatException e) {}


    }
}
