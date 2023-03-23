package com.amadeuszx.ltheift.v1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LiftManagerTest {
    /**
     * !a lift responds to calls containing a source floor and direction
     * # you may implement direction arrows
     * ! there can be more than one lift
     * <p>
     * # - useless, currently impossible to call moving Lift, everything happens in 0 time
     */
    final LiftManager manager = new LiftManager(2);

    @Test
    void minLiftCountEquals1() {
        assertThrows(IllegalArgumentException.class, () -> new LiftManager(0));
        assertDoesNotThrow(() -> new LiftManager(1));
    }

    @Test
    void create2LiftsOn0Lev() {
        final String positions = manager.showCurrentPositions();

        final String expected = """
                1:0
                2:0""";
        assertEquals(expected, positions);
    }

    @Test
    void callLiftFrom0To3() {
        manager.call(3, Direction.UP);
        final String positions = manager.showCurrentPositions();
        final String expected = """
                1:3
                2:0""";
        assertEquals(expected, positions);
    }

    @Test
    void callLiftFrom0To0() {
        LiftManager manager0 = new LiftManager(1);
        manager0.call(0, Direction.UP);
        final String positions = manager0.showCurrentPositions();
        final String expected = """
                1:0""";
        assertEquals(expected, positions);
    }

    @Test
    void callClosestLift() {
        manager.call(7, Direction.UP);
        manager.call(2, Direction.DOWN);
        final String positions = manager.showCurrentPositions();
        final String expected = """
                1:7
                2:2""";
        assertEquals(expected, positions);
    }
}