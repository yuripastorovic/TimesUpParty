package com.example.timesupparty;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class Partida extends AppCompatActivity implements DynamicCountdownTimer.TimerCallback{
    private static int order = 0;
    String equipo1;
    String equipo2;
    TextView turno;
    TextView pregunta;
    public static TextView time;
    public static int tiempo=30000;
    int aciertos=0;
    int fallos=0;
    Button fallo;
    Button acierto;

    private DynamicCountdownTimer pCountDownTimer;
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
        pCountDownTimer = new DynamicCountdownTimer(this);
        new Thread(pCountDownTimer).start();
    }
    public void setFallo(View view){
        pCountDownTimer.resta();
        fallos++;
    }
    public void setAcierto(View view){
        aciertos++;
    }
    @Override
    public void onTimerTick(/* tiempo restante */) {
        // Actualiza la interfaz de usuario con el tiempo restante
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                time.setText(""+(tiempo/1000));
            }
        });
    }

    @Override
    public void onTimerFinish() {
        // Lógica para manejar la finalización del temporizador
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                time.setText("END");
                Bundle extras = new Bundle();
                extras.putInt("aciertos", aciertos);
                extras.putInt("fallos", fallos);
                Intent ronda = new Intent(Partida.this, PostRonda.class);
                ronda.putExtras(extras);
                startActivity(ronda);
            }
        });
    }
}

