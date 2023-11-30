package com.example.timesupparty;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Explicacion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explicacion);
    }
    public void volver(View view){
        Intent retorno = new Intent(this, MainActivity.class);
        startActivity(retorno);
    }
    public void jugar(View view){
        Intent start = new Intent(this, Empezamos.class);
        startActivity(start);
    }
}