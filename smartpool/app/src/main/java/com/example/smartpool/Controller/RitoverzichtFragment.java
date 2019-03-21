package com.example.smartpool.Controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.smartpool.Data.Database;
import com.example.smartpool.Domain.BeloningWaardeCredit;
import com.example.smartpool.Domain.RitInfo;
import com.example.smartpool.R;
import com.example.smartpool.Util.AdapterGiftshop;
import com.example.smartpool.Util.AdapterRitoverzicht;

import java.util.ArrayList;

public class RitoverzichtFragment extends Fragment {

    private Database db = new Database(this.getContext());
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        ArrayList<RitInfo> ritten = new ArrayList<>();
        RitInfo ritInfo = new RitInfo("Breda", "Roosendaal", "21-03-2019", "08:00");
        ritten.add(ritInfo);

        //ArrayList<RitInfo> ritten = db.geefRitInfo();

        View rootView = inflater.inflate(R.layout.fragment_rit_overzicht, container, false);

        //referentie naar recyclerview ophalen
        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.rvAutoritten);

        //Linear layout manager voor positionering van items in de recyclerview
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);

        //maak adapter
        mAdapter = new AdapterRitoverzicht(ritten, this.getContext());
        //set adapter
        mRecyclerView.setAdapter(mAdapter);

        return rootView;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        final FloatingActionButton fabToevoegen =  getView().findViewById(R.id.fabToevoegen);


        fabToevoegen.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent go = new Intent(getContext(), AddActivity.class);
                startActivity(go);

            }
        });

        super.onViewCreated(view, savedInstanceState);
    }
}
