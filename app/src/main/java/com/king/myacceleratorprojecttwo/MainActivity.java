package com.king.myacceleratorprojecttwo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button mBtnCalc, mBtnWeb, mBtnIntents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Find the views by ID to each button

        mBtnCalc = findViewById(R.id.btn_calc);
        mBtnWeb = findViewById(R.id.btn_web);
        mBtnIntents = findViewById(R.id.btn_intents);

        //Set the onclick listeners to each button

        mBtnCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //First way
                //Intent x = new Intent(MainActivity.this,CalculatorActivity.class);
                //startActivity(x);

                //Second Way
                startActivity(new Intent(MainActivity.this,CalculatorActivity.class));
            }
        });

        mBtnWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(MainActivity.this,WebsiteActivity.class));

            }
        });

        mBtnIntents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(MainActivity.this, IntentsActivity.class));

            }
        });
    }
}