package com.mad.heradatingapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class NavigationActivity extends AppCompatActivity {

    private DrawerLayout dl;
    private ActionBarDrawerToggle abdt;
    private NavigationView nv;
    private Toolbar toolbar;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        dl = (DrawerLayout)findViewById(R.id.dl);
        abdt = new ActionBarDrawerToggle(NavigationActivity.this, dl,R.string.Open, R.string.Close);
        nv = findViewById(R.id.nv);
        abdt.setDrawerIndicatorEnabled(true);
        toolbar = findViewById(R.id.toolbar);

        dl.addDrawerListener(abdt);
        abdt.syncState();

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        nv = (NavigationView)findViewById(R.id.nv);
        nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();

                switch (id)
                {
                    case R.id.home:
                        Toast.makeText(NavigationActivity.this, "Home", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.chat:
                        Toast.makeText(NavigationActivity.this, "My Messages", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.matches:
                        Toast.makeText(NavigationActivity.this, "My matches", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.things_to_do:
                        Toast.makeText(NavigationActivity.this, "Things to do", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.settings:
                        Toast.makeText(NavigationActivity.this, "Settings", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.signOut:
                        mAuth = FirebaseAuth.getInstance();
                        mAuth.signOut();
                        Intent in = new Intent(NavigationActivity.this,MainActivity.class);
                        startActivity(in);
                        Toast.makeText(NavigationActivity.this, "Signed Out!", Toast.LENGTH_SHORT).show();
                        break;
                }

                return true;
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (abdt.onOptionsItemSelected(item)){
            return true;
        }else{
            return super.onOptionsItemSelected(item);
        }
    }
}
