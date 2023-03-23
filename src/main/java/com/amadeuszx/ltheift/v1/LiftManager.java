package com.amadeuszx.ltheift.v1;

import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LiftManager {

    private final Map<Integer, Lift> lifts = new TreeMap<>();

    public LiftManager(int numbers) {
        if (numbers < 1) {
            throw new IllegalArgumentException();
        }
        IntStream.rangeClosed(1, numbers).forEach(i -> lifts.put(i, new Lift()));
    }

    public String showCurrentPositions() {
        return lifts.entrySet().stream()
                .map(e -> e.getKey() + ":" + e.getValue().showCurrentFloor() + "\n")
                .collect(Collectors.joining())
                .strip();
    }

    public void call(int destination, Direction up) {
        int distance = Integer.MAX_VALUE;
        Lift closestLift = lifts.get(1);
        for (Map.Entry<Integer, Lift> lift : lifts.entrySet()) {
            int tmpDistance = Math.abs(lift.getValue().getCurrentFloor() - destination);
            if (tmpDistance < distance) {
                distance = tmpDistance;
                closestLift = lift.getValue();
            }
        }
        closestLift.setCurrentFloor(destination);
    }
}
