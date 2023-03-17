package com.amadeuszx.ltheift.v1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LiftTest {
    /**
     * a lift responds to calls containing a source floor and direction
     * !a lift has an attribute floor, which describes it’s current location
     * a lift delivers passengers to requested floors
     * ! you may implement current floor monitor
     * you may implement direction arrows
     * you may implement doors (opening and closing)
     * you may implement DING!
     * there can be more than one lift
     */
    private final Lift lift = new Lift();

    @Test
    @DisplayName("current floor monitor")
    void currentFloorMonitor() {
        final String currentFloor = lift.showCurrentFlor();
        assertEquals("0", currentFloor);
    }

    @Test
    @DisplayName("a lift has an attribute floor, which describes it’s current location")
    void liftFloorState() {
        lift.setFloor(5);
        final String currentFloor = lift.showCurrentFlor();
        assertEquals("5", currentFloor);
    }

}