package com.amadeuszx.christmaslights;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertThrows;

class PointTest {
    @ParameterizedTest
    @MethodSource("cornersExc")
    void toggleIndexOutOfBoudnException(int x, int y) {
        assertThrows(IndexOutOfBoundsException.class, () -> new Point(x, y));
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