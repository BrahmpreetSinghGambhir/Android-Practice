package com.example.brahmpreetsingh.sn_swipetabv141_142;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity implements ActionBar.TabListener {      //Here we're implementing TabListener class to customise it.

    ActionBar actionbar123;                                                                 //Reference to ActionBar created.
    ViewPager jviewpager;                                                                   //Reference to ViewPager created.


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*********************************************************ViewPager Part************************************************************************************/
        //Step 1 : Setup ViewPager
        jviewpager=(ViewPager)findViewById(R.id.xviewpager);                    //ViewPager objectified
        FragmentManager manager123 = getSupportFragmentManager();               //FragmenManager object obtained
        jviewpager.setAdapter(new MyAdapter(manager123));                       //Adapter set on ViewPager's object


        //Step 4: Monitor ViewPager changes (This method is used by ViewPager to monitor changes)
        jviewpager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels)            //2nd paloat value stays b/w 0 & 1 always
            {
                Log.d("Brahm","OnPageScroll at Page:"+position+"with float value:"+positionOffset+" & positionOffsetPixels = "+positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position)                               //This is the most important method that will help us link ActionBar & ViewPager
            {                                                                      //as this is the only method that is telling us that Where ViewPager is pointing.
                Log.d("Brahm","Page no. selected is: "+position);

                //Step 5(a) - Making ActionBar change as per position in ViewPager.
                actionbar123.setSelectedNavigationItem(position);
            }

            @Override
            public void onPageScrollStateChanged(int state)
            {
                if(state==ViewPager.SCROLL_STATE_IDLE)
                {
                    Log.d("Brahm","onScrollStateChanged = IDLE");
                }
                if (state==ViewPager.SCROLL_STATE_DRAGGING)
                {
                    Log.d("Brahm","onScrollStateChanged = DRAGGING");
                }
                if(state==ViewPager.SCROLL_STATE_SETTLING)
                {
                    Log.d("Brahm","onScrollStateChanged = SETTLING");
                }
            }
        });

        /************************************************************************************************************************************************************/



        /*********************************************************ActionBar Part************************************************************************************/
        //Step 2: Setup ActionBar
        actionbar123=getSupportActionBar();                                      //ActionBar objectified.
        actionbar123.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);          //NavigationMode set to ActionBar object (letting object know that tabs shall be added)


        ActionBar.Tab tab1 = actionbar123.newTab();                             //'Tab 1' objectified using 'newTab()' method
        tab1.setText("Tab 1");                                                  //Text set to object of tab i.e Tab1
        tab1.setTabListener(this);                                              //TabListener set to 'Tab1' object i.e. object of 'Tab 1'

        ActionBar.Tab tab2 = actionbar123.newTab();                              //'Tab 2' objectified using 'newTab()' method
        tab2.setText("Tab 2");                                                   //Text set to object of tab i.e. Tab2
        tab2.setTabListener(this);                                               //TabListener set to 'Tab2' object i.e. object of 'Tab 2'

        ActionBar.Tab tab3 = actionbar123.newTab();                              //'Tab 3' objectified using 'newTab()' method
        tab3.setText("Tab 3");                                                   //Text set to object of tab i.e. Tab3
        tab3.setTabListener(this);                                               //TabListener set to 'Tab3' object i.e. object of 'Tab 3'


        //Tab objects added to object of ActionBar i.e. actionbar123 using 'addTab()' method
        actionbar123.addTab(tab1);
        actionbar123.addTab(tab2);
        actionbar123.addTab(tab3);
        /************************************************************************************************************************************************************/

    }




    /*********************************************************ActionBar Part************************************************************************************/
    //Step 3 : Monitor Tab Changes
    // 3 methods for implementing 'ActionBar.TabListener' implemented
    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {                 //Most Important method to make ViewPager change as per position
        Log.d("Brahm","onTabSelected at"+tab.getPosition()+" & name = "+tab.getText() );

        //Step 5(b) - MAking ViewPAger change as per position in ActionBar
        jviewpager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {
        Log.d("Brahm","onTabUnselected at"+tab.getPosition()+" & name = "+tab.getText() );
    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {
        Log.d("Brahm","onTabReSelected at "+tab.getPosition()+" & name = "+tab.getText());
    }
    /************************************************************************************************************************************************************/
}





/*****************************************************************ViewPager Part************************************************************************************/
//Part of Step1
//Adapter to be applied on ViewPager's object defined.
class MyAdapter extends FragmentPagerAdapter               //We're extending FragmentPagerAdapter to customise it as per our requirement
{

    // Methods (including 1 constructor) required to implement FragmentPagerAdapter defined.

    public MyAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment f = null;
        if(position==0)
        {
            f= new FragmentA();
            return f;
        }
        else if(position==1)
        {
            f= new FragmentB();
            return f;
        }
        else if (position==2)
        {
            f= new FragmentC();
            return f;
        }
        else
        {
            return null;
        }


    }

    @Override
    public int getCount() {
        return 3;
    }
}
/**********************************************************************************************************************************************************************/