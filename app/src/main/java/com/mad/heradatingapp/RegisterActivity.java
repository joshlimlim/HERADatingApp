package com.mad.heradatingapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class RegisterActivity extends AppCompatActivity {
    EditText txtName, txtAge, txtEmail, txtPassword;
    Button btnSignup;
    Profile member;
    RadioGroup mradioGroup;

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener firebaseAuthStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        mAuth = FirebaseAuth.getInstance();
        firebaseAuthStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                if (user != null){
                    Intent in = new Intent(RegisterActivity.this, NavigationActivity.class);
                    startActivity(in);
                    finish();
                    return;
                }
            }
        };
        //reff = FirebaseDatabase.getInstance().getReference().child("Member");
        txtName = (EditText)findViewById(R.id.etUsername);
        txtAge = (EditText)findViewById(R.id.etAge);
        txtEmail = (EditText)findViewById(R.id.etEmail);
        txtPassword = (EditText)findViewById(R.id.etPassword);
        btnSignup = (Button)findViewById(R.id.btnSignup);
        mradioGroup = (RadioGroup)findViewById(R.id.radioGroup);
        member = new Profile();
        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int age = Integer.parseInt(txtAge.getText().toString().trim());
                member.setName(txtName.getText().toString().trim());
                member.setAge(age);
                member.setEmail(txtEmail.getText().toString());
                member.setPassword(txtPassword.getText().toString());
                int selectedId = mradioGroup.getCheckedRadioButtonId();
                final RadioButton radioButton = (RadioButton) findViewById(selectedId);
                if (radioButton.getText() == null){
                    Toast.makeText(RegisterActivity.this,"Choose a gender!",Toast.LENGTH_LONG).show();
                    return;
                }else{
                    member.setGender(radioButton.getText().toString());
                }

                mAuth.createUserWithEmailAndPassword(member.getEmail(), member.getPassword()).addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (!task.isSuccessful()){
                            Toast.makeText(RegisterActivity.this,"sign up error",Toast.LENGTH_LONG).show();
                        }else{
                            String userId = mAuth.getCurrentUser().getUid();
                            DatabaseReference currentUserName = FirebaseDatabase.getInstance().getReference().child("Member").child(radioButton.getText().toString()).child(userId).child("name");
                            currentUserName.setValue(member.getName());
                            DatabaseReference currentUserEmail = FirebaseDatabase.getInstance().getReference().child("Member").child(radioButton.getText().toString()).child(userId).child("email");
                            currentUserEmail.setValue(member.getEmail());
                            DatabaseReference currentUserAge = FirebaseDatabase.getInstance().getReference().child("Member").child(radioButton.getText().toString()).child(userId).child("age");
                            currentUserAge.setValue(member.getAge());
                            DatabaseReference currentUserGender = FirebaseDatabase.getInstance().getReference().child("Member").child(radioButton.getText().toString()).child(userId).child("gender");
                            currentUserGender.setValue(member.getGender());
                            DatabaseReference currentUserPassword = FirebaseDatabase.getInstance().getReference().child("Member").child(radioButton.getText().toString()).child(userId).child("password");
                            currentUserPassword.setValue(member.getPassword());
                        }
                    }
                });

                //reff.push().setValue(member);
                //Toast.makeText(RegisterActivity.this,"data inserted",Toast.LENGTH_LONG).show();
            }
        });
    }
    @Override
    protected void onStart(){
        super.onStart();
        mAuth.addAuthStateListener(firebaseAuthStateListener);
    }

    @Override
    protected void onStop() {
        super.onStop();
        mAuth.removeAuthStateListener(firebaseAuthStateListener);
    }

    public void onHome(View v) {
        ImageButton imgbtnBack = (ImageButton) v;
        Intent in = new Intent(RegisterActivity.this, MainActivity.class);
        startActivity(in);
    }

    public void onUpload (View v){
        Button btnUpload = (Button) v;
        Intent in = new Intent(RegisterActivity.this,UploadImageActivity.class);
        startActivity(in);
    }
}
