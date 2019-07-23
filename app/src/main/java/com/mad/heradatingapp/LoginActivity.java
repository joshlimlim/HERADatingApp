package com.mad.heradatingapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void onSignup(View v){
        Button btnSignup = (Button)v;
        Intent in = new Intent(LoginActivity.this, RegisterActivity.class);
        startActivity(in);
    }

    public void onForgetPassword(View v){
        Button btnForgetPassword = (Button)v;
        Intent in = new Intent(LoginActivity.this, ForgetPasswordActivity.class);
        startActivity(in);
    }

    public  void onHome(View v) {
        ImageButton imgbtnBack = (ImageButton) v;
        Intent in = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(in);
    }
}
