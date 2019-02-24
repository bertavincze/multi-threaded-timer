package com.codecool.cmd;

import com.codecool.api.Timer;
import java.util.Map;
import java.util.Scanner;

class Display {

    Input getInput() {
        Scanner sc = new Scanner(System.in);
        return new Input(sc.nextLine());
    }

    void displayCommands() {
        System.out.println("available commands: start (timer name), check, stop (timer name), exit\n");
    }

    void displayTimers(Map<String, Timer> timers) {
        for (String key : timers.keySet()) {
            Timer timer = timers.get(key);
            String template = "name: %s, thread id: %s, has been running for: %s seconds";
            System.out.println(String.format(template, key, timer.getId(), timer.getSeconds()));
        }
    }
}
