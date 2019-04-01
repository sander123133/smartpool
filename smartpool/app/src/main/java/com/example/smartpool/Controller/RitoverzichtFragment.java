package com.example.smartpool.Controller;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;

import com.example.smartpool.Data.Database;
import com.example.smartpool.Domain.BeloningWaardeCredit;
import com.example.smartpool.Domain.RitInfo;
import com.example.smartpool.R;
import com.example.smartpool.Util.AdapterGiftshop;
import com.example.smartpool.Util.AdapterRitoverzicht;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;



public class RitoverzichtFragment extends Fragment implements SearchView.OnQueryTextListener {

    private Database db;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private SearchView searchView = null;
    private SearchView.OnQueryTextListener queryTextListener;
    private ArrayList<RitInfo> ritten;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

         db = new Database(this.getContext());
         ritten = db.geefRitInfo();


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
        setHasOptionsMenu(true);
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.search_menu, menu);

        final MenuItem item = menu.findItem(R.id.action_search);
        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(item);
        searchView.setOnQueryTextListener(this);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        ArrayList<RitInfo> aangepasteRitten = new ArrayList<>();
        for(RitInfo rit : ritten){
            if(rit.getOpstapplaats().equals(query)){
                aangepasteRitten.add(rit);
            }
        }
        mAdapter = new AdapterRitoverzicht(aangepasteRitten, getContext());
        mRecyclerView.setAdapter(mAdapter);
        return true;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        if(newText.equals("")){
            mAdapter = new AdapterRitoverzicht(ritten, getContext());
            mRecyclerView.setAdapter(mAdapter);
        }
        return true;
    }
}



