package com.example.tronicles.fitnesshelper;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

/**
 * Created by Tronicles on 4/16/2018.
 */

public class MacroCalc extends AppCompatActivity {

    // Initializing edittexts, radiobuttons, and the calculate button
    EditText editAge, editWeight, feet, inches;
    RadioButton male, female, sedentary, light, moderate, extreme, losemore, loseless, maintain, gainmore, gainless;
    Button calc;

    // onCreate method for when app loads up
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.macro_calc);

        // Setting values to local variables
        editAge = findViewById(R.id.editAge);
        editWeight = findViewById(R.id.editWeight);
        feet = findViewById(R.id.feet);
        inches = findViewById(R.id.inches);
        male = findViewById(R.id.male);
        female = findViewById(R.id.female);
        sedentary = findViewById(R.id.sedentary);
        light = findViewById(R.id.light);
        moderate = findViewById(R.id.moderate);
        extreme = findViewById(R.id.extreme);
        loseless = findViewById(R.id.loseless);
        losemore = findViewById(R.id.losemore);
        gainless = findViewById(R.id.gainless);
        gainmore = findViewById(R.id.gainmore);
        maintain = findViewById(R.id.maintain);
        calc = findViewById(R.id.calc);

        // Calculate button logic
        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Setting all local variables as well as math conversions as variables
                double f, i, lb, mREE, fREE, mTDEE, fTDEE, newTDEE, netCarb, netProt, netFat, totCarb, totProt, totFat;
                f = Double.parseDouble(feet.getText().toString())*30.48;
                i = Double.parseDouble(inches.getText().toString())*2.54;
                lb = Double.parseDouble(editWeight.getText().toString())*.453592;

                // Intent to MacroResults page and initializing intent/bundle
                Intent intent = new Intent(getApplicationContext(), MacroResults.class);
                Bundle bundle = new Bundle();

                // if statement for when male, sedentary, and losemore is checked
                if (male.isChecked() && sedentary.isChecked() && losemore.isChecked()) {

                    // Algorithm to find exact macros from total calories split into Protein, Fat, and Carbohydrates
                    mREE = ((10*lb)+(6.25*(f+i))-(5*(Double.parseDouble(editAge.getText().toString())))+5);
                    mTDEE = (mREE*1.2);
                    newTDEE = mTDEE - (mTDEE*.2);
                    netProt = ((Double.parseDouble(editWeight.getText().toString()))*(0.825))*4;
                    netFat = (newTDEE*.25);
                    netCarb = (newTDEE - (netProt+netFat));
                    totProt = (netProt/4);
                    totFat = (netFat/9);
                    totCarb = (netCarb/4);

                    // Math conversion so that answer does not exceed 2 decimal places
                    double a = Math.round(newTDEE*100.0)/100.0;
                    double b = Math.round(totProt*100.0)/100.0;
                    double c = Math.round(totFat*100.0)/100.0;
                    double d = Math.round(totCarb*100.0)/100.0;

                    // Bundle up the answers to prepare to send to results page
                    bundle.putString("newTDEE", Double.toString(a));
                    bundle.putString("totProt", Double.toString(b));
                    bundle.putString("totFat", Double.toString(c));
                    bundle.putString("totCarb", Double.toString(d));

                    // if statement for when male, sedentary, and loseless is checked
                } else if (male.isChecked() && sedentary.isChecked() && loseless.isChecked()) {

                    // Algorithm to find exact macros from total calories split into Protein, Fat, and Carbohydrates
                    mREE = ((10*lb)+(6.25*(f+i))-(5*(Double.parseDouble(editAge.getText().toString())))+5);
                    mTDEE = (mREE*1.2);
                    newTDEE = mTDEE - (mTDEE*.1);
                    netProt = ((Double.parseDouble(editWeight.getText().toString()))*(0.825))*4;
                    netFat = (newTDEE*.25);
                    netCarb = (newTDEE - (netProt+netFat));
                    totProt = (netProt/4);
                    totFat = (netFat/9);
                    totCarb = (netCarb/4);

                    // Math conversion so that answer does not exceed 2 decimal places
                    double a = Math.round(newTDEE*100.0)/100.0;
                    double b = Math.round(totProt*100.0)/100.0;
                    double c = Math.round(totFat*100.0)/100.0;
                    double d = Math.round(totCarb*100.0)/100.0;

                    // Bundle up the answers to prepare to send to results page
                    bundle.putString("newTDEE", Double.toString(a));
                    bundle.putString("totProt", Double.toString(b));
                    bundle.putString("totFat", Double.toString(c));
                    bundle.putString("totCarb", Double.toString(d));

                    // if statement for when male, sedentary, and maintain is checked
                } else if (male.isChecked() && sedentary.isChecked() && maintain.isChecked()) {

                    // Algorithm to find exact macros from total calories split into Protein, Fat, and Carbohydrates
                    mREE = ((10*lb)+(6.25*(f+i))-(5*(Double.parseDouble(editAge.getText().toString())))+5);
                    mTDEE = (mREE*1.2);
                    newTDEE = mTDEE;
                    netProt = ((Double.parseDouble(editWeight.getText().toString()))*(0.825))*4;
                    netFat = (newTDEE*.25);
                    netCarb = (newTDEE - (netProt+netFat));
                    totProt = (netProt/4);
                    totFat = (netFat/9);
                    totCarb = (netCarb/4);

                    // Math conversion so that answer does not exceed 2 decimal places
                    double a = Math.round(newTDEE*100.0)/100.0;
                    double b = Math.round(totProt*100.0)/100.0;
                    double c = Math.round(totFat*100.0)/100.0;
                    double d = Math.round(totCarb*100.0)/100.0;

                    // Bundle up the answers to prepare to send to results page
                    bundle.putString("newTDEE", Double.toString(a));
                    bundle.putString("totProt", Double.toString(b));
                    bundle.putString("totFat", Double.toString(c));
                    bundle.putString("totCarb", Double.toString(d));

                    // if statement for when male, sedentary, and gainmore is checked
                } else if (male.isChecked() && sedentary.isChecked() && gainmore.isChecked()) {

                    // Algorithm to find exact macros from total calories split into Protein, Fat, and Carbohydrates
                    mREE = ((10*lb)+(6.25*(f+i))-(5*(Double.parseDouble(editAge.getText().toString())))+5);
                    mTDEE = (mREE*1.2);
                    newTDEE = mTDEE + (mTDEE*.2);
                    netProt = ((Double.parseDouble(editWeight.getText().toString()))*(0.825))*4;
                    netFat = (newTDEE*.25);
                    netCarb = (newTDEE - (netProt+netFat));
                    totProt = (netProt/4);
                    totFat = (netFat/9);
                    totCarb = (netCarb/4);

                    // Math conversion so that answer does not exceed 2 decimal places
                    double a = Math.round(newTDEE*100.0)/100.0;
                    double b = Math.round(totProt*100.0)/100.0;
                    double c = Math.round(totFat*100.0)/100.0;
                    double d = Math.round(totCarb*100.0)/100.0;

                    // Bundle up the answers to prepare to send to results page
                    bundle.putString("newTDEE", Double.toString(a));
                    bundle.putString("totProt", Double.toString(b));
                    bundle.putString("totFat", Double.toString(c));
                    bundle.putString("totCarb", Double.toString(d));

                    // if statement for when male, sedentary, and gainless is checked
                } else if (male.isChecked() && sedentary.isChecked() && gainless.isChecked()) {

                    // Algorithm to find exact macros from total calories split into Protein, Fat, and Carbohydrates
                    mREE = ((10*lb)+(6.25*(f+i))-(5*(Double.parseDouble(editAge.getText().toString())))+5);
                    mTDEE = (mREE*1.2);
                    newTDEE = mTDEE + (mTDEE*.1);
                    netProt = ((Double.parseDouble(editWeight.getText().toString()))*(0.825))*4;
                    netFat = (newTDEE*.25);
                    netCarb = (newTDEE - (netProt+netFat));
                    totProt = (netProt/4);
                    totFat = (netFat/9);
                    totCarb = (netCarb/4);

                    // Math conversion so that answer does not exceed 2 decimal places
                    double a = Math.round(newTDEE*100.0)/100.0;
                    double b = Math.round(totProt*100.0)/100.0;
                    double c = Math.round(totFat*100.0)/100.0;
                    double d = Math.round(totCarb*100.0)/100.0;

                    // Bundle up the answers to prepare to send to results page
                    bundle.putString("newTDEE", Double.toString(a));
                    bundle.putString("totProt", Double.toString(b));
                    bundle.putString("totFat", Double.toString(c));
                    bundle.putString("totCarb", Double.toString(d));

                    // if statement for when male, light, and losemore is checked
                } else if (male.isChecked() && light.isChecked() && losemore.isChecked()) {

                    // Algorithm to find exact macros from total calories split into Protein, Fat, and Carbohydrates
                    mREE = ((10*lb)+(6.25*(f+i))-(5*(Double.parseDouble(editAge.getText().toString())))+5);
                    mTDEE = (mREE*1.375);
                    newTDEE = mTDEE - (mTDEE*.2);
                    netProt = ((Double.parseDouble(editWeight.getText().toString()))*(0.825))*4;
                    netFat = (newTDEE*.25);
                    netCarb = (newTDEE - (netProt+netFat));
                    totProt = (netProt/4);
                    totFat = (netFat/9);
                    totCarb = (netCarb/4);

                    // Math conversion so that answer does not exceed 2 decimal places
                    double a = Math.round(newTDEE*100.0)/100.0;
                    double b = Math.round(totProt*100.0)/100.0;
                    double c = Math.round(totFat*100.0)/100.0;
                    double d = Math.round(totCarb*100.0)/100.0;

                    // Bundle up the answers to prepare to send to results page
                    bundle.putString("newTDEE", Double.toString(a));
                    bundle.putString("totProt", Double.toString(b));
                    bundle.putString("totFat", Double.toString(c));
                    bundle.putString("totCarb", Double.toString(d));

                    // if statement for when male, light, and loseless is checked
                } else if (male.isChecked() && light.isChecked() && loseless.isChecked()) {

                    // Algorithm to find exact macros from total calories split into Protein, Fat, and Carbohydrates
                    mREE = ((10*lb)+(6.25*(f+i))-(5*(Double.parseDouble(editAge.getText().toString())))+5);
                    mTDEE = (mREE*1.375);
                    newTDEE = mTDEE - (mTDEE*.1);
                    netProt = ((Double.parseDouble(editWeight.getText().toString()))*(0.825))*4;
                    netFat = (newTDEE*.25);
                    netCarb = (newTDEE - (netProt+netFat));
                    totProt = (netProt/4);
                    totFat = (netFat/9);
                    totCarb = (netCarb/4);

                    // Math conversion so that answer does not exceed 2 decimal places
                    double a = Math.round(newTDEE*100.0)/100.0;
                    double b = Math.round(totProt*100.0)/100.0;
                    double c = Math.round(totFat*100.0)/100.0;
                    double d = Math.round(totCarb*100.0)/100.0;

                    // Bundle up the answers to prepare to send to results page
                    bundle.putString("newTDEE", Double.toString(a));
                    bundle.putString("totProt", Double.toString(b));
                    bundle.putString("totFat", Double.toString(c));
                    bundle.putString("totCarb", Double.toString(d));

                    // if statement for when male, light, and maintain is checked
                } else if (male.isChecked() && light.isChecked() && maintain.isChecked()) {

                    // Algorithm to find exact macros from total calories split into Protein, Fat, and Carbohydrates
                    mREE = ((10*lb)+(6.25*(f+i))-(5*(Double.parseDouble(editAge.getText().toString())))+5);
                    mTDEE = (mREE*1.375);
                    newTDEE = mTDEE;
                    netProt = ((Double.parseDouble(editWeight.getText().toString()))*(0.825))*4;
                    netFat = (mTDEE*.25);
                    netCarb = (newTDEE - (netProt+netFat));
                    totProt = (netProt/4);
                    totFat = (netFat/9);
                    totCarb = (netCarb/4);

                    // Math conversion so that answer does not exceed 2 decimal places
                    double a = Math.round(newTDEE*100.0)/100.0;
                    double b = Math.round(totProt*100.0)/100.0;
                    double c = Math.round(totFat*100.0)/100.0;
                    double d = Math.round(totCarb*100.0)/100.0;

                    // Bundle up the answers to prepare to send to results page
                    bundle.putString("newTDEE", Double.toString(a));
                    bundle.putString("totProt", Double.toString(b));
                    bundle.putString("totFat", Double.toString(c));
                    bundle.putString("totCarb", Double.toString(d));

                    // if statement for when male, light, and gainmore is checked
                } else if (male.isChecked() && light.isChecked() && gainmore.isChecked()) {

                    // Algorithm to find exact macros from total calories split into Protein, Fat, and Carbohydrates
                    mREE = ((10*lb)+(6.25*(f+i))-(5*(Double.parseDouble(editAge.getText().toString())))+5);
                    mTDEE = (mREE*1.375);
                    newTDEE = mTDEE + (mTDEE*.2);
                    netProt = ((Double.parseDouble(editWeight.getText().toString()))*(0.825))*4;
                    netFat = (newTDEE*.25);
                    netCarb = (newTDEE - (netProt+netFat));
                    totProt = (netProt/4);
                    totFat = (netFat/9);
                    totCarb = (netCarb/4);

                    // Math conversion so that answer does not exceed 2 decimal places
                    double a = Math.round(newTDEE*100.0)/100.0;
                    double b = Math.round(totProt*100.0)/100.0;
                    double c = Math.round(totFat*100.0)/100.0;
                    double d = Math.round(totCarb*100.0)/100.0;

                    // Bundle up the answers to prepare to send to results page
                    bundle.putString("newTDEE", Double.toString(a));
                    bundle.putString("totProt", Double.toString(b));
                    bundle.putString("totFat", Double.toString(c));
                    bundle.putString("totCarb", Double.toString(d));

                    // if statement for when male, light, and gainless is checked
                } else if (male.isChecked() && light.isChecked() && gainless.isChecked()) {

                    // Algorithm to find exact macros from total calories split into Protein, Fat, and Carbohydrates
                    mREE = ((10*lb)+(6.25*(f+i))-(5*(Double.parseDouble(editAge.getText().toString())))+5);
                    mTDEE = (mREE*1.375);
                    newTDEE = mTDEE + (mTDEE*.1);
                    netProt = ((Double.parseDouble(editWeight.getText().toString()))*(0.825))*4;
                    netFat = (newTDEE*.25);
                    netCarb = (newTDEE - (netProt+netFat));
                    totProt = (netProt/4);
                    totFat = (netFat/9);
                    totCarb = (netCarb/4);

                    // Math conversion so that answer does not exceed 2 decimal places
                    double a = Math.round(newTDEE*100.0)/100.0;
                    double b = Math.round(totProt*100.0)/100.0;
                    double c = Math.round(totFat*100.0)/100.0;
                    double d = Math.round(totCarb*100.0)/100.0;

                    // Bundle up the answers to prepare to send to results page
                    bundle.putString("newTDEE", Double.toString(a));
                    bundle.putString("totProt", Double.toString(b));
                    bundle.putString("totFat", Double.toString(c));
                    bundle.putString("totCarb", Double.toString(d));

                    // if statement for when male, moderate, and losemore is checked
                } else if (male.isChecked() && moderate.isChecked() && losemore.isChecked()) {

                    // Algorithm to find exact macros from total calories split into Protein, Fat, and Carbohydrates
                    mREE = ((10*lb)+(6.25*(f+i))-(5*(Double.parseDouble(editAge.getText().toString())))+5);
                    mTDEE = (mREE*1.55);
                    newTDEE = mTDEE - (mTDEE*.2);
                    netProt = ((Double.parseDouble(editWeight.getText().toString()))*(0.825))*4;
                    netFat = (newTDEE*.25);
                    netCarb = (newTDEE - (netProt+netFat));
                    totProt = (netProt/4);
                    totFat = (netFat/9);
                    totCarb = (netCarb/4);

                    // Math conversion so that answer does not exceed 2 decimal places
                    double a = Math.round(newTDEE*100.0)/100.0;
                    double b = Math.round(totProt*100.0)/100.0;
                    double c = Math.round(totFat*100.0)/100.0;
                    double d = Math.round(totCarb*100.0)/100.0;

                    // Bundle up the answers to prepare to send to results page
                    bundle.putString("newTDEE", Double.toString(a));
                    bundle.putString("totProt", Double.toString(b));
                    bundle.putString("totFat", Double.toString(c));
                    bundle.putString("totCarb", Double.toString(d));

                    // if statement for when male, moderate, and loseless is checked
                } else if (male.isChecked() && moderate.isChecked() && loseless.isChecked()) {

                    // Algorithm to find exact macros from total calories split into Protein, Fat, and Carbohydrates
                    mREE = ((10*lb)+(6.25*(f+i))-(5*(Double.parseDouble(editAge.getText().toString())))+5);
                    mTDEE = (mREE*1.55);
                    newTDEE = mTDEE - (mTDEE*.1);
                    netProt = ((Double.parseDouble(editWeight.getText().toString()))*(0.825))*4;
                    netFat = (newTDEE*.25);
                    netCarb = (newTDEE - (netProt+netFat));
                    totProt = (netProt/4);
                    totFat = (netFat/9);
                    totCarb = (netCarb/4);

                    // Math conversion so that answer does not exceed 2 decimal places
                    double a = Math.round(newTDEE*100.0)/100.0;
                    double b = Math.round(totProt*100.0)/100.0;
                    double c = Math.round(totFat*100.0)/100.0;
                    double d = Math.round(totCarb*100.0)/100.0;

                    // Bundle up the answers to prepare to send to results page
                    bundle.putString("newTDEE", Double.toString(a));
                    bundle.putString("totProt", Double.toString(b));
                    bundle.putString("totFat", Double.toString(c));
                    bundle.putString("totCarb", Double.toString(d));

                    // if statement for when male, moderate, and maintain is checked
                } else if (male.isChecked() && moderate.isChecked() && maintain.isChecked()) {

                    // Algorithm to find exact macros from total calories split into Protein, Fat, and Carbohydrates
                    mREE = ((10*lb)+(6.25*(f+i))-(5*(Double.parseDouble(editAge.getText().toString())))+5);
                    mTDEE = (mREE*1.55);
                    newTDEE = mTDEE;
                    netProt = ((Double.parseDouble(editWeight.getText().toString()))*(0.825))*4;
                    netFat = (mTDEE*.25);
                    netCarb = (newTDEE - (netProt+netFat));
                    totProt = (netProt/4);
                    totFat = (netFat/9);
                    totCarb = (netCarb/4);

                    // Math conversion so that answer does not exceed 2 decimal places
                    double a = Math.round(newTDEE*100.0)/100.0;
                    double b = Math.round(totProt*100.0)/100.0;
                    double c = Math.round(totFat*100.0)/100.0;
                    double d = Math.round(totCarb*100.0)/100.0;

                    // Bundle up the answers to prepare to send to results page
                    bundle.putString("newTDEE", Double.toString(a));
                    bundle.putString("totProt", Double.toString(b));
                    bundle.putString("totFat", Double.toString(c));
                    bundle.putString("totCarb", Double.toString(d));

                    // if statement for when male, moderate, and gainmore is checked
                } else if (male.isChecked() && moderate.isChecked() && gainmore.isChecked()) {

                    // Algorithm to find exact macros from total calories split into Protein, Fat, and Carbohydrates
                    mREE = ((10*lb)+(6.25*(f+i))-(5*(Double.parseDouble(editAge.getText().toString())))+5);
                    mTDEE = (mREE*1.55);
                    newTDEE = mTDEE + (mTDEE*.2);
                    netProt = ((Double.parseDouble(editWeight.getText().toString()))*(0.825))*4;
                    netFat = (newTDEE*.25);
                    netCarb = (newTDEE - (netProt+netFat));
                    totProt = (netProt/4);
                    totFat = (netFat/9);
                    totCarb = (netCarb/4);

                    // Math conversion so that answer does not exceed 2 decimal places
                    double a = Math.round(newTDEE*100.0)/100.0;
                    double b = Math.round(totProt*100.0)/100.0;
                    double c = Math.round(totFat*100.0)/100.0;
                    double d = Math.round(totCarb*100.0)/100.0;

                    // Bundle up the answers to prepare to send to results page
                    bundle.putString("newTDEE", Double.toString(a));
                    bundle.putString("totProt", Double.toString(b));
                    bundle.putString("totFat", Double.toString(c));
                    bundle.putString("totCarb", Double.toString(d));

                    // if statement for when male, moderate, and gainless is checked
                } else if (male.isChecked() && moderate.isChecked() && gainless.isChecked()) {

                    // Algorithm to find exact macros from total calories split into Protein, Fat, and Carbohydrates
                    mREE = ((10*lb)+(6.25*(f+i))-(5*(Double.parseDouble(editAge.getText().toString())))+5);
                    mTDEE = (mREE*1.55);
                    newTDEE = mTDEE + (mTDEE*.1);
                    netProt = ((Double.parseDouble(editWeight.getText().toString()))*(0.825))*4;
                    netFat = (newTDEE*.25);
                    netCarb = (newTDEE - (netProt+netFat));
                    totProt = (netProt/4);
                    totFat = (netFat/9);
                    totCarb = (netCarb/4);

                    // Math conversion so that answer does not exceed 2 decimal places
                    double a = Math.round(newTDEE*100.0)/100.0;
                    double b = Math.round(totProt*100.0)/100.0;
                    double c = Math.round(totFat*100.0)/100.0;
                    double d = Math.round(totCarb*100.0)/100.0;

                    // Bundle up the answers to prepare to send to results page
                    bundle.putString("newTDEE", Double.toString(a));
                    bundle.putString("totProt", Double.toString(b));
                    bundle.putString("totFat", Double.toString(c));
                    bundle.putString("totCarb", Double.toString(d));

                    // if statement for when male, extreme, and losemore is checked
                } else if (male.isChecked() && extreme.isChecked() && losemore.isChecked()) {

                    // Algorithm to find exact macros from total calories split into Protein, Fat, and Carbohydrates
                    mREE = ((10*lb)+(6.25*(f+i))-(5*(Double.parseDouble(editAge.getText().toString())))+5);
                    mTDEE = (mREE*1.725);
                    newTDEE = mTDEE - (mTDEE*.2);
                    netProt = ((Double.parseDouble(editWeight.getText().toString()))*(0.825))*4;
                    netFat = (newTDEE*.25);
                    netCarb = (newTDEE - (netProt+netFat));
                    totProt = (netProt/4);
                    totFat = (netFat/9);
                    totCarb = (netCarb/4);

                    // Math conversion so that answer does not exceed 2 decimal places
                    double a = Math.round(newTDEE*100.0)/100.0;
                    double b = Math.round(totProt*100.0)/100.0;
                    double c = Math.round(totFat*100.0)/100.0;
                    double d = Math.round(totCarb*100.0)/100.0;

                    // Bundle up the answers to prepare to send to results page
                    bundle.putString("newTDEE", Double.toString(a));
                    bundle.putString("totProt", Double.toString(b));
                    bundle.putString("totFat", Double.toString(c));
                    bundle.putString("totCarb", Double.toString(d));

                    // if statement for when male, extreme, and loseless is checked
                } else if (male.isChecked() && extreme.isChecked() && loseless.isChecked()) {

                    // Algorithm to find exact macros from total calories split into Protein, Fat, and Carbohydrates
                    mREE = ((10*lb)+(6.25*(f+i))-(5*(Double.parseDouble(editAge.getText().toString())))+5);
                    mTDEE = (mREE*1.725);
                    newTDEE = mTDEE - (mTDEE*.1);
                    netProt = ((Double.parseDouble(editWeight.getText().toString()))*(0.825))*4;
                    netFat = (newTDEE*.25);
                    netCarb = (newTDEE - (netProt+netFat));
                    totProt = (netProt/4);
                    totFat = (netFat/9);
                    totCarb = (netCarb/4);

                    // Math conversion so that answer does not exceed 2 decimal places
                    double a = Math.round(newTDEE*100.0)/100.0;
                    double b = Math.round(totProt*100.0)/100.0;
                    double c = Math.round(totFat*100.0)/100.0;
                    double d = Math.round(totCarb*100.0)/100.0;

                    // Bundle up the answers to prepare to send to results page
                    bundle.putString("newTDEE", Double.toString(a));
                    bundle.putString("totProt", Double.toString(b));
                    bundle.putString("totFat", Double.toString(c));
                    bundle.putString("totCarb", Double.toString(d));

                    // if statement for when male, extreme, and maintain is checked
                } else if (male.isChecked() && extreme.isChecked() && maintain.isChecked()) {

                    // Algorithm to find exact macros from total calories split into Protein, Fat, and Carbohydrates
                    mREE = ((10*lb)+(6.25*(f+i))-(5*(Double.parseDouble(editAge.getText().toString())))+5);
                    mTDEE = (mREE*1.725);
                    newTDEE = mTDEE;
                    netProt = ((Double.parseDouble(editWeight.getText().toString()))*(0.825))*4;
                    netFat = (mTDEE*.25);
                    netCarb = (newTDEE - (netProt+netFat));
                    totProt = (netProt/4);
                    totFat = (netFat/9);
                    totCarb = (netCarb/4);

                    // Math conversion so that answer does not exceed 2 decimal places
                    double a = Math.round(newTDEE*100.0)/100.0;
                    double b = Math.round(totProt*100.0)/100.0;
                    double c = Math.round(totFat*100.0)/100.0;
                    double d = Math.round(totCarb*100.0)/100.0;

                    // Bundle up the answers to prepare to send to results page
                    bundle.putString("newTDEE", Double.toString(a));
                    bundle.putString("totProt", Double.toString(b));
                    bundle.putString("totFat", Double.toString(c));
                    bundle.putString("totCarb", Double.toString(d));

                    // if statement for when male, extreme, and gainmore is checked
                } else if (male.isChecked() && extreme.isChecked() && gainmore.isChecked()) {

                    // Algorithm to find exact macros from total calories split into Protein, Fat, and Carbohydrates
                    mREE = ((10*lb)+(6.25*(f+i))-(5*(Double.parseDouble(editAge.getText().toString())))+5);
                    mTDEE = (mREE*1.725);
                    newTDEE = mTDEE + (mTDEE*.2);
                    netProt = ((Double.parseDouble(editWeight.getText().toString()))*(0.825))*4;
                    netFat = (newTDEE*.25);
                    netCarb = (newTDEE - (netProt+netFat));
                    totProt = (netProt/4);
                    totFat = (netFat/9);
                    totCarb = (netCarb/4);

                    // Math conversion so that answer does not exceed 2 decimal places
                    double a = Math.round(newTDEE*100.0)/100.0;
                    double b = Math.round(totProt*100.0)/100.0;
                    double c = Math.round(totFat*100.0)/100.0;
                    double d = Math.round(totCarb*100.0)/100.0;

                    // Bundle up the answers to prepare to send to results page
                    bundle.putString("newTDEE", Double.toString(a));
                    bundle.putString("totProt", Double.toString(b));
                    bundle.putString("totFat", Double.toString(c));
                    bundle.putString("totCarb", Double.toString(d));

                    // if statement for when male, extreme, and gainless is checked
                } else if (male.isChecked() && extreme.isChecked() && gainless.isChecked()) {

                    // Algorithm to find exact macros from total calories split into Protein, Fat, and Carbohydrates
                    mREE = ((10*lb)+(6.25*(f+i))-(5*(Double.parseDouble(editAge.getText().toString())))+5);
                    mTDEE = (mREE*1.725);
                    newTDEE = mTDEE + (mTDEE*.1);
                    netProt = ((Double.parseDouble(editWeight.getText().toString()))*(0.825))*4;
                    netFat = (newTDEE*.25);
                    netCarb = (newTDEE - (netProt+netFat));
                    totProt = (netProt/4);
                    totFat = (netFat/9);
                    totCarb = (netCarb/4);

                    // Math conversion so that answer does not exceed 2 decimal places
                    double a = Math.round(newTDEE*100.0)/100.0;
                    double b = Math.round(totProt*100.0)/100.0;
                    double c = Math.round(totFat*100.0)/100.0;
                    double d = Math.round(totCarb*100.0)/100.0;

                    // Bundle up the answers to prepare to send to results page
                    bundle.putString("newTDEE", Double.toString(a));
                    bundle.putString("totProt", Double.toString(b));
                    bundle.putString("totFat", Double.toString(c));
                    bundle.putString("totCarb", Double.toString(d));
                }

                // if statement for when female, sedentary, and losemore is checked
                if (female.isChecked() && sedentary.isChecked() && losemore.isChecked()) {

                    // Algorithm to find exact macros from total calories split into Protein, Fat, and Carbohydrates
                    fREE = ((10*lb)+(6.25*(f+i))-(5*(Double.parseDouble(editAge.getText().toString())))-161);
                    fTDEE = (fREE*1.2);
                    newTDEE = fTDEE - (fTDEE*.2);
                    netProt = ((Double.parseDouble(editWeight.getText().toString()))*(0.825))*4;
                    netFat = (newTDEE*.25);
                    netCarb = (newTDEE - (netProt+netFat));
                    totProt = (netProt/4);
                    totFat = (netFat/9);
                    totCarb = (netCarb/4);

                    // Math conversion so that answer does not exceed 2 decimal places
                    double a = Math.round(newTDEE*100.0)/100.0;
                    double b = Math.round(totProt*100.0)/100.0;
                    double c = Math.round(totFat*100.0)/100.0;
                    double d = Math.round(totCarb*100.0)/100.0;

                    // Bundle up the answers to prepare to send to results page
                    bundle.putString("newTDEE", Double.toString(a));
                    bundle.putString("totProt", Double.toString(b));
                    bundle.putString("totFat", Double.toString(c));
                    bundle.putString("totCarb", Double.toString(d));

                    // if statement for when female, sedentary, and loseless is checked
                } else if (female.isChecked() && sedentary.isChecked() && loseless.isChecked()) {

                    // Algorithm to find exact macros from total calories split into Protein, Fat, and Carbohydrates
                    fREE = ((10*lb)+(6.25*(f+i))-(5*(Double.parseDouble(editAge.getText().toString())))-161);
                    fTDEE = (fREE*1.2);
                    newTDEE = fTDEE - (fTDEE*.1);
                    netProt = ((Double.parseDouble(editWeight.getText().toString()))*(0.825))*4;
                    netFat = (newTDEE*.25);
                    netCarb = (newTDEE - (netProt+netFat));
                    totProt = (netProt/4);
                    totFat = (netFat/9);
                    totCarb = (netCarb/4);

                    // Math conversion so that answer does not exceed 2 decimal places
                    double a = Math.round(newTDEE*100.0)/100.0;
                    double b = Math.round(totProt*100.0)/100.0;
                    double c = Math.round(totFat*100.0)/100.0;
                    double d = Math.round(totCarb*100.0)/100.0;

                    // Bundle up the answers to prepare to send to results page
                    bundle.putString("newTDEE", Double.toString(a));
                    bundle.putString("totProt", Double.toString(b));
                    bundle.putString("totFat", Double.toString(c));
                    bundle.putString("totCarb", Double.toString(d));

                    // if statement for when female, sedentary, and maintain is checked
                } else if (female.isChecked() && sedentary.isChecked() && maintain.isChecked()) {

                    // Algorithm to find exact macros from total calories split into Protein, Fat, and Carbohydrates
                    fREE = ((10*lb)+(6.25*(f+i))-(5*(Double.parseDouble(editAge.getText().toString())))-161);
                    fTDEE = (fREE*1.2);
                    newTDEE = fTDEE;
                    netProt = ((Double.parseDouble(editWeight.getText().toString()))*(0.825))*4;
                    netFat = (newTDEE*.25);
                    netCarb = (newTDEE - (netProt+netFat));
                    totProt = (netProt/4);
                    totFat = (netFat/9);
                    totCarb = (netCarb/4);

                    // Math conversion so that answer does not exceed 2 decimal places
                    double a = Math.round(newTDEE*100.0)/100.0;
                    double b = Math.round(totProt*100.0)/100.0;
                    double c = Math.round(totFat*100.0)/100.0;
                    double d = Math.round(totCarb*100.0)/100.0;

                    // Bundle up the answers to prepare to send to results page
                    bundle.putString("newTDEE", Double.toString(a));
                    bundle.putString("totProt", Double.toString(b));
                    bundle.putString("totFat", Double.toString(c));
                    bundle.putString("totCarb", Double.toString(d));

                    // if statement for when female, sedentary, and gainmore is checked
                } else if (female.isChecked() && sedentary.isChecked() && gainmore.isChecked()) {

                    // Algorithm to find exact macros from total calories split into Protein, Fat, and Carbohydrates
                    fREE = ((10*lb)+(6.25*(f+i))-(5*(Double.parseDouble(editAge.getText().toString())))-161);
                    fTDEE = (fREE*1.2);
                    newTDEE = fTDEE + (fTDEE*.2);
                    netProt = ((Double.parseDouble(editWeight.getText().toString()))*(0.825))*4;
                    netFat = (newTDEE*.25);
                    netCarb = (newTDEE - (netProt+netFat));
                    totProt = (netProt/4);
                    totFat = (netFat/9);
                    totCarb = (netCarb/4);

                    // Math conversion so that answer does not exceed 2 decimal places
                    double a = Math.round(newTDEE*100.0)/100.0;
                    double b = Math.round(totProt*100.0)/100.0;
                    double c = Math.round(totFat*100.0)/100.0;
                    double d = Math.round(totCarb*100.0)/100.0;

                    // Bundle up the answers to prepare to send to results page
                    bundle.putString("newTDEE", Double.toString(a));
                    bundle.putString("totProt", Double.toString(b));
                    bundle.putString("totFat", Double.toString(c));
                    bundle.putString("totCarb", Double.toString(d));

                    // if statement for when female, sedentary, and gainless is checked
                } else if (female.isChecked() && sedentary.isChecked() && gainless.isChecked()) {

                    // Algorithm to find exact macros from total calories split into Protein, Fat, and Carbohydrates
                    fREE = ((10*lb)+(6.25*(f+i))-(5*(Double.parseDouble(editAge.getText().toString())))-161);
                    fTDEE = (fREE*1.2);
                    newTDEE = fTDEE + (fTDEE*.1);
                    netProt = ((Double.parseDouble(editWeight.getText().toString()))*(0.825))*4;
                    netFat = (newTDEE*.25);
                    netCarb = (newTDEE - (netProt+netFat));
                    totProt = (netProt/4);
                    totFat = (netFat/9);
                    totCarb = (netCarb/4);

                    // Math conversion so that answer does not exceed 2 decimal places
                    double a = Math.round(newTDEE*100.0)/100.0;
                    double b = Math.round(totProt*100.0)/100.0;
                    double c = Math.round(totFat*100.0)/100.0;
                    double d = Math.round(totCarb*100.0)/100.0;

                    // Bundle up the answers to prepare to send to results page
                    bundle.putString("newTDEE", Double.toString(a));
                    bundle.putString("totProt", Double.toString(b));
                    bundle.putString("totFat", Double.toString(c));
                    bundle.putString("totCarb", Double.toString(d));

                    // if statement for when female, light, and losemore is checked
                } else if (female.isChecked() && light.isChecked() && losemore.isChecked()) {

                    // Algorithm to find exact macros from total calories split into Protein, Fat, and Carbohydrates
                    fREE = ((10*lb)+(6.25*(f+i))-(5*(Double.parseDouble(editAge.getText().toString())))-161);
                    fTDEE = (fREE*1.375);
                    newTDEE = fTDEE - (fTDEE*.2);
                    netProt = ((Double.parseDouble(editWeight.getText().toString()))*(0.825))*4;
                    netFat = (newTDEE*.25);
                    netCarb = (newTDEE - (netProt+netFat));
                    totProt = (netProt/4);
                    totFat = (netFat/9);
                    totCarb = (netCarb/4);

                    // Math conversion so that answer does not exceed 2 decimal places
                    double a = Math.round(newTDEE*100.0)/100.0;
                    double b = Math.round(totProt*100.0)/100.0;
                    double c = Math.round(totFat*100.0)/100.0;
                    double d = Math.round(totCarb*100.0)/100.0;

                    // Bundle up the answers to prepare to send to results page
                    bundle.putString("newTDEE", Double.toString(a));
                    bundle.putString("totProt", Double.toString(b));
                    bundle.putString("totFat", Double.toString(c));
                    bundle.putString("totCarb", Double.toString(d));

                    // if statement for when female, light, and loseless is checked
                } else if (female.isChecked() && light.isChecked() && loseless.isChecked()) {

                    // Algorithm to find exact macros from total calories split into Protein, Fat, and Carbohydrates
                    fREE = ((10*lb)+(6.25*(f+i))-(5*(Double.parseDouble(editAge.getText().toString())))-161);
                    fTDEE = (fREE*1.375);
                    newTDEE = fTDEE - (fTDEE*.1);
                    netProt = ((Double.parseDouble(editWeight.getText().toString()))*(0.825))*4;
                    netFat = (newTDEE*.25);
                    netCarb = (newTDEE - (netProt+netFat));
                    totProt = (netProt/4);
                    totFat = (netFat/9);
                    totCarb = (netCarb/4);

                    // Math conversion so that answer does not exceed 2 decimal places
                    double a = Math.round(newTDEE*100.0)/100.0;
                    double b = Math.round(totProt*100.0)/100.0;
                    double c = Math.round(totFat*100.0)/100.0;
                    double d = Math.round(totCarb*100.0)/100.0;

                    // Bundle up the answers to prepare to send to results page
                    bundle.putString("newTDEE", Double.toString(a));
                    bundle.putString("totProt", Double.toString(b));
                    bundle.putString("totFat", Double.toString(c));
                    bundle.putString("totCarb", Double.toString(d));

                    // if statement for when female, light, and maintain is checked
                } else if (female.isChecked() && light.isChecked() && maintain.isChecked()) {

                    // Algorithm to find exact macros from total calories split into Protein, Fat, and Carbohydrates
                    fREE = ((10*lb)+(6.25*(f+i))-(5*(Double.parseDouble(editAge.getText().toString())))-161);
                    fTDEE = (fREE*1.375);
                    newTDEE = fTDEE;
                    netProt = ((Double.parseDouble(editWeight.getText().toString()))*(0.825))*4;
                    netFat = (newTDEE*.25);
                    netCarb = (newTDEE - (netProt+netFat));
                    totProt = (netProt/4);
                    totFat = (netFat/9);
                    totCarb = (netCarb/4);

                    // Math conversion so that answer does not exceed 2 decimal places
                    double a = Math.round(newTDEE*100.0)/100.0;
                    double b = Math.round(totProt*100.0)/100.0;
                    double c = Math.round(totFat*100.0)/100.0;
                    double d = Math.round(totCarb*100.0)/100.0;

                    // Bundle up the answers to prepare to send to results page
                    bundle.putString("newTDEE", Double.toString(a));
                    bundle.putString("totProt", Double.toString(b));
                    bundle.putString("totFat", Double.toString(c));
                    bundle.putString("totCarb", Double.toString(d));
                    // if statement for when female, light, and gainmore is checked
                } else if (female.isChecked() && light.isChecked() && gainmore.isChecked()) {

                    // Algorithm to find exact macros from total calories split into Protein, Fat, and Carbohydrates
                    fREE = ((10*lb)+(6.25*(f+i))-(5*(Double.parseDouble(editAge.getText().toString())))-161);
                    fTDEE = (fREE*1.375);
                    newTDEE = fTDEE + (fTDEE*.2);
                    netProt = ((Double.parseDouble(editWeight.getText().toString()))*(0.825))*4;
                    netFat = (newTDEE*.25);
                    netCarb = (newTDEE - (netProt+netFat));
                    totProt = (netProt/4);
                    totFat = (netFat/9);
                    totCarb = (netCarb/4);

                    // Math conversion so that answer does not exceed 2 decimal places
                    double a = Math.round(newTDEE*100.0)/100.0;
                    double b = Math.round(totProt*100.0)/100.0;
                    double c = Math.round(totFat*100.0)/100.0;
                    double d = Math.round(totCarb*100.0)/100.0;

                    // Bundle up the answers to prepare to send to results page
                    bundle.putString("newTDEE", Double.toString(a));
                    bundle.putString("totProt", Double.toString(b));
                    bundle.putString("totFat", Double.toString(c));
                    bundle.putString("totCarb", Double.toString(d));

                    // if statement for when female, light, and gainless is checked
                } else if (female.isChecked() && light.isChecked() && gainless.isChecked()) {

                    // Algorithm to find exact macros from total calories split into Protein, Fat, and Carbohydrates
                    fREE = ((10*lb)+(6.25*(f+i))-(5*(Double.parseDouble(editAge.getText().toString())))-161);
                    fTDEE = (fREE*1.375);
                    newTDEE = fTDEE + (fTDEE*.1);
                    netProt = ((Double.parseDouble(editWeight.getText().toString()))*(0.825))*4;
                    netFat = (newTDEE*.25);
                    netCarb = (newTDEE - (netProt+netFat));
                    totProt = (netProt/4);
                    totFat = (netFat/9);
                    totCarb = (netCarb/4);

                    // Math conversion so that answer does not exceed 2 decimal places
                    double a = Math.round(newTDEE*100.0)/100.0;
                    double b = Math.round(totProt*100.0)/100.0;
                    double c = Math.round(totFat*100.0)/100.0;
                    double d = Math.round(totCarb*100.0)/100.0;

                    // Bundle up the answers to prepare to send to results page
                    bundle.putString("newTDEE", Double.toString(a));
                    bundle.putString("totProt", Double.toString(b));
                    bundle.putString("totFat", Double.toString(c));
                    bundle.putString("totCarb", Double.toString(d));

                    // if statement for when female, moderate, and losemore is checked
                } else if (female.isChecked() && moderate.isChecked() && losemore.isChecked()) {

                    // Algorithm to find exact macros from total calories split into Protein, Fat, and Carbohydrates
                    fREE = ((10*lb)+(6.25*(f+i))-(5*(Double.parseDouble(editAge.getText().toString())))-161);
                    fTDEE = (fREE*1.55);
                    newTDEE = fTDEE - (fTDEE*.2);
                    netProt = ((Double.parseDouble(editWeight.getText().toString()))*(0.825))*4;
                    netFat = (newTDEE*.25);
                    netCarb = (newTDEE - (netProt+netFat));
                    totProt = (netProt/4);
                    totFat = (netFat/9);
                    totCarb = (netCarb/4);

                    // Math conversion so that answer does not exceed 2 decimal places
                    double a = Math.round(newTDEE*100.0)/100.0;
                    double b = Math.round(totProt*100.0)/100.0;
                    double c = Math.round(totFat*100.0)/100.0;
                    double d = Math.round(totCarb*100.0)/100.0;

                    // Bundle up the answers to prepare to send to results page
                    bundle.putString("newTDEE", Double.toString(a));
                    bundle.putString("totProt", Double.toString(b));
                    bundle.putString("totFat", Double.toString(c));
                    bundle.putString("totCarb", Double.toString(d));

                    // if statement for when female, moderate, and loseless is checked
                } else if (female.isChecked() && moderate.isChecked() && loseless.isChecked()) {

                    // Algorithm to find exact macros from total calories split into Protein, Fat, and Carbohydrates
                    fREE = ((10*lb)+(6.25*(f+i))-(5*(Double.parseDouble(editAge.getText().toString())))-161);
                    fTDEE = (fREE*1.55);
                    newTDEE = fTDEE - (fTDEE*.1);
                    netProt = ((Double.parseDouble(editWeight.getText().toString()))*(0.825))*4;
                    netFat = (newTDEE*.25);
                    netCarb = (newTDEE - (netProt+netFat));
                    totProt = (netProt/4);
                    totFat = (netFat/9);
                    totCarb = (netCarb/4);

                    // Math conversion so that answer does not exceed 2 decimal places
                    double a = Math.round(newTDEE*100.0)/100.0;
                    double b = Math.round(totProt*100.0)/100.0;
                    double c = Math.round(totFat*100.0)/100.0;
                    double d = Math.round(totCarb*100.0)/100.0;

                    // Bundle up the answers to prepare to send to results page
                    bundle.putString("newTDEE", Double.toString(a));
                    bundle.putString("totProt", Double.toString(b));
                    bundle.putString("totFat", Double.toString(c));
                    bundle.putString("totCarb", Double.toString(d));

                    // if statement for when female, moderate, and maintain is checked
                } else if (female.isChecked() && moderate.isChecked() && maintain.isChecked()) {

                    // Algorithm to find exact macros from total calories split into Protein, Fat, and Carbohydrates
                    fREE = ((10*lb)+(6.25*(f+i))-(5*(Double.parseDouble(editAge.getText().toString())))-161);
                    fTDEE = (fREE*1.55);
                    newTDEE = fTDEE;
                    netProt = ((Double.parseDouble(editWeight.getText().toString()))*(0.825))*4;
                    netFat = (newTDEE*.25);
                    netCarb = (newTDEE - (netProt+netFat));
                    totProt = (netProt/4);
                    totFat = (netFat/9);
                    totCarb = (netCarb/4);

                    // Math conversion so that answer does not exceed 2 decimal places
                    double a = Math.round(newTDEE*100.0)/100.0;
                    double b = Math.round(totProt*100.0)/100.0;
                    double c = Math.round(totFat*100.0)/100.0;
                    double d = Math.round(totCarb*100.0)/100.0;

                    // Bundle up the answers to prepare to send to results page
                    bundle.putString("newTDEE", Double.toString(a));
                    bundle.putString("totProt", Double.toString(b));
                    bundle.putString("totFat", Double.toString(c));
                    bundle.putString("totCarb", Double.toString(d));

                    // if statement for when female, moderate, and gainmore is checked
                } else if (female.isChecked() && moderate.isChecked() && gainmore.isChecked()) {

                    // Algorithm to find exact macros from total calories split into Protein, Fat, and Carbohydrates
                    fREE = ((10*lb)+(6.25*(f+i))-(5*(Double.parseDouble(editAge.getText().toString())))-161);
                    fTDEE = (fREE*1.55);
                    newTDEE = fTDEE + (fTDEE*.2);
                    netProt = ((Double.parseDouble(editWeight.getText().toString()))*(0.825))*4;
                    netFat = (newTDEE*.25);
                    netCarb = (newTDEE - (netProt+netFat));
                    totProt = (netProt/4);
                    totFat = (netFat/9);
                    totCarb = (netCarb/4);

                    // Math conversion so that answer does not exceed 2 decimal places
                    double a = Math.round(newTDEE*100.0)/100.0;
                    double b = Math.round(totProt*100.0)/100.0;
                    double c = Math.round(totFat*100.0)/100.0;
                    double d = Math.round(totCarb*100.0)/100.0;

                    // Bundle up the answers to prepare to send to results page
                    bundle.putString("newTDEE", Double.toString(a));
                    bundle.putString("totProt", Double.toString(b));
                    bundle.putString("totFat", Double.toString(c));
                    bundle.putString("totCarb", Double.toString(d));

                    // if statement for when female, moderate, and gainless is checked
                } else if (female.isChecked() && moderate.isChecked() && gainless.isChecked()) {

                    // Algorithm to find exact macros from total calories split into Protein, Fat, and Carbohydrates
                    fREE = ((10*lb)+(6.25*(f+i))-(5*(Double.parseDouble(editAge.getText().toString())))-161);
                    fTDEE = (fREE*1.55);
                    newTDEE = fTDEE + (fTDEE*.1);
                    netProt = ((Double.parseDouble(editWeight.getText().toString()))*(0.825))*4;
                    netFat = (newTDEE*.25);
                    netCarb = (newTDEE - (netProt+netFat));
                    totProt = (netProt/4);
                    totFat = (netFat/9);
                    totCarb = (netCarb/4);

                    // Math conversion so that answer does not exceed 2 decimal places
                    double a = Math.round(newTDEE*100.0)/100.0;
                    double b = Math.round(totProt*100.0)/100.0;
                    double c = Math.round(totFat*100.0)/100.0;
                    double d = Math.round(totCarb*100.0)/100.0;

                    // Bundle up the answers to prepare to send to results page
                    bundle.putString("newTDEE", Double.toString(a));
                    bundle.putString("totProt", Double.toString(b));
                    bundle.putString("totFat", Double.toString(c));
                    bundle.putString("totCarb", Double.toString(d));

                    // if statement for when female, extreme, and losemore is checked
                } else if (female.isChecked() && extreme.isChecked() && losemore.isChecked()) {

                    // Algorithm to find exact macros from total calories split into Protein, Fat, and Carbohydrates
                    fREE = ((10*lb)+(6.25*(f+i))-(5*(Double.parseDouble(editAge.getText().toString())))-161);
                    fTDEE = (fREE*1.725);
                    newTDEE = fTDEE - (fTDEE*.2);
                    netProt = ((Double.parseDouble(editWeight.getText().toString()))*(0.825))*4;
                    netFat = (newTDEE*.25);
                    netCarb = (newTDEE - (netProt+netFat));
                    totProt = (netProt/4);
                    totFat = (netFat/9);
                    totCarb = (netCarb/4);

                    // Math conversion so that answer does not exceed 2 decimal places
                    double a = Math.round(newTDEE*100.0)/100.0;
                    double b = Math.round(totProt*100.0)/100.0;
                    double c = Math.round(totFat*100.0)/100.0;
                    double d = Math.round(totCarb*100.0)/100.0;

                    // Bundle up the answers to prepare to send to results page
                    bundle.putString("newTDEE", Double.toString(a));
                    bundle.putString("totProt", Double.toString(b));
                    bundle.putString("totFat", Double.toString(c));
                    bundle.putString("totCarb", Double.toString(d));

                    // if statement for when female, extreme, and loseless is checked
                } else if (female.isChecked() && extreme.isChecked() && loseless.isChecked()) {

                    // Algorithm to find exact macros from total calories split into Protein, Fat, and Carbohydrates
                    fREE = ((10*lb)+(6.25*(f+i))-(5*(Double.parseDouble(editAge.getText().toString())))-161);
                    fTDEE = (fREE*1.725);
                    newTDEE = fTDEE - (fTDEE*.1);
                    netProt = ((Double.parseDouble(editWeight.getText().toString()))*(0.825))*4;
                    netFat = (newTDEE*.25);
                    netCarb = (newTDEE - (netProt+netFat));
                    totProt = (netProt/4);
                    totFat = (netFat/9);
                    totCarb = (netCarb/4);

                    // Math conversion so that answer does not exceed 2 decimal places
                    double a = Math.round(newTDEE*100.0)/100.0;
                    double b = Math.round(totProt*100.0)/100.0;
                    double c = Math.round(totFat*100.0)/100.0;
                    double d = Math.round(totCarb*100.0)/100.0;

                    // Bundle up the answers to prepare to send to results page
                    bundle.putString("newTDEE", Double.toString(a));
                    bundle.putString("totProt", Double.toString(b));
                    bundle.putString("totFat", Double.toString(c));
                    bundle.putString("totCarb", Double.toString(d));

                    // if statement for when female, extreme, and maintain is checked
                } else if (female.isChecked() && extreme.isChecked() && maintain.isChecked()) {

                    // Algorithm to find exact macros from total calories split into Protein, Fat, and Carbohydrates
                    fREE = ((10*lb)+(6.25*(f+i))-(5*(Double.parseDouble(editAge.getText().toString())))-161);
                    fTDEE = (fREE*1.725);
                    newTDEE = fTDEE;
                    netProt = ((Double.parseDouble(editWeight.getText().toString()))*(0.825))*4;
                    netFat = (newTDEE*.25);
                    netCarb = (newTDEE - (netProt+netFat));
                    totProt = (netProt/4);
                    totFat = (netFat/9);
                    totCarb = (netCarb/4);

                    // Math conversion so that answer does not exceed 2 decimal places
                    double a = Math.round(newTDEE*100.0)/100.0;
                    double b = Math.round(totProt*100.0)/100.0;
                    double c = Math.round(totFat*100.0)/100.0;
                    double d = Math.round(totCarb*100.0)/100.0;

                    // Bundle up the answers to prepare to send to results page
                    bundle.putString("newTDEE", Double.toString(a));
                    bundle.putString("totProt", Double.toString(b));
                    bundle.putString("totFat", Double.toString(c));
                    bundle.putString("totCarb", Double.toString(d));

                    // if statement for when female, extreme, and gainmore is checked
                } else if (female.isChecked() && extreme.isChecked() && gainmore.isChecked()) {

                    // Algorithm to find exact macros from total calories split into Protein, Fat, and Carbohydrates
                    fREE = ((10*lb)+(6.25*(f+i))-(5*(Double.parseDouble(editAge.getText().toString())))-161);
                    fTDEE = (fREE*1.725);
                    newTDEE = fTDEE + (fTDEE*.2);
                    netProt = ((Double.parseDouble(editWeight.getText().toString()))*(0.825))*4;
                    netFat = (newTDEE*.25);
                    netCarb = (newTDEE - (netProt+netFat));
                    totProt = (netProt/4);
                    totFat = (netFat/9);
                    totCarb = (netCarb/4);

                    // Math conversion so that answer does not exceed 2 decimal places
                    double a = Math.round(newTDEE*100.0)/100.0;
                    double b = Math.round(totProt*100.0)/100.0;
                    double c = Math.round(totFat*100.0)/100.0;
                    double d = Math.round(totCarb*100.0)/100.0;

                    // Bundle up the answers to prepare to send to results page
                    bundle.putString("newTDEE", Double.toString(a));
                    bundle.putString("totProt", Double.toString(b));
                    bundle.putString("totFat", Double.toString(c));
                    bundle.putString("totCarb", Double.toString(d));

                    // if statement for when female, extreme, and gainless is checked
                } else if (female.isChecked() && extreme.isChecked() && gainless.isChecked()) {

                    // Algorithm to find exact macros from total calories split into Protein, Fat, and Carbohydrates
                    fREE = ((10*lb)+(6.25*(f+i))-(5*(Double.parseDouble(editAge.getText().toString())))-161);
                    fTDEE = (fREE*1.725);
                    newTDEE = fTDEE + (fTDEE*.1);
                    netProt = ((Double.parseDouble(editWeight.getText().toString()))*(0.825))*4;
                    netFat = (newTDEE*.25);
                    netCarb = (newTDEE - (netProt+netFat));
                    totProt = (netProt/4);
                    totFat = (netFat/9);
                    totCarb = (netCarb/4);

                    // Math conversion so that answer does not exceed 2 decimal places
                    double a = Math.round(newTDEE*100.0)/100.0;
                    double b = Math.round(totProt*100.0)/100.0;
                    double c = Math.round(totFat*100.0)/100.0;
                    double d = Math.round(totCarb*100.0)/100.0;

                    // Bundle up the answers to prepare to send to results page
                    bundle.putString("newTDEE", Double.toString(a));
                    bundle.putString("totProt", Double.toString(b));
                    bundle.putString("totFat", Double.toString(c));
                    bundle.putString("totCarb", Double.toString(d));
                }

                // Setting all bundled values into a bundle
                intent.putExtras(bundle);

                // Start activity/intent to MacroResults page
                startActivity(intent);
            }
        });
    }
}
