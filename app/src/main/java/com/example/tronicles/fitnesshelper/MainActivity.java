package com.example.tronicles.fitnesshelper;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    // Initializing buttons
    Button macrocalc;
    Button calcount;
    Button wroutine;

    // onCreate method for when app loads up
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Obtaining values and setting them to variables
        macrocalc = findViewById(R.id.macrocalc);
        calcount = findViewById(R.id.calcount);
        wroutine = findViewById(R.id.wroutine);

        // Intent button to Macro Calculator page
        macrocalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MacroCalc.class);
                startActivity(i);
            }
        });

        // Intent button to Calorie Counter page
        calcount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), caloriecounter.class);
                startActivity(i);
            }
        });

        // Intent button to Workout Routines page
        wroutine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), ExcerciseActivity.class);
                startActivity(i);
            }
        });

        // Intent button to Calendar page
        calendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Calendar.class);
                startActivity(i);
            }
        });
    }
}
