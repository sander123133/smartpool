package com.example.smartpool.Util;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;
import com.example.smartpool.Controller.ListItem;
import com.example.smartpool.Domain.BedrijfRang;
import com.example.smartpool.R;


import java.util.ArrayList;

public class AdapterRang extends RecyclerView.Adapter<AdapterRang.ViewHolder> implements Filterable {

    private ArrayList<BedrijfRang> mDataset;
    private ArrayList<BedrijfRang> mDatasetFull;
    private Context mContext;

    @Override
    public Filter getFilter() {
        return null;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        public View view;


        public TextView tvBedrijf;
        public TextView tvCredits;




        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.view = itemView;


            //elementen ophalen die in list_row_item view zitten
            tvBedrijf = (TextView) view.findViewById(R.id.txvBedrijf);
            tvCredits = (TextView) view.findViewById(R.id.txvCredits);



        }




        public void onClick(View view) {
            int position = getAdapterPosition();
            BedrijfRang mBedrijfRang = mDataset.get(position);



            };


        }



    public AdapterRang(ArrayList<BedrijfRang> mDataset, Context mContext){
        this.mDataset = mDataset;
        mDatasetFull = new ArrayList<BedrijfRang>(mDataset);
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public AdapterRang.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.list_item, viewGroup,false);
        ViewHolder v = new ViewHolder(view);
        return v;
    }


    @Override
    public void onBindViewHolder(@NonNull AdapterRang.ViewHolder viewHolder, int position) {

        BedrijfRang ri = mDataset.get(position);

        viewHolder.tvBedrijf.setText(ri.getBedrijfsnaam());
        viewHolder.tvCredits.setText(ri.getCreditaantal());



    }

    @Override
    public int getItemCount() {
        int size = mDataset.size();
        return size;
    }




    };

