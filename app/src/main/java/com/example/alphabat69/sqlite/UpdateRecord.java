package com.example.alphabat69.sqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateRecord extends AppCompatActivity {
    EditText username, newpass, newcontact;
    Button update;
    DBHelper obj;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_record);
        username = findViewById(R.id.username);
        newpass = findViewById(R.id.newpass);
        newcontact = findViewById(R.id.newcontact);
        update = findViewById(R.id.update);
        obj = new DBHelper(UpdateRecord.this);
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = obj.update(username.getText().toString(), newpass.getText().toString(), newcontact.getText().toString());
                Toast.makeText(UpdateRecord.this, i+" record(s) updated", Toast.LENGTH_LONG).show();
            }
        });
    }
}
