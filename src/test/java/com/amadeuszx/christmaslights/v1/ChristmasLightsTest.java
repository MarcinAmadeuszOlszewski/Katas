package com.amadeuszx.christmaslights.v1;

import jdk.jfr.Description;
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
        christmasLights.turnOn(point, point);
        assertEquals(1, christmasLights.count());
    }

    @Test
    void turnOnMultipleTimesSummarise() {
        christmasLights.turnOn(POINT_5_5, POINT_5_5);
        christmasLights.turnOn(POINT_5_5, POINT_5_5);
        assertEquals(2, christmasLights.count());
    }

    @Test
    void turnOffWhenWasntSetReturnZero() {
        christmasLights.turnOff(POINT_5_5, POINT_5_5);
        assertEquals(0, christmasLights.count());
    }

    @Test
    void turnOffPreviously1Return0() {
        christmasLights.turnOn(POINT_5_5, POINT_5_5);
        assertEquals(1, christmasLights.count());

        christmasLights.turnOff(POINT_5_5, POINT_5_5);
        assertEquals(0, christmasLights.count());
    }

    @Test
    void turnOffPreviously2Return1() {
        christmasLights.turnOn(POINT_5_5, POINT_5_5);
        christmasLights.turnOn(POINT_5_5, POINT_5_5);
        christmasLights.turnOff(POINT_5_5, POINT_5_5);
        assertEquals(1, christmasLights.count());
    }

    @Test
    void turnOffTwoTimesPreviously1Return0() {
        christmasLights.turnOn(POINT_5_5, POINT_5_5);
        christmasLights.turnOff(POINT_5_5, POINT_5_5);
        christmasLights.turnOff(POINT_5_5, POINT_5_5);
        assertEquals(0, christmasLights.count());
    }

    @Test
    void toggleWhenWasSetToOffReturnTwo() {
        christmasLights.turnOff(POINT_5_5, POINT_5_5);
        assertEquals(0, christmasLights.count());

        christmasLights.toggle(POINT_5_5, POINT_5_5);
        assertEquals(2, christmasLights.count());
    }

    @Test
    void toggleWhenWasSetToOnReturnThree() {
        christmasLights.turnOn(POINT_5_5, POINT_5_5);
        assertEquals(1, christmasLights.count());

        christmasLights.toggle(POINT_5_5, POINT_5_5);
        assertEquals(3, christmasLights.count());
    }

    @ParameterizedTest
    @MethodSource("corners")
    void toggleOnOneWhichWasOff(Point point) {
        christmasLights.toggle(point, point);
        assertEquals(2, christmasLights.count());
    }

    @Test
    void togglenMultipleTimesSummarise() {
        christmasLights.toggle(POINT_5_5, POINT_5_5);
        christmasLights.toggle(POINT_5_5, POINT_5_5);
        assertEquals(4, christmasLights.count());
    }

    @Test
    @Description("turn on 0,0 through 999,999 would turn on (or leave on) every light.")
    void turnONRange() {
        christmasLights.turnOn(new Point(0, 0), new Point(999, 999));
        assertEquals(1_000_000, christmasLights.count());
    }

    @Test
    @Description("turn off 499,499 through 500,500 would turn off (or leave off) the middle four lights.")
    void turnOffRange() {
        turnONRange();
        christmasLights.turnOff(new Point(499, 499), new Point(500, 500));
        assertEquals(999_996, christmasLights.count());
    }

    @Test
    @Description("toggle 0,0 through 999,0 would toggle the first line of 1000 lights, turning off the ones that were on, and turning on the ones that were off.")
    void toggleRange() {
        turnONRange();
        christmasLights.toggle(new Point(0, 0), new Point(999, 0));
        assertEquals(1_002_000, christmasLights.count());
    }

    @Test
    void toggleTo4() {
        turnOffRange();
        christmasLights.toggle(new Point(0, 0), new Point(999, 999));
        assertEquals(2_999_996, christmasLights.count());
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