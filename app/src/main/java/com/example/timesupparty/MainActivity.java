package com.example.timesupparty;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button jugar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        jugar = findViewById(R.id.jugar);
    }
    public void jugar(View view){
        Intent iniciar = new Intent(this, Explicacion.class);
        startActivity(iniciar);
    }
}