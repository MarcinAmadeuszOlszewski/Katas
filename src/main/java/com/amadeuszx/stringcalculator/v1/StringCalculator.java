package com.amadeuszx.stringcalculator.v1;

import java.util.Arrays;

/**
 * https://kata-log.rocks/string-calculator-kata
 */
public class StringCalculator {

    public int add(String s) {
        final String[] split = s
                .replace("\n", ",")
                .replace("\\n", ",")
                .split(",");

        return Arrays.stream(split).mapToInt(StringCalculator::getParseInt).sum();
    }

    private static int getParseInt(String splitted) {
        try {
            return Integer.parseInt(splitted);
        } catch (Exception e) {
            return 0;
        }
    }
}
