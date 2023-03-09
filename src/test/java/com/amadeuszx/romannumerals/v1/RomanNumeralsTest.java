package com.amadeuszx.romannumerals.v1;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RomanNumeralsTest {
    private final RomanNumerals converter = new RomanNumerals();

    @ParameterizedTest
    @MethodSource("examples")
    void returnMWhen1000(int number, String expected) {
        final String result = converter.convert(number);
        assertEquals(expected, result);
    }

    private static Stream<Arguments> examples() {
        return Stream.of(
                Arguments.of(1111, "MCXI"),
                Arguments.of(1311, "MCCCXI"),
                Arguments.of(3333, "MMMCCCXXXIII"),
                Arguments.of(1000, "M"),
                Arguments.of(666, "DCLXVI"),
                Arguments.of(500, "D"),
                Arguments.of(100, "C"),
                Arguments.of(50, "L"),
                Arguments.of(18, "XVIII"),
                Arguments.of(10, "X"),
                Arguments.of(8, "VIII"),
                Arguments.of(6, "VI"),
                Arguments.of(5, "V"),
                Arguments.of(1, "I")
        );
    }
}