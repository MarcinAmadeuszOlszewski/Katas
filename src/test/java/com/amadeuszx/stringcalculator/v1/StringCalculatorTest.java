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
    @MethodSource("examples")
    void addStep(String input, int expected) {
        final int result = stringCalculator.add(input);
        assertEquals(expected, result);
    }

    public static Stream<Arguments> examples() {
        return Stream.of(
                Arguments.of("", 0),
                Arguments.of(",", 0),
                Arguments.of(",1", 1),
                Arguments.of("1,", 1),
                Arguments.of("1,1", 2),
                Arguments.of("x,2", 2),
                Arguments.of("2,x", 2),
                Arguments.of(",,", 0),
                Arguments.of(",,1", 1),
                Arguments.of("1,1,1", 3),
                Arguments.of("x,2, ", 2),
                Arguments.of(" ,2,x", 2),
                Arguments.of("1\\n2,3", 6),
                Arguments.of("1,\\n", 1),
                Arguments.of("1,1\n1", 3),
                Arguments.of("//d\n1d2d3", 6),
                Arguments.of("//;\\n1;2", 3),
                Arguments.of("//,\\n1,2", 3),
                Arguments.of("//xx\\n1,2\n3\\n4xx5", 15),
                Arguments.of("1001,2", 2),
                Arguments.of("1001,1000", 1_000),
                Arguments.of("//[***]\n1***2***3", 6),
                Arguments.of("//[*][%]\n1*2%3", 6),
                Arguments.of("//[**][%%%][;;;;]\n1**2%%%3;;;;4", 10)
        );
    }

    @ParameterizedTest
    @MethodSource("negativeValues")
    void negativeValuesShouldThrowException(String input, String expected) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> stringCalculator.add(input));
        assertEquals(expected, exception.getMessage());
    }

    public static Stream<Arguments> negativeValues() {
        return Stream.of(
                Arguments.of("//d\n-1d2d3", "negatives not allowed -1"),
                Arguments.of("\\n-1,3,-2", "negatives not allowed -1, -2"),
                Arguments.of("\\n-1,-2", "negatives not allowed -1, -2")
        );
    }
}