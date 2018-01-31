package com.example.alphabat69.sqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ShowAll extends AppCompatActivity {
    private ListView view;
    DBHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_all);
        view = findViewById(R.id.view);
        db = new DBHelper(ShowAll.this);
        ArrayList<StringBuffer> list = db.showAll();
        ArrayAdapter adapter = new ArrayAdapter(ShowAll.this, android.R.layout.simple_expandable_list_item_1, list);
        view.setAdapter(adapter);
    }
}
