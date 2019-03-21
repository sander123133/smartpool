package com.example.smartpool.Controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.smartpool.R;

public class RitoverzichtFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_rit_overzicht, null, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        final FloatingActionButton button =  getView().findViewById(R.id.btnSave);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent go = new Intent(getContext(), AddActivity.class);
                startActivity(go);

            }
        });

        super.onViewCreated(view, savedInstanceState);
    }
}
