package com.mad.heradatingapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this, "Firebase connection succcess", Toast.LENGTH_LONG).show();
    }

    public void onSignup(View v){
        Button btnSignup = (Button)v;
        Intent in = new Intent(MainActivity.this, RegisterActivity.class);
        startActivity(in);
    }
}
