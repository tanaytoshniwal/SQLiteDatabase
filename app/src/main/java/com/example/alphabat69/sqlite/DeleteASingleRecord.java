package com.example.alphabat69.sqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DeleteASingleRecord extends AppCompatActivity {
    private EditText name;
    private Button delete;
    DBHelper obj;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_asingle_record);
        name = findViewById(R.id.delname);
        delete = findViewById(R.id.delete);
        obj = new DBHelper(DeleteASingleRecord.this);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                obj.delete(name.getText().toString());
                Toast.makeText(DeleteASingleRecord.this, "Record Deleted", Toast.LENGTH_LONG).show();
            }
        });
    }
}
