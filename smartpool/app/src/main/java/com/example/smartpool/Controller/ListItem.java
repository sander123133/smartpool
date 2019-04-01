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
import com.example.smartpool.Domain.BedrijfRang;
import com.example.smartpool.R;
import com.example.smartpool.Util.AdapterRang;

import java.util.ArrayList;



public class ListItem extends Fragment {

    private Database db;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;




    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        /*db = new Database(this.getContext());
        ArrayList<BedrijfRang> bedrijfRangs = db.geefBedrijven();

        View rootView = inflater.inflate(R.layout.list_item, container, false);


        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.rvRang);


        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);



        mAdapter = new AdapterRang(bedrijfRangs, this.getContext());

        mRecyclerView.setAdapter(mAdapter);
        */
        return inflater.inflate(R.layout.activity_rang, container, false);

    }



}



