package com.amadeuszx.stringcalculator.v1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StringCalculatorTest {
    private final StringCalculator stringCalculator = new StringCalculator();

    @Test
    void addEmptyStringReturn0() {
        final int result = stringCalculator.add("");
        assertEquals(0, result);
    }

}