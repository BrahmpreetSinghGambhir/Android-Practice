package com.example.brahmpreetsingh.sn_navgndrawrv144;

                                                                        //Video 144 to 146

import android.content.res.Configuration;
import android.os.PersistableBundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity implements AdapterView.OnItemClickListener{

    private ListView jlistview;
    private DrawerLayout jdrawerlayout;
    String[] planets;
    private android.support.v4.app.ActionBarDrawerToggle DrawerListenerObj1;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Step 1
        jlistview=(ListView)findViewById(R.id.xlistview);
        jdrawerlayout=(DrawerLayout)findViewById(R.id.xdrawerlayout);
        planets=getResources().getStringArray(R.array.Planets);

        //Step 2
        jlistview.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,planets));

        //Step 3
        jlistview.setOnItemClickListener(this);




        // Step 5
        //Here 'DrawerListenerobj1'is object of class ÁctionBarDrawerToggle
        DrawerListenerObj1 = new android.support.v4.app.ActionBarDrawerToggle(this,jdrawerlayout,R.drawable.ic_drawer,R.string.drawer_open,R.string.drawer_close)
        {
            //Here we made inner class so that we could implement the 2 methods that are required to be implemented. By objectifying class,
            // we got object of DrawerListener too and thus we can override 2 methods of DrawerListener too. This is what we're doing here.
            //( This is how we override the methods contained in an interface in a class, which is implementing that interface )

            @Override
            public void onDrawerClosed(View drawerView)
            {
                Toast.makeText(MainActivity.this,"drawer closed",Toast.LENGTH_LONG).show();                     //'MainActivity.this' as we're working in inner class
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                Toast.makeText(MainActivity.this,"drawer opened",Toast.LENGTH_LONG).show();
            }
        };



        //Step 4
        //Here we're telling 'jdrawerlayout' that 'Drawerlistenerobj1' is the object that will respond when slider will be opened or clossed.
        jdrawerlayout.setDrawerListener(DrawerListenerObj1);




        //ActionBar design code
        getSupportActionBar().setHomeButtonEnabled(true);                      //This will make the title (Options to be precise) of the actionBar clickable.
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);                 //This will bring an arrow icon '<-' adjacaent to ActionBar logo
                                                                               //By which we can go back to our home screen i believe
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_drawer);      //This is another way to bring 3 horizontal lines to ActionBar
    }





    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id)
    {
        Toast.makeText(this,planets[position]+" was selected",Toast.LENGTH_LONG).show();
        uSelectItem(position);                                                          // Here we're passing position value to 'uSelectItem()' defined below
    }






    // This method was created just to define how UI will look like when any item will be selected. Morover in this method itself we're calling 'setttTitle()'
    public void uSelectItem(int position)
    {
        jlistview.setItemChecked(position,true);                                //Optional - This will make the item selected for a while.
        uSetttTitle(planets[position]);                                         //Here we're passing the planet's name to 'setttTitle()' method.

        // setTitle(planets[position]);                                    //This alone is also enough to setTitle i believe as setTitle() is an inbuilt method
    }






    //This method was created just to setTitle to ActionBar
    public void uSetttTitle(String title)
    {
        getSupportActionBar().setTitle(title);                                  //Here we're setting the text to title of ActionBar.
    }





    //This method is just to maximize three lines icon when drawer is closed and minify the three lines icon when slider(Drawer) is opened.
    @Override
    public void onPostCreate(Bundle savedInstanceState, PersistableBundle persistentState)
    {
        DrawerListenerObj1.syncState();
    }



    //This method is simply responsible for poping out slider when 'title' of ActionBar will be clicked.
    //onOptionItemSelected() method doesnt directly work with navigation drawer and here we're forwarding the CLICK EVENT to DrawerListener's object.
    // (Whenever any item will be clicked on ActionBar, the first method that will be called is 'onOptionsItemSelected()' method.
    // & the first thing that is to be done is forward the CLICK EVENT to 'drawerlistenerobj1')
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        if(DrawerListenerObj1.onOptionsItemSelected(item))
        {
            return true;                             //Here 'return true' means this event that we forwarded was sucessfuly handled by 'DrawerListenerobj1'
        }
        return super.onOptionsItemSelected(item);           //This is to be done if 'DrawerListenerobj1' couldnt handle 'onOptionsItemSelected()'

    }




    //In this method too, we are forwarding the event to 'DrawerListenerObj1' i.e if configuration gets changed i.e. orientation,
    //the info will be forwarded to 'DrawListenerObj1' ie 'onConfigurationChanged()' method will be applied to 'DrawerListenerObj1'
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        DrawerListenerObj1.onConfigurationChanged(newConfig);           //Passing 'newConfig' parameter to DrawerListener's object and thereby making the object
                                                                        // handle the new configuration (Passing event forward)
    }
}
