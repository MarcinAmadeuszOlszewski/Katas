package com.amadeuszx.stringcalculator.v1;

/**
 * https://kata-log.rocks/string-calculator-kata
 */
public class StringCalculator {

    public int add(String s) {
        final String[] split = s.split(",");
        if (split.length == 0 || s.isEmpty()) {
            return 0;
        }
        if (split.length == 1) {
            return getParseInt(split[0]);
        }
        return getParseInt(split[0]) + getParseInt(split[1]);
    }

    private static int getParseInt(String splitted) {
        try {
            return Integer.parseInt(splitted);
        } catch (Exception e) {
            return 0;
        }
    }
}
