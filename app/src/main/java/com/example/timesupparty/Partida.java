package com.example.timesupparty;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class Partida extends AppCompatActivity {
    private static int order = 0;
    String equipo1;
    String equipo2;
    TextView turno;
    TextView pregunta;
    public static TextView time;
    public static int tiempo = 30000;
    int aciertos = 0;
    int fallos = 0;
    Button fallo;
    Button acierto;
    CountDownTimer conta;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partida);
        equipo1 = getIntent().getExtras().getString("equipo1");
        equipo2 = getIntent().getStringExtra("equipo2");
        turno = findViewById(R.id.turno);
        pregunta = findViewById(R.id.pregunta);
        time = findViewById(R.id.time);
        time.setText("30");
        fallo = findViewById(R.id.fallo);
        acierto = findViewById(R.id.acierto);
        if (order % 2 == 0) {
            turno.setText(equipo1);
        } else {
            turno.setText(equipo2);
        }
        order++;
        contador(tiempo);
    }
    public void contador(long inicio){
        conta= new CountDownTimer(inicio, 1000){
            @Override
            public void onTick(long l) {
                time.setText(""+l/1000);
                tiempo = (int)l;
            }

            @Override
            public void onFinish() {
                migracion();
            }
        }.start();
    }
    public void setFallo(View view) {
        fallos++;
        conta.cancel();
        contador(tiempo-15000);

    }
    public void migracion(){
        Bundle extras = new Bundle();
        extras.putInt("aciertos", aciertos);
        extras.putInt("fallos", fallos);
        Intent ronda = new Intent(this, PostRonda.class);
        ronda.putExtras(extras);
        startActivity(ronda);
    }
    public void setAcierto(View view) {
        aciertos++;
    }
}

