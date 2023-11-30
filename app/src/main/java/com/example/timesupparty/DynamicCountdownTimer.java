package com.example.timesupparty;

public class DynamicCountdownTimer implements Runnable {
    private boolean isRunning = true;
    private TimerCallback timerCallback;

    public DynamicCountdownTimer(TimerCallback callback) {
        this.timerCallback = callback;
    }

    @Override
    public void run() {
        while (isRunning) {
            try {
                Thread.sleep(1000);
                timerCallback.onTimerTick();
                if (Partida.tiempo<=0) {
                    timerCallback.onTimerFinish();
                    isRunning = false;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void stopTimer() {
        isRunning = false;
    }

    public interface TimerCallback {
        void onTimerTick();
        void onTimerFinish();
    }
    public void resta() {
        if (Partida.tiempo > 15000) {
            Partida.tiempo = Partida.tiempo - 15000;
        } else {
            Partida.tiempo = 0;
        }
    }
}

