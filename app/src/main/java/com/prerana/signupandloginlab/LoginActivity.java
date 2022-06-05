package com.prerana.signupandloginlab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText emailedt,passwordedt;
    Button loginbtn;
    int counter=2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        emailedt=findViewById(R.id.editTextTextPersonName);
        passwordedt=findViewById(R.id.editTextTextPersonName2);
        loginbtn=findViewById(R.id.button);
        String registeredemail=getIntent().getStringExtra("email");
        String registerdpassword=getIntent().getStringExtra("password");
        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email=emailedt.getText().toString();
                String password=passwordedt.getText().toString();
                if(registeredemail.equals(email)&&registerdpassword.equals(password)){
                    Intent intent=new Intent(LoginActivity.this,LoginSuccesActivity.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(LoginActivity.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                }
                counter--;
                if(counter==0){
                    Toast.makeText(LoginActivity.this, "FAILED LOGIN ATTEMPTS", Toast.LENGTH_SHORT).show();
                    loginbtn.setEnabled(false);
                }


            }
        });
    }
}