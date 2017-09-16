package com.example.brahmpreetsingh.sn_impintntexpvid27;

import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.renderscript.Element;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.io.File;
import java.net.URI;
import java.util.ArrayList;

//Video 27,28,29,30,31

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void process(View v)                            //This method will be called whichever button of the 3 shall be clicked.
    {                                                      //Passed object 'v' will hold the information of the Button clicked.

        Intent i = null;                                     //Reference of Intent created.
        Intent chooser123=null;                              //Reference of Intent created

                                                                                  //****************1******************//

        if(v.getId()==R.id.xbutton1)                            //To launch MAP.
        {
        // Scenario 1
            //Action defined
            i = new Intent(Intent.ACTION_VIEW);             //Here we have made object of Intent by passing 'String action' to constructor of Intent.
                                                            //As we have passed the String that defines the viewing action. NExt ting we need to do is to set the longitude and altitude with
                                                            //which it shall start. i.e. define data
            //Data defined
            i.setData(Uri.parse("geo:19.076,72.8777"));     //Here we've 'setData()' method to which only passable parameter is URI. We wrote "geo" here in string
                                                            // to specify that we're passing something that are geographical coordinates ie "geo:latitude,altitude"

            startActivity(i);                               //Simply, Activity started.

            //Whichever app will be able to handle these action and Data shall start on running of this code.

        // Scenario 2
        //  chooser123=Intent.createChooser(i,"Map Launcher options");                //Here we've created a chooser and assigned it to intent "chooser123" targeting on "i"
                                                                                      //So when OS will find more than one app matching to intent "i", it shall pop up a dialog box with heading
                                                                                      //"Map Launcher options"

        //  startActivity(chooser123);                 //Replacement of startActivity(i);        //Here we've passed 'chooser123' instead of "i" as indirectly "chooser123" will refer to "i"


        }


                                                                                    //**************2***************//



        if(v.getId()==R.id.xbutton2)                                //To launch PLAY STORE
        {
        //Action defined
            i = new Intent(Intent.ACTION_VIEW);
        //Data defined
            i.setData(Uri.parse("market://details?id=com.kiloo.subwaysurf&hl=en"));           //Here "market:" is the special keyword that OS understands that we're inputing path for an app
                                                                                              //https://play.google.com/store/apps                 /details?id=com.kiloo.subwaysurf&hl=en
            chooser123 = Intent.createChooser(i,"Market options");
            startActivity(chooser123);
        }



                                                                                //******************3*****************//



        if(v.getId()==R.id.xbutton3)                                 //To send EMAIL
        {
                i = new Intent(Intent.ACTION_SEND);                                                 //Here action is "ACTION_SEND" instead of "ACTION_VIEW"
                i.setData(Uri.parse("mailto:"));                                                    //Keyword is "mailto:"

        //This is the extra information that we're going to provide to our intent. These inbuilt 3 things help us fill the email activity fields.Here we're putting things into our intent.
                i.putExtra(Intent.EXTRA_EMAIL,"photographr.brahmpreet@gmail.com");                  //"Intent.EXTRA_EMAIL" helps us specify to whom we're sending mail.
                i.putExtra(Intent.EXTRA_SUBJECT,"Hi, this was sent from my app");                   //"Intent.EXTRA_SUBJECT" helps us specify what sill be subject
                i.putExtra(Intent.EXTRA_TEXT,"Body text is short");                                 //Intent.EXTRA_TEXT" helps us specify what will be body

                i.setType("message/rfc822");                                                        //This is mandatory to setType of the Intent as without it OS wont be able to match
                                                                                                    //Intent with the activity that can handle this Intent.

                chooser123=Intent.createChooser(i,"Emailing options");
                startActivity(chooser123);
        }




                                                                                //******************4****************//

        if(v.getId()==R.id.xbutton4)                                    //To send image
        {

            i=new Intent(Intent.ACTION_SEND);
            Uri uri123 = Uri.parse("android.resource://com.example.brahmpreetsingh.sn_impintntexpvid27/mipmap/"+ R.mipmap.ic_launcher);   //Here we ware creating object of Uri by using keyword
                                                                                                                                          //"android.resource://" and setting location of image.
                                                                                                                                          //We've created this object 'uri123' to put its content
                                                                                                                                          //into EXTRA_STREAM, and thereby into intent 'i'

            i.setType("image/*");                                                                   //Here we have setType for the Intent by passing "image/*" as paarameter so that OS could
                                                                                                    //match things easily. (Without this OS can't)

            i.putExtra(Intent.EXTRA_TEXT, "Ye extra text hai");                                      //Here we have just put a text in intent like we did in email's body.
            i.putExtra(Intent.EXTRA_STREAM,uri123);                                                 //Here we have put 'uri' object in the Intent via "EXTRA_STREAM" that takes binary info.

            chooser123 = i.createChooser(i,"Sending options (Apps)");
            startActivity(chooser123);

        }



                                                                                //******************5********************//
if(v.getId()==R.id.xbutton5)                        //To send multiple images (Not working dunno why)
{
//To pass content to EXTRA_STREAM we need content only in 'Uri' type and then we will make ArrayList<uri> ie ArrayList of Uri type and thus pass it to EXTRA_STREAM.
Uri uri123 = null;
ArrayList<Uri> arraylist123=new ArrayList<>();

File PicturesFolder1 = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);            //Reference to Pictures folder created.
                                                                                                                //Here 'getExternalStoragePublicDirectory()' returns 'File' type object
                                                                                                                 //which we've saved in 'PicturesFolder1'

String[] ListOfPictures =PicturesFolder1.list();                                                                 //We got the list of Pictures names present inside folder

for(String Picture: ListOfPictures)                                                                             //We got each picture name in "Picture" variable from ListOfPictures array in loop.
{
uri123 = Uri.parse("file://"+PicturesFolder1.toString()+"/"+Picture);               //Keyword is "file://"      //Here we're retriving Complete path for image in uri123 (In loop)
arraylist123.add(uri123);                                                                                       //Here we've added uri123 into the arraylist ie arraylist123. (In LOOP)
}

            //Action definition
            i=new Intent(Intent.ACTION_SEND_MULTIPLE);
            //Data definition
            i.putExtra(Intent.EXTRA_STREAM,arraylist123);                                                       //we have put arraylist123 into EXTRA_STREAM


            i.setType("image/*");

            chooser123 = i.createChooser(i,"MultiSend options");
            startActivity(chooser123);

        }


    }
}
