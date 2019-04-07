package com.example.smartpool.Controller;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.example.smartpool.Data.Database;
import com.example.smartpool.Domain.RitAanmelding;
import com.example.smartpool.R;
import com.example.smartpool.Util.ApdapterAangemeldeRitten;

import java.util.ArrayList;

public class AangemeldeRittenAcitivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitivity_aangemelderitten);
        Bundle bundle = getIntent().getExtras();
        String gebruikersnaam = (String) bundle.get("Gebruikersnaam");
        ListView listView = findViewById(R.id.aangemelderitten_listview);
        Database database = new Database(this);
        ArrayList<RitAanmelding> aanmeldingen = database.getRitaanmeldingenOpBasisGebruikersnaam(gebruikersnaam);
        listView.setAdapter(new ApdapterAangemeldeRitten(this,R.layout.listview_adpater_activity_aangemelderitten,aanmeldingen, database));
    }
}
