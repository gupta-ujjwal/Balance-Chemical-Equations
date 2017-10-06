package com.example.ujjwalgupta.chem;

import android.os.health.SystemHealthManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity
{

    RREF ob =new RREF();
    String str1,str2,str3;
    Button B1,B2;
    EditText LHS1,RHS1,EQ;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        B1=(Button)findViewById(R.id.submit);
        B2=(Button)findViewById(R.id.clear);
        LHS1=(EditText)findViewById(R.id.edit2);
        RHS1=(EditText)findViewById(R.id.edit1);
        EQ=(EditText)findViewById(R.id.edit3);
        int i=-1;


        B2.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View arg0) {
                System.exit(0);
            }
        });

        B1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0)
            {
                str1=(LHS1.getText()).toString();
                str2=(RHS1.getText()).toString();
                str3=ob.SOLVE(str1,str2);
                EQ.setText(str3);
            }
        });

    }



}
