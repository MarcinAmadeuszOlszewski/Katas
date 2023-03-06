package com.amadeuszx.manhattandistance.v1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ManhattanDistanceTest {

    private final ManhattanDistance manhattanDistance = new ManhattanDistance();

    @ParameterizedTest
    @MethodSource("points")
    void startAfterEndDiagonallyReturn2(Point begin, Point end, int expected) {
        final int distance = manhattanDistance.manhattanDistance(begin, end);
        assertEquals(expected, distance);
    }

    @Test
    void immutabilityTest() {
        final Point begin = new Point(0, 0);
        final Point end = new Point(1, 1);
        final int distance = manhattanDistance.manhattanDistance(begin, end);
        assertEquals(2, distance);

        final Point expectedBegin = new Point(0, 0);
        final Point expectedEnd = new Point(1, 1);
        assertEquals(expectedBegin, begin);
        assertEquals(expectedEnd, end);
    }

    private static Stream<Arguments> points() {
        return Stream.of(
                Arguments.of(new Point(0, 0), new Point(0, 0), 0),
                Arguments.of(new Point(0, 0), new Point(1, 0), 1),
                Arguments.of(new Point(0, 0), new Point(0, 1), 1),
                Arguments.of(new Point(0, 0), new Point(1, 1), 2),
                Arguments.of(new Point(1, 1), new Point(0, 0), 2),
                Arguments.of(new Point(0, 0), new Point(6, 6), 12),
                Arguments.of(new Point(-1, -1), new Point(0, 0), 2),
                Arguments.of(new Point(-1, 0), new Point(0, -1), 2)
        );
    }
}