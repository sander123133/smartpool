package com.example.smartpool.Controller;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.smartpool.Data.Database;
import com.example.smartpool.Domain.BeloningWaardeCredit;
import com.example.smartpool.Domain.Medewerkerinfo;
import com.example.smartpool.R;
import com.example.smartpool.Util.AdapterGiftshop;

import java.util.ArrayList;

/**
 * Deze klasse zorgt ervoor dat alle beloningen uit de giftshop zichtbaar worden op het scherm.
 * @see AdapterGiftshop
 * @author Inge
 */
public class GiftshopFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private Database mDatabase;
    private Medewerkerinfo medewerkerinfo;
    private String gebruikersnaamIngelogd;
    private TextView tvCreditBesteedbaar;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        //Haal de gebruikersnaam van de ingelogde gebruiker op om te besteden credits op te halen.
        gebruikersnaamIngelogd = getArguments().getString("Gebruikersnaam");

        mDatabase = new Database(this.getContext());
        medewerkerinfo = mDatabase.geefMedewerker(gebruikersnaamIngelogd);

        Log.d("GiftshopFragment", "medewerker ingelogd:" + medewerkerinfo.getGebruikersnaam());

        //haal beloningen op uit database
        ArrayList<BeloningWaardeCredit> beloningen = mDatabase.geefAlleBeloningen();

        //koppeling layout en java class
        View rootView = inflater.inflate(R.layout.fragment_giftshop, container, false);

        //referentie naar recyclerview ophalen
        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerview_giftshop);

        //Linear layout manager voor positionering van items in de recyclerview
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);

        //maak adapter
        mAdapter = new AdapterGiftshop(beloningen, this.getContext(), gebruikersnaamIngelogd);
        //set adapter
        mRecyclerView.setAdapter(mAdapter);

        //Zet de credits die de gebruiker te besteden heeft in het daarvoor bedoelde tekstvak op het scherm
        tvCreditBesteedbaar =  rootView.findViewById(R.id.tv_creditaantal_besteden);
        tvCreditBesteedbaar.setText(Integer.toString(medewerkerinfo.getCreditaantal()));


        return rootView;
    }

    /**
     * Zorgt ervoor dat het creditaantal in het tekstvak veranderd wordt nadat een aankoop is gedaan in
     * GiftshopDetailActivity.
     * @see GifsthopDetailActivity
     */
    @Override
    public void onResume() {
        super.onResume();

        medewerkerinfo = mDatabase.geefMedewerker(gebruikersnaamIngelogd);
        tvCreditBesteedbaar.setText(Integer.toString(medewerkerinfo.getCreditaantal()));
    }
}
