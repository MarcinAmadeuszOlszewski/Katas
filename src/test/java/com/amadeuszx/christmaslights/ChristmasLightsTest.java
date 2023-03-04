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
        christmasLights.turnOn(x, y);
        assertEquals(1, christmasLights.count());
    }

    @Test
    void multipleOnNothingChange() {
        christmasLights.turnOn(5, 5);
        christmasLights.turnOn(5, 5);
        assertEquals(1, christmasLights.count());
    }

    @ParameterizedTest
    @MethodSource("cornersExc")
    void turnOnIndexOutOfBoudnException(int x, int y) {
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> christmasLights.turnOn(x, y));
    }

    @Test
    void turnOffWhenWasntSetReturnZero() {
        christmasLights.turnOff(5, 5);
        assertEquals(0, christmasLights.count());
    }

    @Test
    void turnOffDisableField() {
        christmasLights.turnOn(5, 5);
        assertEquals(1, christmasLights.count());

        christmasLights.turnOff(5, 5);
        assertEquals(0, christmasLights.count());
    }

    @Test
    void multipleOffNothingChange() {
        christmasLights.turnOff(5, 5);
        christmasLights.turnOff(5, 5);
        assertEquals(0, christmasLights.count());
    }

    @ParameterizedTest
    @MethodSource("cornersExc")
    void turnOffIndexOutOfBoudnException(int x, int y) {
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> christmasLights.turnOff(x, y));
    }

    @Test
    void toggleWhenWasntSetReturnOne() {
        christmasLights.toggle(5, 5);
        assertEquals(1, christmasLights.count());
    }

    @Test
    void toggleWhenWasSetToOffReturnOne() {
        christmasLights.turnOff(5, 5);
        assertEquals(0, christmasLights.count());

        christmasLights.toggle(5, 5);
        assertEquals(1, christmasLights.count());
    }

    @Test
    void toggleWhenWasSetToOnReturnZero() {
        christmasLights.turnOn(5, 5);
        assertEquals(1, christmasLights.count());

        christmasLights.toggle(5, 5);
        assertEquals(0, christmasLights.count());
    }

    @ParameterizedTest
    @MethodSource("cornersExc")
    void toggleIndexOutOfBoudnException(int x, int y) {
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> christmasLights.toggle(x, y));
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