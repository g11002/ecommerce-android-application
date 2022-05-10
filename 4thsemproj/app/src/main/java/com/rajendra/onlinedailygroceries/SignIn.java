package com.rajendra.onlinedailygroceries;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class SignIn extends AppCompatActivity {
    EditText susername, spasswd;
    Button sign;
//    FirebaseDatabase rootNode;
//    DatabaseReference reference;
//    String nameFromDB, usernameFromDB,phoneNoFromDB,emailFromDB,passwordFromDB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        susername = findViewById(R.id.username);
        spasswd = findViewById(R.id.pd);
        sign = findViewById(R.id.sign);

        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                if(!validateUsername() | !validatePassword()) {
//                    return ;
//                }else {
//                    isUser();
//                }
                Intent intent1 = new Intent(SignIn.this,MainActivity1.class);
//                intent1.putExtra("name",nameFromDB);
//                intent1.putExtra("username",usernameFromDB);
//                intent1.putExtra("email",emailFromDB);
//                intent1.putExtra("phoneno",phoneNoFromDB);
//                intent1.putExtra("password",passwordFromDB);
                startActivity(intent1);
            }
        });
    }

    private boolean validateUsername() {
        String val = susername.getText().toString();
        if(val.isEmpty()) {
            susername.setError("Field cannot be Empty");
            return false;
        } else {
            susername.setError(null);
            susername.setEnabled(false);
            return true;
        }
    }

    private boolean validatePassword() {
        String val = spasswd.getText().toString();

        if(val.isEmpty()) {
            susername.setError("Field cannot be Empty");
            return false;
        } else {
            susername.setError(null);
            susername.setEnabled(false);
            return true;
        }
    }

    public void loginUser(View view) {
        //validate login Info
        if(!validateUsername() | !validatePassword()) {
            return ;
        }else {
            isUser();
        }
    }

    private void isUser() {
        final String userEnteredUsername = susername.getText().toString().trim();
        final String userEnteredPassword = spasswd.getText().toString().trim();

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("users");
        Query checkUser = reference.orderByChild("username").equalTo(userEnteredUsername);

        checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {

                if (datasnapshot.exists()) {

                    susername.setError(null);
                    //susername.setErrorEnabled(false);
                    susername.setError("false");

                    String passwordFromDB = datasnapshot.child(userEnteredUsername).child("password").getValue(String.class);

                    if(passwordFromDB.equals(userEnteredPassword)) {

                        susername.setError(null);
                        susername.setError("false");

                        String nameFromDB = datasnapshot.child(userEnteredUsername).child("name").getValue(String.class);
                        String usernameFromDB = datasnapshot.child(userEnteredUsername).child("username").getValue(String.class);
                        String phoneNoFromDB = datasnapshot.child(userEnteredUsername).child("phoneno").getValue(String.class);
                        String emailFromDB = datasnapshot.child(userEnteredUsername).child("email").getValue(String.class);

                        Intent intent = new Intent(getApplicationContext(), UserProfile.class);
                        intent.putExtra("name",nameFromDB);
                        intent.putExtra("username",usernameFromDB);
                        intent.putExtra("email",emailFromDB);
                        intent.putExtra("phoneno",phoneNoFromDB);
                        intent.putExtra("password",passwordFromDB);

                        startActivity(intent);
                    } else{
                        spasswd.setError("Wrong Password");
                    }
                } else {
                    susername.setError("No such user Exist!");
                    susername.requestFocus();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

}