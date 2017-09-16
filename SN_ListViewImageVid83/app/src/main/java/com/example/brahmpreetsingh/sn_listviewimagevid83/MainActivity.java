package com.example.brahmpreetsingh.sn_listviewimagevid83;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView jlistview;
    ImageView jimageview;
    TextView jtextview;

    String[] days = {"Sunday","Monday","Tuesday","Wednesday","Thrusday","Friday","Saturday"};             //Data defined

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        jlistview=(ListView)findViewById(R.id.xlistView);

        ArrayAdapter<String> adapter123 = new ArrayAdapter<String>(this,    R.layout.single_row,   R.id.xtextView,   days);  //Parameter 1 is 'this' i.e. CONTEXT
                                                                                                                             //Parameter 2 is the definition of the appearnce of HOW A ROW SHOULD LOOK
                                                                                                                             //Parameter 3 is the  definition of "ID" IN WHICH DATA SHOULD BE POPULATED
                                                                                                                             //Parameter 4 is the name of DATA CONTAINER that is to be  populated

        jlistview.setAdapter(adapter123);                                                                          //'adapter123' assigned to object of ListView i.e. 'jlistview'

    }
}
