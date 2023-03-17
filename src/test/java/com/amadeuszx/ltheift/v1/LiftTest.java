package com.amadeuszx.ltheift.v1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LiftTest {
    /**
     * a lift responds to calls containing a source floor and direction
     * !a lift has an attribute floor, which describes it’s current location
     * !a lift delivers passengers to requested floors
     * ! you may implement current floor monitor
     * you may implement direction arrows
     * you may implement doors (opening and closing)
     * !you may implement DING!
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
        lift.setCurrentFloor(5);
        final String currentFloor = lift.showCurrentFloor();
        assertEquals("5", currentFloor);
    }

    @ParameterizedTest
    @MethodSource("move")
    @DisplayName("a lift delivers passengers to requested floors")
    void deliveryInformation(int current, int destination, String expected) {
        lift.setCurrentFloor(current);
        lift.setDestination(destination);
        final String moveInformation = lift.showMoveInformation();
        assertEquals(expected, moveInformation);
    }

    @ParameterizedTest
    @MethodSource("door")
    @DisplayName("doors (opening and closing)")
    void doorState(int current, int destination, String expected) {
        lift.setCurrentFloor(current);
        lift.setDestination(destination);
        final String doorState = lift.doorState();
        assertEquals(expected, doorState);
    }

    private static Stream<Arguments> move() {
        return Stream.of(
                Arguments.of(5, 3, "Moving...\n4\nMoving...\n3\nDING!"),
                Arguments.of(3, 5, "Moving...\n4\nMoving...\n5\nDING!"),
                Arguments.of(4, 4, "DING!")
        );
    }

    private static Stream<Arguments> door() {
        return Stream.of(
                Arguments.of(5, 3, "Door closed."),
                Arguments.of(3, 5, "Door closed."),
                Arguments.of(4, 4, "Door open.")
        );
    }
}