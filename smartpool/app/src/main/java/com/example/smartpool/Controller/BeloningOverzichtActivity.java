package com.example.smartpool.Controller;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.smartpool.Data.Database;
import com.example.smartpool.Domain.BeloningWaardeCredit;
import com.example.smartpool.Domain.MedewerkerBeloning;
import com.example.smartpool.R;
import com.example.smartpool.Util.AdapterBeloningenOverzicht;
import com.example.smartpool.Util.AdapterGiftshop;

import java.util.ArrayList;
//fragment van maken en wisselen in fragment container?
public class BeloningOverzichtActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private Database mDatabase;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.beloningen_overzicht);

        mDatabase = new Database(this);

        //haal beloningen van ingelogde gebruiker op uit database
        //arraylist om te testen
        ArrayList<MedewerkerBeloning> beloningenMedewerker = new ArrayList<>();
        MedewerkerBeloning medewerkerBeloning = new MedewerkerBeloning("TR456", 10.0, "VVV cadeaubon", "IngevZetten", "TR453RG789", "20-03-2019");
        beloningenMedewerker.add(medewerkerBeloning);

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
}
