package com.example.smartpool.Util;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.example.smartpool.Domain.BeloningWaardeCredit;
import com.example.smartpool.Domain.MedewerkerBeloning;
import com.example.smartpool.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class AdapterBeloningenOverzicht extends RecyclerView.Adapter<AdapterBeloningenOverzicht.ViewHolder> {

    private ArrayList<MedewerkerBeloning> mDataset;
    private Context mContext;

    public class ViewHolder extends RecyclerView.ViewHolder {

        //view (list_row_item) die de items bevat die in de listview moeten komen
        public View view;

        //view items die de list_row_item bevat
        public TextView boBeloningsnaam;
        public TextView boWaarde;
        public TextView boDatum;
        public TextView boKortingscode;



        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.view = itemView;

            //elementen ophalen die in list_row_item view zitten
            boBeloningsnaam = (TextView) view.findViewById(R.id.bo_naamBeloning);
            boWaarde = (TextView) view.findViewById(R.id.bo_waarde);
            boDatum = (TextView) view.findViewById(R.id.bo_datum);
            boKortingscode = (TextView) view.findViewById(R.id.bo_kortingscode);

        }
    }

    //constructor voor adapter
    public AdapterBeloningenOverzicht(ArrayList<MedewerkerBeloning> mDataset, Context mContext){
        this.mDataset = mDataset;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public AdapterBeloningenOverzicht.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.beloningen_overzicht_list_item, viewGroup,false);
        ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {

        MedewerkerBeloning medewerkerBeloning = mDataset.get(position);

        viewHolder.boBeloningsnaam.setText(medewerkerBeloning.getBeloningsnaam());
        viewHolder.boWaarde.setText(Double.toString(medewerkerBeloning.getWaarde()));
        viewHolder.boDatum.setText(medewerkerBeloning.getDatum());
        viewHolder.boKortingscode.setText(medewerkerBeloning.getKortingscode());

    }

    @Override
    public int getItemCount() {
        int size = mDataset.size();
        return size;
    }


}
