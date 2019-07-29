package com.mytest.mytestdb;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {


    private Button Button1,Button2,Button3,Button4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button1 = (Button) findViewById(R.id.button_1);
        Button2 = (Button) findViewById(R.id.button_2);
        Button3 = (Button) findViewById(R.id.button_3);
        Button4 = (Button) findViewById(R.id.button_4);

        Button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, queryinfo.class);
                intent.putExtra("extra_data", "contact");
                startActivity(intent);
            }
        });

        Button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, queryinfo.class);
                intent.putExtra("extra_data", "resident");
                startActivity(intent);
            }
        });

        Button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, queryinfo.class);
                intent.putExtra("extra_data", "road");
                startActivity(intent);
            }
        });

        Button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, queryinfo.class);
                intent.putExtra("extra_data", "widget");
                startActivity(intent);
            }
        });
    }

    }
