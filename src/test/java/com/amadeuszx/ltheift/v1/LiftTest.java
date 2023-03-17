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
    @MethodSource("points")
    @DisplayName("a lift delivers passengers to requested floors")
    void deliveryInformation(int current, int destination, String expected) {
        lift.setCurrentFloor(current);
        lift.setDestination(destination);
        final String moveInformation = lift.showMoveInformation();
        System.err.println(moveInformation);
        System.err.println();
        assertEquals(expected, moveInformation);
    }

    private static String moving3to2Floors() {
        return "Moving...\n4\nMoving...\n3\nDone!";
    }

    private static Stream<Arguments> points() {
        return Stream.of(
                Arguments.of(5, 3, "Moving...\n4\nMoving...\n3\nDING!"),
                Arguments.of(3, 5, "Moving...\n4\nMoving...\n5\nDING!"),
                Arguments.of(4, 4, "DING!")
        );
    }
}