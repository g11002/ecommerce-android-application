package com.rajendra.onlinedailygroceries;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

public class UserProfile extends AppCompatActivity {

    TextView pname, pusname, psusname, pemail, pphone, ppassword;
    Button bok;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        pname = findViewById(R.id.nam);
        pusname = findViewById(R.id.us);
        pemail = findViewById(R.id.ema);
        pphone = findViewById(R.id.ph);
        ppassword = findViewById(R.id.pass);
        bok = findViewById(R.id.btnok);
        psusname =findViewById(R.id.sus);

        String a = getIntent().getStringExtra("name");
        String b = getIntent().getStringExtra("username");
        String c = getIntent().getStringExtra("email");
        String d = getIntent().getStringExtra("phoneno");
        String e = getIntent().getStringExtra("password");

        pname.setText(a);
        pusname.setText(b);
        pemail.setText(c);
        pphone.setText(d);
        ppassword.setText(e);
        psusname.setText(b);

        bok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserProfile.this,MainActivity1.class);
                startActivity(intent);
            }
        });

    }
}