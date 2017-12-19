package com.example.kamran.logingreentheme;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class login extends AppCompatActivity
{
    EditText pswd,mail;
    TextView sup;
    Button lin,shoplog;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth=FirebaseAuth.getInstance();
        shoplog = (Button) findViewById(R.id.shoplog);
        lin = (Button) findViewById(R.id.lin);
        mail = (EditText) findViewById(R.id.mail);
        pswd = (EditText) findViewById(R.id.pswrdd);
        sup = (TextView) findViewById(R.id.sup);
        Typeface custom_font = Typeface.createFromAsset(getAssets(), "fonts/LatoLight.ttf");
        Typeface custom_font1 = Typeface.createFromAsset(getAssets(), "fonts/LatoRegular.ttf");
        lin.setTypeface(custom_font1);
        sup.setTypeface(custom_font);
        mail.setTypeface(custom_font);
        pswd.setTypeface(custom_font);
        sup.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent it = new Intent(login.this, signup.class);
                startActivity(it);
            }
        });
        lin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userLogin();
            }
        });
        shoplog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sl = new Intent(login.this,activity_shoplogin.class);
                startActivity(sl);
            }
        });
    }


    private void userLogin()
    {
        String email = mail.getText().toString().trim();
        String password = pswd.getText().toString().trim();

        if(email.isEmpty())
        {
            mail.setError("Πληκτρολογήστε Email");
            mail.requestFocus();
            return;
        }

        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            mail.setError("Λάθος μορφή Email");
            mail.requestFocus();
            return;
        }

        if(password.isEmpty())
        {
            pswd.setError("Πληκτρολογήστε Κωδικό");
            pswd.requestFocus();
            return;
        }
        if(password.length()<5){
            pswd.setError("Κατώτατος αριθμός κωδικού 5 χρκ.");
            pswd.requestFocus();
            return;
        }
        mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful())
                {
                    Intent intent = new Intent(login.this,search.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(getApplicationContext(),task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}
