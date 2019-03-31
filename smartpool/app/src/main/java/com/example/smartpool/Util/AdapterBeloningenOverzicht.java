package com.example.smartpool.Util;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;


import com.example.smartpool.Controller.BeloningOverzichtActivity;
import com.example.smartpool.Data.Database;
import com.example.smartpool.Domain.BeloningWaardeCredit;
import com.example.smartpool.Domain.MedewerkerBeloning;
import com.example.smartpool.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class AdapterBeloningenOverzicht extends RecyclerView.Adapter<AdapterBeloningenOverzicht.ViewHolder> {

    private ArrayList<MedewerkerBeloning> mDataset;
    private MedewerkerBeloning medewerkerBeloning;
    private Context mContext;
    private Database mDatabase;

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        //view (list_row_item) die de items bevat die in de listview moeten komen
        public View view;
        MyClicklistener listener;

        //view items die de list_row_item bevat
        public TextView boBeloningsnaam;
        public TextView boWaarde;
        public TextView boDatum;
        public TextView boKortingscode;
        public TextView tvVerwijder;
        public TextView tvDownload;


        public ViewHolder(@NonNull View itemView, MyClicklistener listener) {
            super(itemView);
            this.view = itemView;

            this.listener = listener;

            //elementen ophalen die in list_row_item view zitten
            boBeloningsnaam = (TextView) view.findViewById(R.id.bo_naamBeloning);
            boWaarde = (TextView) view.findViewById(R.id.bo_waarde);
            boDatum = (TextView) view.findViewById(R.id.bo_datum);
            boKortingscode = (TextView) view.findViewById(R.id.bo_kortingscode);
            tvDownload = (TextView) view.findViewById(R.id.bo_downloadTicket);
            tvVerwijder = (TextView) view.findViewById(R.id.bo_verwijderBeloning);

            tvDownload.setOnClickListener(this);
            tvVerwijder.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {

            switch (view.getId()) {
                case R.id.bo_downloadTicket:
                    listener.onDownload(getAdapterPosition());
                    break;
                case R.id.bo_verwijderBeloning:
                    listener.onDelete(getAdapterPosition());
                    break;
                default:
                    break;
            }

        }

        public interface MyClicklistener {
            void onDelete(int p);

            void onDownload(int p);
        }
    }

    //constructor voor adapter
    public AdapterBeloningenOverzicht(ArrayList<MedewerkerBeloning> mDataset, Context mContext) {
        this.mDataset = mDataset;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public AdapterBeloningenOverzicht.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        mDatabase = new Database(viewGroup.getContext());
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.beloningen_overzicht_list_item, viewGroup, false);
        ViewHolder vh = new ViewHolder(view, new ViewHolder.MyClicklistener() {
            @Override
            public void onDelete(int p) {

                AlertDialog.Builder builder1 = new AlertDialog.Builder(view.getContext());
                builder1.setMessage("Weet u zeker dat u deze beloning heeft besteed en wilt verwijderen?");

                builder1.setPositiveButton(
                        "Verwijder beloning",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                int transactienummer = medewerkerBeloning.getTransactienummer();
                                mDatabase.verwijderBeloning(transactienummer);
                                mDataset.remove(p);
                                notifyItemRemoved(p);
                                notifyItemRangeChanged(p, mDataset.size());
                                notifyDataSetChanged();
                                dialog.cancel();

                            }
                        });
                builder1.setNegativeButton("Annuleren",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int i) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alert11 = builder1.create();
                alert11.show();


            }

            @Override
            public void onDownload(int p) {
                Toast.makeText(view.getContext(), "Deze functie werkt nog niet", Toast.LENGTH_LONG).show();
            }
        });
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {

        medewerkerBeloning = mDataset.get(viewHolder.getAdapterPosition());

        viewHolder.boBeloningsnaam.setText(medewerkerBeloning.getBeloningsnaam());
        viewHolder.boWaarde.setText(medewerkerBeloning.getWaarde());
        viewHolder.boDatum.setText(medewerkerBeloning.getDatum());
        viewHolder.boKortingscode.setText(medewerkerBeloning.getKortingscode());

    }

    @Override
    public int getItemCount() {
        int size = mDataset.size();
        return size;
    }


}
