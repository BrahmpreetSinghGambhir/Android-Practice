package com.example.brahmpreetsingh.sn_spinnervid104;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner jspinner;

    /*
    Step 1 : Create the data source
    Step 2: Define the appearance layout file through which adapter will put data inside spinner (appearance of dropdown)
    Step 3: Define what to do when user clicks on the spinner using the 'OnItemSelectedListener' implementation
    */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        jspinner=(Spinner)findViewById(R.id.xspinner);

        ArrayAdapter adapter123 = ArrayAdapter.createFromResource(this,R.array.days,android.R.layout.simple_spinner_item); // 'days' array defined in Strings.xml
        jspinner.setAdapter(adapter123);
        jspinner.setOnItemSelectedListener(this);
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {      // The View (2nd parameter) that is coming here,
                                                                                               // contains 'LinearLayout' and 'TextView' present in
                                                                                               // row of Spinner ie 'Sub view' thats being clicked.

        TextView mytext = (TextView)view;                                                      //Typecasting performed (View converted to TextView).
        Toast.makeText(this,"You selected: "+mytext.getText(),Toast.LENGTH_LONG).show();


    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
