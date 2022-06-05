package com.prerana.signupandloginlab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    EditText emailedt,passwordedt;
    Button signupbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        emailedt=findViewById(R.id.editTextTextPersonName5);
        passwordedt=findViewById(R.id.editTextTextPersonName6);
        signupbtn=findViewById(R.id.button3);
        signupbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = emailedt.getText().toString();
                String passwrod = passwordedt.getText().toString();
                if(!isValidPassword(passwrod)){
                    Toast.makeText(MainActivity.this, "Password does not match the rule", Toast.LENGTH_LONG).show();
                    return;
                }
                Intent intent=new Intent(MainActivity.this,LoginActivity.class);
                intent.putExtra("email",email);
                intent.putExtra("password",passwrod);
                startActivity(intent);
            }
        });
    }
    Pattern lowcase=Pattern.compile("^.*[a-z].*$");
    Pattern uppercase=Pattern.compile("^.*[A-Z].*$");
    Pattern number=Pattern.compile("^.*[0-9].*$");
    Pattern specialCharecter=Pattern.compile("^.*[a-zA-Z0-9].*$");
    private Boolean isValidPassword(String password){
        if (password.length()<8){
            return false;
        }
        if(!lowcase.matcher(password).matches()){
            return false;
        }
        if(!uppercase.matcher(password).matches()){
            return false;
        }
        if (!number.matcher(password).matches()){
            return false;

        }if (!specialCharecter.matcher(password).matches()){
            return false;
        }
        return true;
    }
}