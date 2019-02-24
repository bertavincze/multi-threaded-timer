package com.codecool.cmd;

class Input {

    private final String input;

    Input(String input) {
        this.input = input;
    }

    boolean isExitRequest() {
        return input.equalsIgnoreCase("exit");
    }

    boolean isStartRequest() {
        return input.toLowerCase().startsWith("start");
    }

    String getTimerName() {
        return input.split(" ")[1];
    }

    boolean isPauseRequest() {
        return input.toLowerCase().startsWith("stop");
    }

    boolean isDisplayRequest() {
        return input.equalsIgnoreCase("check");
    }
}
