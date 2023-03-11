package com.amadeuszx.stringcalculator.v1;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StringCalculatorTest {
    private final StringCalculator stringCalculator = new StringCalculator();

    @ParameterizedTest
    @MethodSource("examplesStep1")
    void addStep1(String input, int expected) {
        final int result = stringCalculator.add(input);
        assertEquals(expected, result);
    }

    public static Stream<Arguments> examplesStep1() {
        return Stream.of(
                Arguments.of("", 0),
                Arguments.of(",", 0),
                Arguments.of(",1", 1),
                Arguments.of("1,", 1),
                Arguments.of("1,1", 2),
                Arguments.of("-9,-9", -18),
                Arguments.of("x,2", 2),
                Arguments.of("2,x", 2)
        );
    }

    @ParameterizedTest
    @MethodSource("examplesStep2")
    void addStep2(String input, int expected) {
        final int result = stringCalculator.add(input);
        assertEquals(expected, result);
    }

    public static Stream<Arguments> examplesStep2() {
        return Stream.of(
                Arguments.of(",,", 0),
                Arguments.of(",,1", 1),
                Arguments.of("1,1,1", 3),
                Arguments.of("-9,-9,9", -9),
                Arguments.of("x,2, ", 2),
                Arguments.of(" ,2,x", 2)
        );
    }

    @ParameterizedTest
    @MethodSource("examplesStep3")
    void addStep3(String input, int expected) {
        final int result = stringCalculator.add(input);
        assertEquals(expected, result);
    }

    public static Stream<Arguments> examplesStep3() {
        return Stream.of(
                Arguments.of("1\\n2,3", 6),
                Arguments.of("1,\\n", 1),
                Arguments.of("1,1\n1", 3),
                Arguments.of("-9\n-9,-9\\n-9", -36)
        );
    }

    @ParameterizedTest
    @MethodSource("examplesStep4")
    void addStep4(String input, int expected) {
        final int result = stringCalculator.add(input);
        assertEquals(expected, result);
    }

    public static Stream<Arguments> examplesStep4() {
        return Stream.of(
                Arguments.of("//d\n1d2d3", 6),
                Arguments.of("//;\\n1;2", 3)
        );
    }
}