package com.amadeuszx.ltheift.v1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LiftTest {
    /**
     * a lift responds to calls containing a source floor and direction
     * !a lift has an attribute floor, which describes it’s current location
     * !a lift delivers passengers to requested floors
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
        final String currentFloor = lift.showCurrentFloor();
        assertEquals("0", currentFloor);
    }

    @Test
    @DisplayName("a lift has an attribute floor, which describes it’s current location")
    void liftFloorState() {
        lift.setFloor(5);
        final String currentFloor = lift.showCurrentFloor();
        assertEquals("5", currentFloor);
    }

    @Test
    @DisplayName("a lift delivers passengers to requested floors")
    void deliveryInformation() {
        lift.setFloor(5);
        lift.setDestination(3);
        final String moveInformation = lift.showMoveInformation();
        assertEquals("2 floors down from 5 to 3", moveInformation);
    }

}