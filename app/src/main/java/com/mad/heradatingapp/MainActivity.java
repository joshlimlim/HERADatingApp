package com.mad.heradatingapp;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
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

    public void onLogin(View v){
        Button btnLogin = (Button)v;
        Intent in = new Intent(MainActivity.this,LoginActivity.class);
        startActivity(in);
    }
}
