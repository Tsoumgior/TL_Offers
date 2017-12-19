package com.example.kamran.logingreentheme;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class activity_shoplogin extends AppCompatActivity {
    Button shoplogs,lin;
    TextView supp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shoplogin);
        lin = (Button) findViewById(R.id.lin);
        shoplogs = (Button) findViewById(R.id.shoplogs);
        shoplogs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sp = new Intent(activity_shoplogin.this,login.class);
                startActivity(sp);
            }
        });
       supp = (TextView) findViewById(R.id.supp);
       supp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent bc = new Intent(activity_shoplogin.this,signup.class);
                startActivity(bc);
            }
        });
       lin.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent cp = new Intent(activity_shoplogin.this,controlpanelshop.class);
               startActivity(cp);
           }
       });
    }
}
