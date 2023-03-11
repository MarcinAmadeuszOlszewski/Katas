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

    @Test
    void addStringWithOnlyCommaReturn0() {
        final int result = stringCalculator.add(",");
        assertEquals(0, result);
    }

    @Test
    void addStringWithCommaAndNumberReturnNumber() {
        final int result = stringCalculator.add(",1");
        assertEquals(1, result);
    }

    @Test
    void addStringWithNumberAndCommaReturnNumber() {
        final int result = stringCalculator.add("1,");
        assertEquals(1, result);
    }

    @Test
    void addStringWithNumberAndNumberReturnNumber() {
        final int result = stringCalculator.add("1,1");
        assertEquals(2, result);
    }

}