package com.mad.heradatingapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class ForgetPasswordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);
    }

    public  void onHome(View v) {
        ImageButton imgbtnBack = (ImageButton) v;
        Intent in = new Intent(ForgetPasswordActivity.this, MainActivity.class);
        startActivity(in);
    }
}
