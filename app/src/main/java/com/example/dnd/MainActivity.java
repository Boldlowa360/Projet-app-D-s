package com.example.dnd;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        for (Dices d:LesDes())
        {
            Log.i("Faces","" +d.faces);
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
}