package com.amadeuszx.ltheift.v1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LiftManagerTest {
    /**
     * a lift responds to calls containing a source floor and direction
     * you may implement direction arrows
     * ! there can be more than one lift
     */
    final LiftManager manager = new LiftManager(2);

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
}