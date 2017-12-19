package com.example.kamran.logingreentheme;

import android.app.AlertDialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class controlpanelshop extends AppCompatActivity {
    public static double lat;
    public static double lng;
    TextView locationText,shopnameText;
    Spinner categorySpnner;
    EditText numberText;
    Button saveBtn,makediscbtn;

    DatabaseReference databaseShops;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_controlpanelshop);
        databaseShops = FirebaseDatabase.getInstance().getReference("Shop");
        shopnameText = (TextView) findViewById(R.id.shopname);
        categorySpnner = (Spinner) findViewById(R.id.category);
        numberText = (EditText) findViewById(R.id.number);
        saveBtn = (Button) findViewById(R.id.save);
        locationText = (TextView) findViewById(R.id.location);
        makediscbtn = (Button) findViewById(R.id.makedisc);
        makediscbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent disc1 = new Intent(controlpanelshop.this,Discount.class);
                startActivity(disc1);
            }
        });
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addShopName();
                Intent disc = new Intent(controlpanelshop.this,Discount.class);
                startActivity(disc);
            }
        });
        locationText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mapIntent = new Intent(controlpanelshop.this, MapsActivity.class);
                startActivity(mapIntent);

                try {
                    String latString = String.valueOf(lat);
                    String lngString = String.valueOf(lng);
                    latString = latString.substring(0, latString.indexOf(".") + 2);
                    lngString = lngString.substring(0, lngString.indexOf(".") + 2);
                    String locationString = latString + ", " + lngString;
                    locationText.setText(locationString);
                } catch (Exception e) {}
            }
        });
    }
    private void addShopName(){
        String shopname = shopnameText.getText().toString().trim();
        String categories = categorySpnner.getSelectedItem().toString();
        String location = locationText.getText().toString().trim();
        String number = numberText.getText().toString().trim();
        if(!TextUtils.isEmpty(shopname)){
           String id = databaseShops.push().getKey();
           Shops shops = new Shops(id,shopname,categories,location,number);

           databaseShops.child(id).setValue(shops);
           Toast.makeText(this,"Επιτυχής εγγραφή καταστήματος",Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this,"Πληκτρολογήστε όνομα καταστήματος!",Toast.LENGTH_LONG).show();
        }
    }
}
