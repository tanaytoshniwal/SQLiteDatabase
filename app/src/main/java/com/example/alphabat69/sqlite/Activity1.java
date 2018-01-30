package com.example.alphabat69.sqlite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Activity1 extends AppCompatActivity implements View.OnClickListener{
    private Button button1, button2, button3, button4, button5, button6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
    }
    @Override
    public void onClick(View v){
        switch(v.getId()){
            case R.id.button1:{
                startActivity(new Intent(Activity1.this, AddRecord.class));
                break;
            }
            case R.id.button2:{
                startActivity(new Intent(Activity1.this, DeleteASingleRecord.class));
                break;
            }
            case R.id.button3:{

                break;
            }
            case R.id.button4:{

                break;
            }
            case R.id.button5:{

                break;
            }
            case R.id.button6:{

                break;
            }
        }
    }
}
