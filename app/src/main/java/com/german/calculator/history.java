package com.german.calculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class history extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        MainActivity ma = new MainActivity();

        ArrayList<String> history = ma.getHistory();

        ListView list = findViewById(R.id.list);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1, history);
        list.setAdapter(adapter);

//        RecyclerView RecyclerView = findViewById(R.id.RecyclerView);
//        RecyclerView.setLayoutManager(new LinearLayoutManager(this));
//
//        Adapter

    }

}
