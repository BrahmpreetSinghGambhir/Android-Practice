package com.example.brahmpreetsingh.gridviewvid97to103;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.media.Image;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener
{
    GridView jgridview;


                               /*--------------<GridView>---------------Steps to be performed------------<ListView>-------------------*/

    /*
    1. Prepare data sources [images in drawable & country names in strings.xml]
    2. Create a GridView  in XML [main layout file]
    3. Bring GridView from XML to java [to fill values]
    4. Create your adapter that extends BaseAdapter
    5. This adapter expects you to maintain an array having all the data.
    6. Fill the array inside the constructor of your adapter
        a) create a class SingleItem that contains the image ID and country name of a single item.
        b) maintain an ArrayList that stores 'SingleItem' objects.
        c) get the values of country names and image ids from drawable folder and put them inside this ArrayList
    7. Define the structure of a single block inside the GridView(single_item.xml)


    8. use the getView() method to do the following:

        A) If this is the FIRST TIME you're creating this ITEM
                a) get a new reference to the structure single_item.xml for each block in java using LayoutInflater
                b) get the ViewHolder from this reference
                c) store the ViewHolder to avoid INFLATION and FINDVIEWBYID calls again.
        B) ELSE IF YOU are RECYCLING
                a) get a reference to the  existing VIEWHOLDER which you've already stored.
        C) We need the value of current imageId for this row
                - Use the INT parameter to get the current item i d being requested.
                - Use this item id to find the current SINGLE ITEM object
                - Use this SINGLE ITEM object to find current image ID
                - Set this image ID to be the image resource of the IMAGEVIEW inside single_item.xml

     9. use the OnItemClickListener() to define what should happen when the user clicks on an ITEM
                a) get a reference to the View that was selected.
                b) get a reference to the image ID
                c) send the image ID and country name as extra arguments to an Intent
                d) create a seperate activity with THEME as DIALOG and containing an ImageView,TextView and OK button.
                e) get the extras and set the values for the ImageView and TextView
                f) use the OK button to finish the DialogActivity.
     */

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {          //Ist parameter here represents GridView
                                                                                                //2nd parameter here represents the item(Block) clicked here.
                                                                                                //3rd parameter represents the index of Block clicked.
        Intent objintent = new Intent(this,MyDialog.class);

        ViewHolder holder456=(ViewHolder)view.getTag();
        Country temp=(Country)holder456.CountryImageView.getTag();

        objintent.putExtra("countrynamekey",temp.name);
        objintent.putExtra("countryimagekey",temp.image);

        startActivity(objintent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        jgridview=(GridView)findViewById(R.id.xgridView);
        CustmAdapter adapter123 = new CustmAdapter(this);
        jgridview.setAdapter(adapter123);
        jgridview.setOnItemClickListener(this);
    }




    class Country                                                       //Class handling data. To this class (Class's constructor),
    {                                                                   //data derived in CustmAdapter class shall be passed
        String name;
        int image;
        Country(String name,int image)
        {
            this.name=name;
            this.image=image;
        }
    }


                                                    //Make sure ViewHolder class is out of CustmAdapter (Dont know why?)


    class ViewHolder                                //This class is designed to handle 'FindViewById'
    {
        ImageView CountryImageView;

        ViewHolder(View v)
        {
            CountryImageView=(ImageView)v.findViewById(R.id.ximageView);

        }

    }


    class CustmAdapter extends BaseAdapter
    {
        ArrayList<Country> list123;                                           //ArrayList that can store <Country> type objects referenced
        Context CustmAdapContxt;

        CustmAdapter(Context c)
        {
            this.CustmAdapContxt=c;

            list123=new ArrayList<>();                                        //'list123' instantiated.

            Resources res = CustmAdapContxt.getResources();                  //Object of Resources class in context to Main class created.
            String[] tempCountryNames = res.getStringArray(R.array.country_names);              //Country names retrieved from Array file
            int[] tempimages = {R.drawable.canada,R.drawable.zimbabwe,R.drawable.nigeria,R.drawable.bahamas,R.drawable.oman,R.drawable.liberia};

            for(int i=0;i<=5;i++)
            {
                list123.add(new Country(tempCountryNames[i], tempimages[i]));      //Data added to 'list123' in loop which is of <Country> type
            }                                                                  //Here we're passing retrieved data from 'country_names' and images
                                                                               //content to constructor of 'Country' class and thereby adding it to
                                                                               //the ArrayList object 'list123' using 'add()' method.
        }

        @Override
        public int getCount() {
            return list123.size();
        }

        @Override
        public Object getItem(int position) {
            return list123.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }


        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View BlockView=convertView;
            ViewHolder holder123=null;

            if(convertView==null)
            {

                LayoutInflater inflater123 = (LayoutInflater) CustmAdapContxt.getSystemService(CustmAdapContxt.LAYOUT_INFLATER_SERVICE);
                BlockView = inflater123.inflate(R.layout.single_item, parent, false);                   //This BlockView object contain the content of
                                                                                                        //'single_item.xml'
                holder123=new ViewHolder(BlockView);
                BlockView.setTag(holder123);                                            //'setTag()' method is a special method by
                                                                                        //which u can store something(ViewHolder object) in View object
            }
            else
            {
                holder123=(ViewHolder)BlockView.getTag();                               //We retrieved Information present in BlockView to 'holder123' object
            }

            Country temp = list123.get(position);                                        //Here we took List's element(object) into our Country's object temp

            holder123.CountryImageView.setImageResource(temp.image);                     //Here we are setting src to ImageView presenct in ViewHolder class

            holder123.CountryImageView.setTag(temp);                                    //This will help us later while writing onItemClick()

            return BlockView;
        }
    }
}
