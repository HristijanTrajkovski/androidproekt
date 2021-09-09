package com.example.proekt;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class RecyclerActivity extends AppCompatActivity {
        RecyclerView mRecyclerView;
        Adapter myAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);


        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        myAdapter = new Adapter(this, getMyList());
        mRecyclerView.setAdapter(myAdapter);
    }

    private ArrayList<model> getMyList() {
        ArrayList<model> models = new ArrayList<>();
        model m = new model();
        m.setTitle("New York");
        m.setDescription("The Big Apple");
        m.setImg(R.drawable.newyork);
        models.add(m);



        m.setTitle("Tokyo");
        m.setDescription("Capital of Japan");
        m.setImg(R.drawable.tokyo);
        models.add(m);


        m.setTitle("Los Angeles");
        m.setDescription("City of Angels");
        m.setImg(R.drawable.la);
        models.add(m);


        m.setTitle("London");
        m.setDescription("Capital of England");
        m.setImg(R.drawable.london);

        return models;

    }

}