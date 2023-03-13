package com.amadeuszx.stringcalculator.v1;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
                Arguments.of("1,1\n1", 3)
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
                Arguments.of("//;\\n1;2", 3),
                Arguments.of("//,\\n1,2", 3),
                Arguments.of("//xx\\n1,2\n3\\n4xx5", 15)
        );
    }

    @ParameterizedTest
    @MethodSource("examplesStep5")
    void addStep5(String input, String expected) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> stringCalculator.add(input));
        assertEquals(expected, exception.getMessage());
    }

    public static Stream<Arguments> examplesStep5() {
        return Stream.of(
                Arguments.of("//d\n-1d2d3", "negatives not allowed -1"),
                Arguments.of("\\n-1,3,-2", "negatives not allowed -1, -2"),
                Arguments.of("\\n-1,-2", "negatives not allowed -1, -2")
        );
    }

    @ParameterizedTest
    @MethodSource("examplesStep6")
    void addStep6(String input, int expected) {
        final int result = stringCalculator.add(input);
        assertEquals(expected, result);
    }

    public static Stream<Arguments> examplesStep6() {
        return Stream.of(
                Arguments.of("1001,2", 2),
                Arguments.of("1001,1000", 1_000)
        );
    }

    @ParameterizedTest
    @MethodSource("examplesStep7")
    void addStep7(String input, int expected) {
        final int result = stringCalculator.add(input);
        assertEquals(expected, result);
    }

    public static Stream<Arguments> examplesStep7() {
        return Stream.of(
                Arguments.of("//[***]\n1***2***3", 6)
        );
    }
}