package com.example.timesupparty;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Empezamos extends AppCompatActivity {
    EditText equipo1;
    EditText equipo2;
    TextView letrero;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empezamos);
        equipo1 = findViewById(R.id.equipo1);
        equipo2 = findViewById(R.id.equipo2);
        letrero = findViewById(R.id.letrero);
        equipo1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                letrero.setText("Comienza el equipo: "+equipo1.getText());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
    public void jugar(View view){
        String primero="EQUIPO 1";
        if(!equipo1.getText().toString().isEmpty()){
            primero = equipo1.getText().toString();
        }
        String segundo="EQUIPO 2";
        if(!equipo2.getText().toString().isEmpty()){
            segundo = equipo2.getText().toString();
        }
        Bundle extras = new Bundle();
        extras.putString("equipo1", primero);
        extras.putString("equipo2", segundo);
        Intent jugar = new Intent(this, Partida.class);
        jugar.putExtras(extras);
        startActivity(jugar);
    }
}