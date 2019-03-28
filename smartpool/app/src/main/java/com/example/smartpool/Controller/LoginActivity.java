package com.example.smartpool.Controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.smartpool.Data.Database;
import com.example.smartpool.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    Button bLogin;
    EditText etUsername, etPassword;
    TextView tvRegisterLink;
    private Database db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitivity_login);


        etUsername = (EditText) findViewById(R.id.etUsername);
        etPassword = (EditText) findViewById(R.id.etPassword);
        tvRegisterLink = (TextView) findViewById(R.id.tvRegisterLink);
        bLogin = (Button) findViewById(R.id.bLogin);

        bLogin.setOnClickListener(this );
        tvRegisterLink.setOnClickListener(this);



    }

    @Override
    public void onClick(View v){
        String gebruikersnaam = etUsername.getText().toString();
        String wachtwoord = etPassword.getText().toString();
        Boolean Chkgebruikerwachtwoord = db.gebruikerwachtwoord(gebruikersnaam,wachtwoord);
        if(Chkgebruikerwachtwoord==true)
            startActivity(new Intent(LoginActivity.this, MainActivity.class));

        else
            Toast.makeText(getApplicationContext(),"wrong email or password", Toast.LENGTH_SHORT).show();
        }
    }


