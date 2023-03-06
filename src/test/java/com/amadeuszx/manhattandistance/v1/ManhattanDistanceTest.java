package com.amadeuszx.manhattandistance.v1;

import jdk.jfr.Description;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ManhattanDistanceTest {

    private final ManhattanDistance manhattanDistance = new ManhattanDistance();

    @ParameterizedTest
    @MethodSource("points")
    void startAfterEndDiagonallyReturn2(Point begin, Point end, int expected) {
        final int distance = manhattanDistance.manhattanDistance(begin, end);
        assertEquals(expected, distance);
    }

    @Test
    @Description("The class Point has no Getters")
    void noGetters() {
        final Point point = new Point(12, 6);
        assertThrows(UnsupportedOperationException.class, point::x);
        assertThrows(UnsupportedOperationException.class, point::y);
    }

    @Test
    public void equalsHashCodeContracts() {
        EqualsVerifier.forClass(Point.class).verify();
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
                Arguments.of(new Point(2, 3), new Point(4, 6), 5),
                Arguments.of(new Point(-1, 0), new Point(0, -1), 2)
        );
    }
}