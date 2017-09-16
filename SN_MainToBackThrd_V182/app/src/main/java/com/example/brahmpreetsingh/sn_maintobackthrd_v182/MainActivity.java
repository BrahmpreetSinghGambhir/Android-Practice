package com.example.brahmpreetsingh.sn_maintobackthrd_v182;

                       //This code works with Handler concept & let us know how to communicate message from MAin thread to Background Thread//

        import android.app.AlertDialog;
        import android.os.Handler;
        import android.os.Looper;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.util.Log;
        import android.view.View;
        import android.widget.Button;
        import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    Button jbutton;
    SeperateThread seperateThreadObject;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        jbutton=(Button)findViewById(R.id.xbutton);

        seperateThreadObject=new SeperateThread();          //SeperateThread class instantiated.
        seperateThreadObject.start();                       //As soon as this statement will be executed, run() of 'SeperateThread' class will get executed.


    }

    public void onClick(View v)
    {
        seperateThreadObject.handler123.post(new Runnable()             //Here using object of 'SeperateThread' and handler object we are posting a message to
        {                                                               //handler of SeperateThread.
            @Override
            public void run()
            {
                //Here we are displaying in which Thread message is running
                Toast.makeText(MainActivity.this,Thread.currentThread().getName(),Toast.LENGTH_LONG).show();
            }
        });
    }


    //Background Thread (In this we have setup the basics of a thread who can have handler and looper to perform basic operations)
    public class SeperateThread extends Thread
    {
        Handler handler123;
        Looper looper123;

        SeperateThread()
        {

        }

        @Override
        public void run()
        {
            looper123.prepare();                            //This will make this thread have the privilige to have Message Queue of its own

            handler123=new Handler();                       //Handler instantiated as we need to receive nmessages in this thread and wherever Handler is instantiated
                                                            //handleMessages() can be used to receive messages.
                                                            //NOTE: By mistake if you would have instantiated Handler in Constructor of SeperateThread it would have
                                                            //been instantiated in MainThread.

            looper123.loop();                               //This will let know looper object that it has to take one message at a time while processing them
        }
    }
}
