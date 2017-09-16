package com.example.brahmpreetsingh.sn_scrolltabv137;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends FragmentActivity            //Here we've extended 'FragmentActivity' so that this program shall run on or before Honeycomb
{
    ViewPager jviewpager=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        jviewpager=(ViewPager)findViewById(R.id.xviewpager);                    //Reference to ViewPager objectified.

        FragmentManager manager123=getSupportFragmentManager();                 //We're creating object of FragmentManager via getSupportFragmentManager()
                                                                                //as its a special method to get manager for Fragments that come from
                                                                                //'android.support.v4.app.Fragment' and we'll need this object at the time of
                                                                                // setting adapter to ViewPager object i.e jviewpager

        jviewpager.setAdapter(new MyAdapter(manager123));                       //Here we've set Adapter to object of ViewPager, and to adapter object we've
                                                                                //applied the 'manager123' i.e object of FragmentManager class. (NEW concept)
                                                                                //MAIN REASON : Constructor 'MyAlert()' needs 'FragmentManager' object
    }












    //We have customised the 'FragmentPAgerAdapter' by extending it in the User-defined class ad overriding its methods
    class MyAdapter extends FragmentPagerAdapter                                          //class MyAdapter extends FragmentStatePagerAdapter
    {

                                        //Here we're overidng 3 methods that are required to customise 'FragmetPagerAdapter'



        //While implementing FragmentPageAdapter, it is must to implement its constructor
        public MyAdapter(FragmentManager fm) {
            super(fm);
        }



        //This method will tell the position input by user to manager's object I believe
        @Override
        public Fragment getItem(int position)
        {
            android.support.v4.app.Fragment f = null;

            //Here we're checking which position we're getting from manager i guess, as to adapter. we will be passing object of manager (FragmentSupportManager) only
            //while setting adapter to ViewPager object under 'onCreate()' method.
            if(position==0)
            {
                f=new FragmentA();
            }
            else if(position==1)
            {
                f=new FragmentB();
            }
            else if(position==2)
            {
                f=new FragmentC();
            }

            return f;                                                 //As per the condition satisfaction, respective Fragment will be returned and displayed.
        }




        //This method will help adapter know the number of tabs (Fragments) we have
        @Override
        public int getCount() {
            return 3;
        }



        //This method is here to (return) set text to Fragment/Tab title as per position
        @Override
        public CharSequence getPageTitle(int position) {

            if(position==0)
            {
                return "tab1";
            }
            else if(position==1)
            {
                return "tab2";
            }
            else if (position==2)
            {
                return "tab3";
            }
            else
            {

                return null;
            }
        }
    }


}
