package com.example.tronicles.fitnesshelper;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by joanc on 4/25/2018.
 */


public class CalorieCounters extends AppCompatActivity {

    private EditText bfcal;
    private EditText lunchcal;
    private EditText dinnercal;
    private EditText snackcal;
    private Button btntotal;
    private TextView total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.caloriecounter);

        btntotal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                bfcal = (EditText) findViewById(R.id.bfcal);
                lunchcal = (EditText) findViewById(R.id.lunchcal);
                dinnercal = (EditText) findViewById(R.id.dinnercal);
                snackcal = (EditText) findViewById(R.id.snackcal);
                btntotal = (Button) findViewById(R.id.btnTotal);
                total = (TextView) findViewById(R.id.total);

                int bfcals = Integer.parseInt(bfcal.getText().toString());
                int lunchcals = Integer.parseInt(lunchcal.getText().toString());
                int dinnercals = Integer.parseInt(dinnercal.getText().toString());
                int snackcals = Integer.parseInt(snackcal.getText().toString());
                int sum = bfcals+ lunchcals + dinnercals + snackcals;
                total.setText("Total: " +sum);
            }
        });

    }
}

