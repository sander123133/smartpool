package com.example.smartpool.Controller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.smartpool.R;
import com.example.smartpool.Domain.Medewerkerinfo;


public class Register extends AppCompatActivity implements View.OnClickListener {

    Button bRegister;
    EditText etFNaam, etTlfnmr, etWoonplaats, etBedrijf, etGebruikersnaam, etWachtwoord;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etFNaam = (EditText) findViewById(R.id.etFNaam);

        etTlfnmr = (EditText) findViewById(R.id.etTlfnmr);
        etWoonplaats = (EditText) findViewById(R.id.etWoonplaats);
        etBedrijf = (EditText) findViewById(R.id.etBedrijf);
        etGebruikersnaam = (EditText) findViewById(R.id.etGebruikNaam);
        etWachtwoord = (EditText) findViewById(R.id.etWachtwoord);
        bRegister = (Button) findViewById(R.id.bRegister);

        bRegister.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.bRegister:



                etFNaam.setText(Medewerkerinfo.getNaam());
                etTlfnmr.setText("Telefoonnummer: " + Double.toString(Medewerkerinfo.getTelefoonnumer()));
                etWoonplaats.setText(Medewerkerinfo.getWoonplaats());
                etBedrijf.setText(Medewerkerinfo.getBedrijfnaam());
                etGebruikersnaam.setText(Medewerkerinfo.getGebruikersnaam());
                etWachtwoord.setText(Medewerkerinfo.getWachtwoord());







               


                break;

        }
    }
}
