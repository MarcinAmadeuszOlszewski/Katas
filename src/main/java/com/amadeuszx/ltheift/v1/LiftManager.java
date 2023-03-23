package com.amadeuszx.ltheift.v1;

import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class LiftManager {

    private final Map<Integer, Lift> lifts = new TreeMap<>();

    public LiftManager(int numbers) {
        for (int i = 1; i <= numbers; i++) {
            lifts.put(i, new Lift());
        }
    }

    public String showCurrentPositions() {
        return lifts.entrySet().stream()
                .map(e -> e.getKey() + ":" + e.getValue().showCurrentFloor() + "\n")
                .collect(Collectors.joining())
                .strip();
    }

    public void call(int destination, com.amadeuszx.ltheift.v1.Direction up) {

    }
}
