package com.example.smartpool.Controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import com.example.smartpool.Data.Database;
import com.example.smartpool.Domain.AutoInfo;
import com.example.smartpool.Domain.Carpoolcategorie;
import com.example.smartpool.Domain.Medewerkerinfo;
import com.example.smartpool.Domain.RitAanmelding;
import com.example.smartpool.Domain.RitInfo;
import com.example.smartpool.R;

public class AddActivity extends AppCompatActivity {

    private Database db;
    private String gebruikersnaam;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_main);
        final Button btnSave = findViewById(R.id.btnSave);
        Bundle extras = getIntent().getExtras();
        gebruikersnaam = extras.getString("Gebruikersnaam");

        db = new Database(this);

        btnSave.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                EditText etOpstap = findViewById(R.id.etOpstap);
                EditText etEind = findViewById(R.id.etEind);
                EditText etDatum = findViewById(R.id.etDatum);
                EditText etTijdHeen = findViewById(R.id.etTijdHeen);
                EditText etTijdTerug = findViewById(R.id.etTijdTerug);
                EditText etVrijPlaats = findViewById(R.id.etVrijPlaats);

                EditText etKenteken = findViewById(R.id.etKenteken);
                EditText etMerk = findViewById(R.id.etMerk);
                EditText etKleur = findViewById(R.id.etKleur);

                String strOpstap = etOpstap.getText().toString();

                if (TextUtils.isEmpty(strOpstap)) {
                    etOpstap.setError("Je moet iets invullen!");
                    return;
                }

                String strEind = etEind.getText().toString();

                if (TextUtils.isEmpty(strEind)) {
                    etEind.setError("Je moet iets invullen!");
                    return;
                }

                String strDatum = etDatum.getText().toString();

                if (TextUtils.isEmpty(strDatum)) {
                    etDatum.setError("Je moet iets invullen!");
                    return;
                }

                String strTijdHeen = etTijdHeen.getText().toString();

                if (TextUtils.isEmpty(strTijdHeen)) {
                    etTijdHeen.setError("Je moet iets invullen!");
                    return;
                }

                String strTijdTerug = etTijdTerug.getText().toString();

                if (TextUtils.isEmpty(strTijdTerug)) {
                    etTijdTerug.setError("Je moet iets invullen!");
                    return;
                }

                String strVrijePlaats = etVrijPlaats.getText().toString();

                if (TextUtils.isEmpty(strVrijePlaats)) {
                    etVrijPlaats.setError("Je moet iets invullen!");
                    return;
                }

                String strKenteken = etKenteken.getText().toString();

                if (TextUtils.isEmpty(strKenteken)) {
                    etKenteken.setError("Je moet iets invullen!");
                    return;
                }

                String strMerk = etMerk.getText().toString();

                if (TextUtils.isEmpty(strMerk)) {
                    etMerk.setError("Je moet iets invullen!");
                    return;
                }

                String strKleur = etKleur.getText().toString();

                if (TextUtils.isEmpty(strKleur)) {
                    etKleur.setError("Je moet iets invullen!");
                    return;
                }

                else {

                    RitInfo ritInfo = new RitInfo(etOpstap.getText().toString(), etEind.getText().toString(), etDatum.getText().toString(), etTijdHeen.getText().toString(), etTijdTerug.getText().toString(),
                            Integer.parseInt(etVrijPlaats.getText().toString()), gebruikersnaam, "nog plaatsen vrij", etKenteken.getText().toString(), "");

                    AutoInfo autoInfo = new AutoInfo(etKenteken.getText().toString(), etMerk.getText().toString(), etKleur.getText().toString());


                    db.insertAutoInfo(autoInfo);
                    db.insertRitInfo(ritInfo);
                    RitAanmelding ritAanmelding = new RitAanmelding(etDatum.getText().toString(), gebruikersnaam, Carpoolcategorie.BESTUUDER,
                            db.geefRitInfoOpbasisVanGebruikersnaamEnDatum(gebruikersnaam, etDatum.getText().toString()));
                    db.insertAanmelding(ritAanmelding);

                    Intent go = new Intent(getApplicationContext(), MainActivity.class);
                    go.putExtra("Gebruikersnaam", gebruikersnaam);
                    startActivity(go);

                }
            }
        });





    }

}
