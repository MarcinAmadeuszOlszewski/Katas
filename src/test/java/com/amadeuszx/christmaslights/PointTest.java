package com.amadeuszx.christmaslights;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PointTest {
    @ParameterizedTest
    @MethodSource("corners")
    void pointCornerCases(int x, int y) {
        assertDoesNotThrow(() -> new Point(x, y));
    }

    @ParameterizedTest
    @MethodSource("cornersExc")
    void pointIndexOutOfBoudnException(int x, int y) {
        assertThrows(IndexOutOfBoundsException.class, () -> new Point(x, y));
    }

    private static Stream<Arguments> corners() {
        return Stream.of(
                Arguments.of(0, 0),
                Arguments.of(5, 5),
                Arguments.of(999, 999)
        );
    }


    private static Stream<Arguments> cornersExc() {
        return Stream.of(
                Arguments.of(-1, 5),
                Arguments.of(5, -1),
                Arguments.of(1000, 5),
                Arguments.of(5, 1000)
        );
    }
}