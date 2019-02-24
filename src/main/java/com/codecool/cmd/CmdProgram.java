package com.codecool.cmd;

import com.codecool.api.Timer;
import java.util.HashMap;
import java.util.Map;

class CmdProgram {

    private Map<String, Timer> timers = new HashMap<>();
    private Display ui;

    CmdProgram() {
        this.ui = new Display();
    }

    void run() {
        while (true) {
            ui.displayCommands();
            Input input = ui.getInput();
            if (input.isExitRequest()) {
                System.exit(0);
            } else if (input.isStartRequest()) {
                handleStartRequest(input);
            } else if (input.isPauseRequest()) {
                handlePauseRequest(input);
            } else if (input.isDisplayRequest()) {
                handleDisplay();
            }
        }
    }

    private void handleStartRequest(Input input) {
        String timerName = input.getTimerName();
        if (timers.containsKey(timerName)) {
            resumeTimer(timerName);
        } else {
            createTimer(timerName);
        }
    }

    private void handlePauseRequest(Input input) {
        String timerName = input.getTimerName();
        if (timers.containsKey(timerName)) {
            pauseTimer(timerName);
        } else {
            System.out.println("No such timer.");
        }
    }

    private void createTimer(String timerName) {
        Timer timer = new Timer();
        Thread thread = new Thread(timer);
        timers.put(timerName, timer);
        thread.start();
    }

    private void resumeTimer(String timerName) {
        Timer timer = timers.get(timerName);
        timer.resume();
    }

    private void pauseTimer(String timerName) {
        Timer timer = timers.get(timerName);
        timer.pause();
    }

    private void handleDisplay() {
        ui.displayTimers(timers);
    }
}
