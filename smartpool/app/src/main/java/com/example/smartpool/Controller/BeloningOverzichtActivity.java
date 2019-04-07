package com.example.smartpool.Controller;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.example.smartpool.Data.Database;
import com.example.smartpool.Domain.MedewerkerBeloning;
import com.example.smartpool.R;
import com.example.smartpool.Util.AdapterBeloningenOverzicht;

import java.util.ArrayList;

/**
 * Deze klasse zorgt ervoor dat de beloningen die de gebruiker heeft gekocht in de giftshop
 * te zien zijn in een overzicht op het scherm.
 * @see AdapterBeloningenOverzicht
 * @author Inge
 *
 */
public class BeloningOverzichtActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private Database mDatabase;
    private ArrayList<MedewerkerBeloning> beloningenMedewerker;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.beloningen_overzicht);

        //Haal de gebruikersnaam van de ingelogde gebruiker op
        Bundle extras = getIntent().getExtras();
        String gebruikersnaam = extras.getString("Gebruikersnaam");

        mDatabase = new Database(this);

        //haal beloningen van ingelogde gebruiker op uit database
        beloningenMedewerker = mDatabase.geefAlleBeloningenMedewerker(gebruikersnaam);

        if (beloningenMedewerker.size() == 0) {
            Toast.makeText(this, "U heeft nog geen beloningen gekocht", Toast.LENGTH_LONG).show();
        } else {

            //referentie naar recyclerview ophalen
            mRecyclerView = (RecyclerView) findViewById(R.id.rv_beloningen_overzicht);

            //Linear layout manager voor positionering van items in de recyclerview
            mLayoutManager = new LinearLayoutManager(this);
            mRecyclerView.setLayoutManager(mLayoutManager);

            //maak adapter
            mAdapter = new AdapterBeloningenOverzicht(beloningenMedewerker, this);
            //set adapter
            mRecyclerView.setAdapter(mAdapter);


        }

        //Verander de titel in de actionbar naar eigen tekst
        this.setTitle("Mijn Beloningen");

    }
}
