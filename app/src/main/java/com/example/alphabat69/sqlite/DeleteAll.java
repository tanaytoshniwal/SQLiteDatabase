package com.example.alphabat69.sqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class DeleteAll extends AppCompatActivity {
    Button delall;
    DBHelper obj;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_all);
        delall = findViewById(R.id.delall);
        obj = new DBHelper(DeleteAll.this);
        delall.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                int data = obj.delete();
                Toast.makeText(DeleteAll.this, data+" Records Deleted", Toast.LENGTH_LONG).show();
            }
        });
    }
}
