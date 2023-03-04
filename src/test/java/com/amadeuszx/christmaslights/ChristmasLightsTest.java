package com.amadeuszx.christmaslights;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ChristmasLightsTest {

    private final ChristmasLights christmasLights = new ChristmasLights();

    @Test
    void countReturnZeroWhenNothingOn() {
        assertEquals(0, christmasLights.count());
    }

    @ParameterizedTest
    @MethodSource("corners")
    void turnOnOneWhichWasOff(int x, int y) {
        christmasLights.turnOne(x, y);
        assertEquals(1, christmasLights.count());
    }

    @ParameterizedTest
    @MethodSource("cornersExc")
    void indexOutOfBoudnException(int x, int y) {
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> christmasLights.turnOne(x, y));
    }

    private static Stream<Arguments> corners() {
        return Stream.of(
                Arguments.of(0, 0),
                Arguments.of(0, 999),
                Arguments.of(999, 0),
                Arguments.of(999, 999)
        );
    }

    private static Stream<Arguments> cornersExc() {
        return Stream.of(
                Arguments.of(-1, 0),
                Arguments.of(0, -1),
                Arguments.of(1000, 999),
                Arguments.of(999, 1000)
        );
    }
}