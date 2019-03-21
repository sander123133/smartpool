package com.example.smartpool.Controller;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.smartpool.Data.Database;
import com.example.smartpool.Domain.BeloningWaardeCredit;
import com.example.smartpool.R;
import com.example.smartpool.Util.AdapterGiftshop;

import java.util.ArrayList;

public class GiftshopFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private Database mDatabase;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mDatabase = new Database(this.getContext());

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
        mAdapter = new AdapterGiftshop(beloningen, this.getContext());
        //set adapter
        mRecyclerView.setAdapter(mAdapter);

        return rootView;
    }
}