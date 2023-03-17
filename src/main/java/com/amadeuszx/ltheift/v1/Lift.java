package com.amadeuszx.ltheift.v1;

/**
 * https://kata-log.rocks/lift-kata
 */
public class Lift {
    private int floor;

    public String showCurrentFloor() {
        return String.valueOf(floor);
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public void setDestination(int destination) {
    }

    public String showMoveInformation() {
        return null;
    }
}
