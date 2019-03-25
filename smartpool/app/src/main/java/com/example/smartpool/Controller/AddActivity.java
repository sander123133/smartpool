package com.example.smartpool.Controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import com.example.smartpool.Data.Database;
import com.example.smartpool.Domain.AutoInfo;
import com.example.smartpool.Domain.Medewerkerinfo;
import com.example.smartpool.Domain.RitInfo;
import com.example.smartpool.R;

public class AddActivity extends AppCompatActivity {

    private Database db = new Database(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_main);
        final Button btnSave = findViewById(R.id.btnSave);

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

                RitInfo ritInfo = new RitInfo( etOpstap.getText().toString(), etEind.getText().toString(), etDatum.getText().toString(), etTijdHeen.getText().toString(), etTijdTerug.getText().toString(),
                        Integer.parseInt(etVrijPlaats.getText().toString()), "", "", "", "");



                AutoInfo autoInfo = new AutoInfo(etKenteken.getText().toString(), etMerk.getText().toString(), etKleur.getText().toString());

                db.insertAutoInfo(autoInfo);
                db.insertRitInfo(ritInfo);


                Intent go = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(go);

            }
        });





    }

}
