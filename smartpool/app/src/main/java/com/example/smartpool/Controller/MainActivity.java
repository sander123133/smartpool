package com.example.smartpool.Controller;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.content.Intent;

import com.example.smartpool.Data.Database;
import com.example.smartpool.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Database db = new Database(this);
        db.createTestData();


        final FloatingActionButton button =  findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent go = new Intent(MainActivity.this, AddActivity.class);
                startActivity(go);

            }
        });


    }
}
