package com.mad.heradatingapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity {
    EditText txtName, txtAge;
    Button btnSignup;
    DatabaseReference reff;
    Profile member;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        reff = FirebaseDatabase.getInstance().getReference().child("Member");
        txtName = (EditText)findViewById(R.id.etUsername);
        txtAge = (EditText)findViewById(R.id.etAge);
        btnSignup = (Button)findViewById(R.id.btnSignup);
        member = new Profile();
        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int age = Integer.parseInt(txtAge.getText().toString().trim());
                member.setName(txtName.getText().toString().trim());
                member.setAge(age);

                reff.push().setValue(member);
                Toast.makeText(RegisterActivity.this,"data inserted",Toast.LENGTH_LONG).show();
            }
        });
    }

    public void onLogin(View v){
        Button btnSignup = (Button)v;
        Intent in = new Intent(RegisterActivity.this, LoginActivity.class);
        startActivity(in);
    }

    public  void onHome(View v) {
        ImageButton imgbtnBack = (ImageButton) v;
        Intent in = new Intent(RegisterActivity.this, MainActivity.class);
        startActivity(in);
    }
}
