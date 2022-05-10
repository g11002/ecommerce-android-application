package com.rajendra.onlinedailygroceries;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUp extends AppCompatActivity {

    EditText rname, rusername, remailid, rphoneno, rpassword;
    Button btn;
    FirebaseDatabase rootNode;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        rname = findViewById(R.id.name);
        rusername = findViewById(R.id.username);
        remailid = findViewById(R.id.em);
        rphoneno = findViewById(R.id.phoneno);
        rpassword = findViewById(R.id.pd);
        btn = findViewById(R.id.sign);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rootNode = FirebaseDatabase.getInstance();
                reference = rootNode.getReference("users");

                // get all the values
                String name = rname.getText().toString();
                String username = rusername.getText().toString();
                String email = remailid.getText().toString();
                String phoneno = rphoneno.getText().toString();
                String password = rpassword.getText().toString();

                UserHelperClass helperClass = new UserHelperClass(name,username,email,phoneno,password);
                reference.child(phoneno).setValue(helperClass);

                Intent intent2 = new Intent(SignUp.this,UserProfile.class);
                intent2.putExtra("name",name);
                intent2.putExtra("username",username);
                intent2.putExtra("email",email);
                intent2.putExtra("phoneno",phoneno);
                intent2.putExtra("password",password );
                startActivity(intent2);
            }
        });

    }
}