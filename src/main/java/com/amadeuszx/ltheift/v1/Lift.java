package com.amadeuszx.ltheift.v1;

import java.util.stream.IntStream;

/**
 * https://kata-log.rocks/lift-kata
 */
public class Lift {
    private int currentFloor;
    private int destination;

    public String showCurrentFloor() {
        return String.valueOf(currentFloor);
    }

    int getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    public void setDestination(int destination) {
        this.destination = destination;
    }

    public String showMoveInformation() {
        StringBuilder out = new StringBuilder();

        if (currentFloor < destination) {
            IntStream.range(currentFloor + 1, destination + 1)
                    .forEachOrdered(i -> out.append("Moving...\n").append(i).append("\n"));
        } else if (currentFloor > destination) {
            IntStream.iterate(currentFloor - 1, i -> i - 1).limit(currentFloor - destination)
                    .forEachOrdered(i -> out.append("Moving...\n").append(i).append("\n"));
        }

        currentFloor = destination;
        out.append("DING!");

        return out.toString();
    }

    public String doorState() {
        return currentFloor == destination
                ? "Door open."
                : "Door closed.";
    }
}
