package com.example.smartpool.Util;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.smartpool.Controller.GifsthopDetailActivity;
import com.example.smartpool.Controller.RitinformatieActivity_detailview;
import com.example.smartpool.Controller.RitoverzichtFragment;
import com.example.smartpool.Domain.BeloningWaardeCredit;
import com.example.smartpool.Domain.RitInfo;
import com.example.smartpool.R;


import java.util.ArrayList;

public class AdapterRitoverzicht extends RecyclerView.Adapter<AdapterRitoverzicht.ViewHolder> implements Filterable {

    private ArrayList<RitInfo> mDataset;
    private ArrayList<RitInfo> mDatasetFull;
    private Context mContext;

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {


        public View view;


        public TextView tvDatum;
        public TextView tvTijd;
        public TextView tvOpstap;
        public TextView tvEind;
        

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.view = itemView;
            this.view.setOnClickListener(this);

            //elementen ophalen die in list_row_item view zitten
            tvDatum = (TextView) view.findViewById(R.id.txvDatum);
            tvTijd = (TextView) view.findViewById(R.id.txvTijd);
            tvOpstap = (TextView) view.findViewById(R.id.txvOpstap);
            tvEind = (TextView) view.findViewById(R.id.txvEind);

        }



        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            RitInfo mRitInfo = mDataset.get(position);

            Intent ritDetailIntent = new Intent(
                    view.getContext().getApplicationContext(),
                    RitinformatieActivity_detailview.class);

            ritDetailIntent.putExtra("Ritinfo", mRitInfo);

            view.getContext().startActivity(ritDetailIntent);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mContext, RitinformatieActivity_detailview.class);
                    intent.putExtra("Ritoverzicht", mDataset.get(position));
                    mContext.startActivity(intent);
                }
            });


        }
    }

    //constructor voor adapter
    public AdapterRitoverzicht(ArrayList<RitInfo> mDataset, Context mContext){
        this.mDataset = mDataset;
        mDatasetFull = new ArrayList<RitInfo>(mDataset);
        this.mContext = mContext;
    }

    //Nieuwe views maken (invoked by the layout manager)
    @NonNull
    @Override
    public AdapterRitoverzicht.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.rit_listitem, viewGroup,false);
        ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    //inhoud van de view vervangen door waarden uit de dataset
    @Override
    public void onBindViewHolder(@NonNull AdapterRitoverzicht.ViewHolder viewHolder, int position) {

        RitInfo ri = mDataset.get(position);

        viewHolder.tvDatum.setText(ri.getDatum());
        viewHolder.tvTijd.setText(ri.getTijdHeen());
        viewHolder.tvOpstap.setText(ri.getOpstapplaats());
        viewHolder.tvEind.setText(ri.getEindbestmming());


    }

    //geeft grootte van de dataset terug
    @Override
    public int getItemCount() {
        int size = mDataset.size();
        return size;
    }

    @Override
    public Filter getFilter() {
        return filter;
    }

    private Filter filter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            ArrayList<RitInfo> filteredRitten = new ArrayList<>();

            if (constraint == null || constraint.length() == 0) {
            filteredRitten.addAll(mDatasetFull);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();

                for (RitInfo item : mDatasetFull){
                    if (item.getOpstapplaats().toLowerCase().contains(filterPattern)){
                        filteredRitten.add(item);

                    }
                }
            }

            FilterResults results = new FilterResults();
            results.values = filteredRitten;
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            mDataset.clear();
            mDataset.addAll((ArrayList) results.values);
            notifyDataSetChanged();
        }
    };
}
