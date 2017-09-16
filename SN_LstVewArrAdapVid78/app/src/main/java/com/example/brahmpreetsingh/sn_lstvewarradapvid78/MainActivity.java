package com.example.brahmpreetsingh.sn_lstvewarradapvid78;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    //Step 1
    String[] days={"Sunday","Monday","Tuesday","Wednesday","Thrusday","Friday","Saturday"};                 //Data defined
    ListView jlistview;                                                                                     //Reference of ListView created.

    //Step 4
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id)                        //Here 'parent' parameter contains 'jlistView''s content
    {                                                                                                       //'view' parameter contains 'TextView' ie Row which was clicked
                                                                                                            //'position' signifies which row was clicked ie index of row
                                                                                                            //'id' ie id of TextView that was generated (Least important)
        TextView temp=(TextView) view;
        Toast.makeText(this,temp.getText()+""+position,Toast.LENGTH_LONG).show();
        //Toast.makeText(this,((TextView) view).getText()+""+position,Toast.LENGTH_LONG).show();    ------------>    is also right
    }


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        jlistview=(ListView)findViewById(R.id.xlistView);

        //Step 2
        ArrayAdapter<String> adapter123 = new ArrayAdapter<String>(this    , android.R.layout.simple_list_item_1 ,    days);    //Here the second parameter we've used is a predefined layout
                                                                                                                                //that can be used to define how a single row should be displayed.
                                                                                                                                //There are hundereds of these. We can use any or custom
                                                                                                                                //definition can also be used.
        //Step 3
        jlistview.setAdapter(adapter123);                         //'adapter123' set to object of ListView's object 'jlistview' using method 'setAdapter()'
        //Step 5
        jlistview.setOnItemClickListener(this);                  //Here we've called the 'onItemClick()' method indirectly by passing 'this' and thereby have set the listener to items in List.
    }
}