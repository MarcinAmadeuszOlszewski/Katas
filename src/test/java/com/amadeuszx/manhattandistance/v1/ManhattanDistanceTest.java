package com.amadeuszx.manhattandistance.v1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ManhattanDistanceTest {

    private final ManhattanDistance manhattanDistance = new ManhattanDistance();

    @Test
    void startAndEndSamePlaceReturn0() {
        Point begin = new Point(0, 0);
        final int distance = manhattanDistance.manhattanDistance(begin, begin);
        assertEquals(0, distance);
    }

    @Test
    void startAndEndSideBySideXReturn1() {
        Point begin = new Point(0, 0);
        Point end = new Point(1, 0);
        final int distance = manhattanDistance.manhattanDistance(begin, end);
        assertEquals(1, distance);
    }

    @Test
    void startAndEndSideBySideYReturn1() {
        Point begin = new Point(0, 0);
        Point end = new Point(0, 1);
        final int distance = manhattanDistance.manhattanDistance(begin, end);
        assertEquals(1, distance);
    }

    @Test
    void startAndEndDiagonallyReturn2() {
        Point begin = new Point(0, 0);
        Point end = new Point(1, 1);
        final int distance = manhattanDistance.manhattanDistance(begin, end);
        assertEquals(2, distance);
    }

    @Test
    void startAfterEndDiagonallyReturn2() {
        Point begin = new Point(1, 1);
        Point end = new Point(0, 0);
        final int distance = manhattanDistance.manhattanDistance(begin, end);
        assertEquals(2, distance);
    }

    @Test
    void immutabilityTest() {
        Point begin = new Point(0, 0);
        Point end = new Point(1, 1);
        final int distance = manhattanDistance.manhattanDistance(begin, end);
        assertEquals(2, distance);

        Point expectedBegin = new Point(0, 0);
        Point expectedEnd = new Point(1, 1);
        assertEquals(expectedBegin, begin);
        assertEquals(expectedEnd, end);
    }
}