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

/**
 * Custom adapter die ervoor zorgt dat de lijstitems in de recyclerview gevuld worden met de gekochte beloningen van de gebruiker.
 * @author Inge
 * @see BeloningOverzichtActivity
 */
public class AdapterBeloningenOverzicht extends RecyclerView.Adapter<AdapterBeloningenOverzicht.ViewHolder> {

    private ArrayList<MedewerkerBeloning> mDataset;
    private MedewerkerBeloning medewerkerBeloning;
    private Context mContext;
    private Database mDatabase;

    /**
     * Klasse die de layout beschrijft van de viewholder die gemaakt moet worden. Haalt referenties van de layout nodes van de
     * list item waarin de data uit de dataset weergegeven moet worden.
     */
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


        /**
         * Constructor voor klasse viewholder
         * @param itemView view die de items bevat die in de listview moeten komen.
         * @param listener onclicklistener voor knoppen in de viewholder.
         */
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

        /**
         * Methode die het klikken op de knoppen in de viewholder afhandelt.
         * @param view View waarin de knoppen terug te vinden zijn.
         */
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

    /**
     * Constructor
     * @param mDataset Lijst met gekochte beloningen van de grbuiker die weergegeven moet worden in de recyclerview
     * @param mContext Context waarin de lijst weergegeven moet worden
     */
    public AdapterBeloningenOverzicht(ArrayList<MedewerkerBeloning> mDataset, Context mContext) {
        this.mDataset = mDataset;
        this.mContext = mContext;
    }

    /**
     * Maakt een nieuwe viewholder als er geen viewholders zijn die de recyclerview opnieuw kan gebruiken.
     * @param viewGroup De viewholder die geupdate moet worden om de waarden uit het object op de positie van de dataset weer te geven
     * @param i De positie van het item in de dataset
     * @return Geeft gemaakte viewholder terug
     */
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

    /**
     * Methode die de data uit de dataset in de bijbehorende layout uit het lijstitem zet voor de opgegeven positie in de recyclerview.
     * @param viewHolder referentie van het lijstitem en de layout nodes die daarbij horen.
     * @param position positie van het object in de lijst
     */
    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {

        medewerkerBeloning = mDataset.get(viewHolder.getAdapterPosition());

        viewHolder.boBeloningsnaam.setText(medewerkerBeloning.getBeloningsnaam());
        viewHolder.boWaarde.setText(medewerkerBeloning.getWaarde());
        viewHolder.boDatum.setText(medewerkerBeloning.getDatum());
        viewHolder.boKortingscode.setText(medewerkerBeloning.getKortingscode());

    }

    /**
     * Geeft de grootte van de dataset
     * @return int aantal objecten in de lijst.
     */
    @Override
    public int getItemCount() {
        int size = mDataset.size();
        return size;
    }


}
