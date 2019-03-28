package com.example.smartpool.Controller;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.smartpool.Data.Database;
import com.example.smartpool.Domain.BeloningWaardeCredit;
import com.example.smartpool.Domain.MedewerkerBeloning;
import com.example.smartpool.R;
import com.example.smartpool.Util.AdapterBeloningenOverzicht;
import com.example.smartpool.Util.AdapterGiftshop;

import java.util.ArrayList;

public class BeloningOverzichtActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private Database mDatabase;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.beloningen_overzicht);

        ImageButton btnVerwijder = (ImageButton) findViewById(R.id.bo_btnVerwijderBeloning2);

        mDatabase = new Database(this);

        //haal beloningen van ingelogde gebruiker op uit database
        ArrayList<MedewerkerBeloning> beloningenMedewerker = mDatabase.geefAlleBeloningenMedewerker("IngevZetten");

        for(MedewerkerBeloning mdb: beloningenMedewerker){
            Log.d("BeloningenOverzicht", "beloning: " + mdb.getBeloningsnaam());
        }

        //referentie naar recyclerview ophalen
        mRecyclerView = (RecyclerView) findViewById(R.id.rv_beloningen_overzicht);

        //Linear layout manager voor positionering van items in de recyclerview
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        //maak adapter
        mAdapter = new AdapterBeloningenOverzicht(beloningenMedewerker, this);
        //set adapter
        mRecyclerView.setAdapter(mAdapter);

        btnVerwijder.setOnClickListener(view -> {
            AlertDialog.Builder builder1 = new AlertDialog.Builder(BeloningOverzichtActivity.this);
            builder1.setMessage("Weet u zeker dat u deze beloning wilt verwijderen?");
            builder1.setCancelable(true);

            builder1.setPositiveButton(
                    "Ja",
                    (dialog, id) -> {

                        //mDatabase.verwijderBeloning();
                        dialog.cancel();
                    });
            AlertDialog alert11 = builder1.create();
            alert11.show();

        });

    }
}
