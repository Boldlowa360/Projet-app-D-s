package com.example.dnd;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private Spinner spinner;
    private static final String[] paths = {"item 1", "item 2", "item 3"};
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = (Spinner)findViewById(R.id.spinner);
        ArrayAdapter<String>adapter = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_spinner_item,paths);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
        for (Dices d:LesDes())
        {
            Log.i("Faces","" +d.faces);
        }

    }
    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        // TODO Auto-generated method stub
    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {

        switch (position) {
            case 0:
                // Whatever you want to happen when the first item gets selected
                break;
            case 1:
                // Whatever you want to happen when the second item gets selected
                break;
            case 2:
                // Whatever you want to happen when the thrid item gets selected
                break;

        }
    }

    public List<Dices> LesDes(){
        //création de la liste
        List<Dices> listDices = new ArrayList<>();
        //création des dés
        Dices dice2 = new Dices();
        Dices dice4 = new Dices();
        Dices dice6 = new Dices();
        Dices dice8 = new Dices();
        Dices dice10 = new Dices();
        Dices dice12= new Dices();
        Dices dice20 = new Dices();
        //ajout du nombre de faces
        dice2.faces = 2;
        dice4.faces = 4;
        dice6.faces = 6;
        dice8.faces = 8;
        dice10.faces = 10;
        dice12.faces = 12;
        dice20.faces = 20;
        //Ajout des dés dans la liste
        listDices.add(dice2);
        listDices.add(dice4);
        listDices.add(dice6);
        listDices.add(dice8);
        listDices.add(dice10);
        listDices.add(dice12);
        listDices.add(dice20);
        //retourne la liste
        return listDices;
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }
}