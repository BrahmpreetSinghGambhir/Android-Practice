package com.example.brahmpreetsingh.sn_rlayoutjavav57to62;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;


//Relative LAyout made through Java (Video 57 to 62)

public class MainActivity extends AppCompatActivity {
    //References created
    RelativeLayout rl;
    TextView message,username,password;
    EditText usernamevalue , passwordvalue;
    Button loginbutton;
    RelativeLayout.LayoutParams UsernameDimension;
    RelativeLayout.LayoutParams UserValueDimension;
    RelativeLayout.LayoutParams PasswordDimension;
    RelativeLayout.LayoutParams PassvalueDimension;
    RelativeLayout.LayoutParams ButtonDimension;
    RelativeLayout.LayoutParams MessageDimension;





    //We also need to give ids to all the views (ids are always in integer value)
    int usernameId, passwordId , usernamevalueId , passwordvalueId , loginbuttonId , messageId;
    //So we've given ids to variables with which we can refer them



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Methods called

        init();
        messageTextView();
        userTextView();
        userValueEditText();
        passwordTextView();
        passValueEditText();
        button();

        //Views are being added to Layout by passing 'View's name' & 'Dimension variable' applied to it respectively

        rl.addView(message,MessageDimension);
        rl.addView(username,UsernameDimension);
        rl.addView(usernamevalue,UserValueDimension);
        rl.addView(password,PasswordDimension);
        rl.addView(passwordvalue,PassvalueDimension);
        rl.addView(loginbutton,ButtonDimension);

        // View set to be displayed.
        setContentView(rl);
        }

    public void init()
    {
        //Step 1
        rl=new RelativeLayout(this);
        RelativeLayout.LayoutParams LinearLayoutDimension=new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        rl.setLayoutParams(LinearLayoutDimension);

        message=new TextView(this);
        username=new TextView(this);
        password=new TextView(this);

        usernamevalue=new EditText(this);
        passwordvalue=new EditText(this);

        loginbutton=new Button(this);
    }

    public void messageTextView()
    {
        MessageDimension=new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        MessageDimension.addRule(RelativeLayout.ALIGN_PARENT_LEFT);                                                             //Step 3 (Rule applied)
        message.setLayoutParams(MessageDimension);
        message.setId(messageId=1);                                                                                              //Dont know why this was not working (Ids)
        message.setText("Please Login first");

    }

    public void userTextView()
    {
        UsernameDimension=new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        UsernameDimension.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        UsernameDimension.addRule(RelativeLayout.BELOW,messageId);
        username.setLayoutParams(UsernameDimension);                                                                   //'Dimension variable' passed to 'View'
        username.setPadding(30,30,30,30);
        username.setText("Username: ");
        username.setId(usernameId=2);
    }

    public void userValueEditText()
    {
        UserValueDimension=new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        UserValueDimension.addRule(RelativeLayout.RIGHT_OF,usernameId);

        usernamevalue.setLayoutParams(UserValueDimension);
        username.setPadding(30,30,30,30);
        usernamevalue.setId(usernamevalueId=3);

    }

    public void passwordTextView()
    {
        PasswordDimension=new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        PasswordDimension.addRule(RelativeLayout.BELOW,usernameId);
        password.setLayoutParams(PasswordDimension);
        password.setText("Password: ");
        password.setId(passwordId=4);

    }

    public void passValueEditText()
    {
        PassvalueDimension=new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        PassvalueDimension.addRule(RelativeLayout.RIGHT_OF,passwordId);
        PassvalueDimension.addRule(RelativeLayout.BELOW,usernamevalueId);

        passwordvalue.setLayoutParams(PassvalueDimension);
        passwordvalue.setId(passwordvalueId=5);
    }

    public void button()
    {
        ButtonDimension=new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        ButtonDimension.addRule(RelativeLayout.BELOW,passwordvalueId);
        loginbutton.setPadding(20,20,20,20);
        loginbutton.setLayoutParams(ButtonDimension);
        loginbutton.setText("Click me!");
        loginbutton.setId(loginbuttonId=6);
    }

}
