package com.codecool.api;

public class Timer implements Runnable {

    private int seconds;
    private Thread thread;
    private boolean isRunning = true;


    @Override
    public void run() {
        try {
            thread = Thread.currentThread();
            while (!thread.isInterrupted()) {
                if (isRunning) {
                    Thread.sleep(1000);
                    seconds++;
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public int getSeconds() {
        return seconds;
    }

    public void pause() {
        isRunning = false;
    }

    public void resume() {
        isRunning = true;
    }

    public long getId() {
        return thread.getId();
    }
}
