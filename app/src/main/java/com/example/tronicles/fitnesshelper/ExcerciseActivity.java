package com.example.tronicles.fitnesshelper;

/**
 * Created by Andrzej on 4/25/2018.
 */


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.List;

public class ExcerciseActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    ListView listView;
    ListAdapter listAdapter;
    String ExcercisesName[]=new String [] {"Pushups", "Situps", "Weights"};
    Integer EXLength[]=new Integer [] {5, 10, 15};
    String ExTimes []=new String [] {"1:00","1:30","2:00","3:00","4:00","5:00","6:00","7:00","8:00","9:00","9:30","10:00","10:30","11:00","12:00","12:30"};
    Integer EXHTimes[] =new Integer []{1,2,3,4,5,6,7,8,9,10,11,12};
    Integer EXMTimes[] = new Integer[] {1,2,3,4,5,6,7,8,9,10,
            11,12,13,14,15,16,17,18,19,20,
            21,22,23,24,25,26,27,28,29,30,
            31,32,33,34,35,36,37,38,39,40,
            41,42,43,44,45,46,47,48,49,50,
            51,52,53,54,55,56,57,58,59,60};
    String Time[]=new String[] {"AM","PM"};
    Button Button1, Button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_excercises);
        Button1 = (Button) findViewById(R.id.button);//get id of button 1
        Button2 = (Button) findViewById(R.id.button2);//get id of button 2

        final Spinner spinner=(Spinner) findViewById(R.id.spinner);//Excercise name spinner
        final Spinner spinner2=(Spinner) findViewById(R.id.spinner2);//Set spinner
        final Spinner spinner3=(Spinner) findViewById(R.id.spinner3);//Hour spinner
        final Spinner spinner4=(Spinner) findViewById(R.id.spinner4);//AM/PM spinner
        final Spinner spinner5=(Spinner) findViewById(R.id.spinner5);
        //Creating the ArrayAdapter instance having the array lists
        ArrayAdapter spin1 = new ArrayAdapter(this,android.R.layout.simple_spinner_item,ExcercisesName);//setting array adapter spin 1 with values of ExcercisesName
        spin1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ArrayAdapter spin2;
        spin2 = new ArrayAdapter(this,android.R.layout.simple_spinner_item, EXLength);//setting the value spinner with values from ExLength
        spin2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ArrayAdapter spin3 = new ArrayAdapter(this,android.R.layout.simple_spinner_item,EXHTimes);//setting Hour spinner with values from array
        spin3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ArrayAdapter spin4 = new ArrayAdapter(this,android.R.layout.simple_spinner_item,Time);//seting spinner for to AM or PM value adapter
        spin4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);//
        ArrayAdapter spin5 = new ArrayAdapter(this,android.R.layout.simple_spinner_item,EXMTimes);//setting spinner 5 to time in minutes adapter
        spin5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Setting the ArrayAdapter data on the Spinner
        spinner.setAdapter(spin1);
        spinner2.setAdapter(spin2);
        spinner3.setAdapter(spin3);
        spinner4.setAdapter(spin4);
        spinner5.setAdapter(spin5);
        final SqlHelper db = new SqlHelper(this);
        List<Excercises> list = db.getAllExcercisess();
        listView = (ListView)findViewById(R.id.routinelist);
        listAdapter = new CustomAdapter(list,ExcerciseActivity.this );
        listView.setAdapter(listAdapter);

        Button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Excercise Added", Toast.LENGTH_LONG).show();//display the text of button1
                String spinner1SlctdVal = spinner.getSelectedItem().toString();
                Integer spinner1SlctdVal2 = (Integer)spinner2.getSelectedItem();
                String spinner1SlctdVal3 = spinner3.getSelectedItem().toString();
                String spinner1SlctdVal5 = spinner5.getSelectedItem().toString();
                String spinner1SlctdVal4 = spinner4.getSelectedItem().toString();

                String formatTime = Utils.formatTime(spinner1SlctdVal3, spinner1SlctdVal5,spinner1SlctdVal4);

                // String formatTime = spinner1SlctdVal3 + ":" + spinner1SlctdVal5 + ":" + spinner1SlctdVal4;
                db.addExcercise(new Excercises(spinner1SlctdVal, spinner1SlctdVal2,formatTime));
//figure out how to reloed databse in real time
                //namesAdapter.notifyDataSetChanged();
                //adapter.notifyDataSetChanged();
                //db.notifyDataSetChanged();
                //listAdapter.notifyDataSetChanged();
                List<Excercises> list = db.getAllExcercisess();
                listView = (ListView)findViewById(R.id.routinelist);
                listAdapter = new CustomAdapter(list,ExcerciseActivity.this );
                listView.setAdapter(listAdapter);
                //listView.invalidateViews();
            }
        });
        /*  Button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TextView idTextView = (TextView)findViewById(R.id.textViewId);
                int id = Integer.parseInt(idTextView.getText().toString());
                db.deleteExcercise(id);
                Toast.makeText(getApplicationContext(), "Excercise Deleted", Toast.LENGTH_LONG).show();//display the text of button2
            }
        });*/

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(getApplicationContext(), ExcercisesName[position], Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
// TODO Auto-generated method stub
    }
}
