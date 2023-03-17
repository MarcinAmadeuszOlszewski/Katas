package com.amadeuszx.ltheift.v1;

/**
 * https://kata-log.rocks/lift-kata
 */
public class Lift {
    private int currentFloor;
    private int destination;

    public String showCurrentFloor() {
        return String.valueOf(currentFloor);
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    public void setDestination(int destination) {
        this.destination = destination;
    }

    public String showMoveInformation() {
        StringBuilder out = new StringBuilder();
        if (currentFloor > destination) {
            currentFloor--;
            for (; currentFloor >= destination; currentFloor--) {
                out.append("Moving...\n").append(showCurrentFloor()).append("\n");
            }
        } else if (currentFloor < destination) {
            currentFloor++;
            for (; currentFloor <= destination; currentFloor++) {
                out.append("Moving...\n").append(showCurrentFloor()).append("\n");
            }
        }

        out.append("DING!");

        return out.toString();
    }

    public String doorState() {
        return currentFloor == destination
                ? "Door open."
                : "Door closed.";
    }
}
