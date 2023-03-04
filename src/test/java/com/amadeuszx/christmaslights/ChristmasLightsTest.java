package com.amadeuszx.christmaslights;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ChristmasLightsTest {

    public static final Point POINT_5_5 = new Point(5, 5);
    private final ChristmasLights christmasLights = new ChristmasLights();

    @Test
    void countReturnZeroWhenNothingOn() {
        assertEquals(0, christmasLights.count());
    }

    @ParameterizedTest
    @MethodSource("corners")
    void turnOnOneWhichWasOff(Point point) {
        christmasLights.turnOn(point);
        assertEquals(1, christmasLights.count());
    }

    @Test
    void multipleOnNothingChange() {
        christmasLights.turnOn(POINT_5_5);
        christmasLights.turnOn(POINT_5_5);
        assertEquals(1, christmasLights.count());
    }


    @Test
    void turnOffWhenWasntSetReturnZero() {
        christmasLights.turnOff(POINT_5_5);
        assertEquals(0, christmasLights.count());
    }

    @Test
    void turnOffDisableField() {
        christmasLights.turnOn(POINT_5_5);
        assertEquals(1, christmasLights.count());

        christmasLights.turnOff(POINT_5_5);
        assertEquals(0, christmasLights.count());
    }

    @Test
    void multipleOffNothingChange() {
        christmasLights.turnOff(POINT_5_5);
        christmasLights.turnOff(POINT_5_5);
        assertEquals(0, christmasLights.count());
    }

    @Test
    void toggleWhenWasntSetReturnOne() {
        christmasLights.toggle(POINT_5_5);
        assertEquals(1, christmasLights.count());
    }

    @Test
    void toggleWhenWasSetToOffReturnOne() {
        christmasLights.turnOff(POINT_5_5);
        assertEquals(0, christmasLights.count());

        christmasLights.toggle(POINT_5_5);
        assertEquals(1, christmasLights.count());
    }

    @Test
    void toggleWhenWasSetToOnReturnZero() {
        christmasLights.turnOn(POINT_5_5);
        assertEquals(1, christmasLights.count());

        christmasLights.toggle(POINT_5_5);
        assertEquals(0, christmasLights.count());
    }

    private static Stream<Arguments> corners() {
        return Stream.of(
                Arguments.of(new Point(0, 0)),
                Arguments.of(new Point(0, 999)),
                Arguments.of(new Point(999, 0)),
                Arguments.of(new Point(999, 999))
        );
    }
}