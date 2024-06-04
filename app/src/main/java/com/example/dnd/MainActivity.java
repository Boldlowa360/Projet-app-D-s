package com.example.dnd;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.dnd.databinding.ActivityMainBinding;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private Spinner spinner;
    private ActivityMainBinding binding;
    private static final String[] paths = {"Coin", "D4", "D6","D8","D10","D12","D20"};
    int nbFaces;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //binding
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View v = binding.getRoot();
        setContentView(v);
        //Spinner pour les choix
        spinner = (Spinner)findViewById(R.id.spinner);
        ArrayAdapter<String>adapter = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_spinner_item,paths);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
        btnLancer();
    }
    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        // TODO Auto-generated method stub
    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {
        binding.resultat.setText("");
        switch (position) {
            case 0:
                //Coin
                binding.imageView.setImageResource(R.drawable.coin);
                nbFaces = 2;
                break;
            case 1:
                //D4
                binding.imageView.setImageResource(R.drawable.d4);
                nbFaces = 4;
                break;
            case 2:
                //D6
                binding.imageView.setImageResource(R.drawable.d6);
                nbFaces = 6;
                break;
            case 3:
                //D8
                binding.imageView.setImageResource(R.drawable.d8);
                nbFaces = 8;
                break;
            case 4:
                //D10
                binding.imageView.setImageResource(R.drawable.d10);
                nbFaces = 10;
                break;
            case 5:
                //D12
                binding.imageView.setImageResource(R.drawable.d12);
                nbFaces = 12;
                break;
            case 6:
                //D20
                binding.imageView.setImageResource(R.drawable.d20);
                nbFaces = 20;
                break;

        }
    }
    public void btnLancer(){
        binding.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int result = lancer(nbFaces);
                if(nbFaces == 2){
                    binding.resultat.setTextColor(getColor(R.color.black));
                    switch (result){
                        case 1:
                            binding.resultat.setText(R.string.pile);
                            break;
                        case 2:
                            binding.resultat.setText(R.string.face);
                            break;
                    }

                }
                else{
                    binding.resultat.setText(result+"");
                    if(result == 1){
                        binding.resultat.setTextColor(getColor(R.color.critical1));
                    }else if(result == nbFaces){
                        binding.resultat.setTextColor(getColor(R.color.nat20));
                    }
                    else{
                        binding.resultat.setTextColor(getColor(R.color.black));
                    }
                }

            }
        });
    }
    public int lancer(int nbFaces){
        int result = new Random().nextInt(nbFaces)+1;
        return result;
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }
}