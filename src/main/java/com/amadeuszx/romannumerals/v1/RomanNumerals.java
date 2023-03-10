package com.amadeuszx.romannumerals.v1;

import java.util.List;

/**
 * https://kata-log.rocks/roman-numerals-kata
 */
public class RomanNumerals {

    private static final List<StepDefinition> STEPS = List.of(
            new StepDefinition(1000, "M"),
            new StepDefinition(900, "CM"),
            new StepDefinition(500, "D"),
            new StepDefinition(400, "CD"),
            new StepDefinition(100, "C"),
            new StepDefinition(90, "XC"),
            new StepDefinition(50, "L"),
            new StepDefinition(40, "XL"),
            new StepDefinition(10, "X"),
            new StepDefinition(9, "IX"),
            new StepDefinition(5, "V"),
            new StepDefinition(4, "IV"),
            new StepDefinition(1, "I")
    );

    public String convert(int number) {
        final StringBuilder result = new StringBuilder();

        for (StepDefinition def : STEPS) {
            result.append(def.romanValue().repeat(number / def.factor()));
            number %= def.factor();
        }

        return result.toString();
    }
}
