package com.amadeuszx.stringcalculator.v1;

import java.util.Arrays;

/**
 * https://kata-log.rocks/string-calculator-kata
 */
public class StringCalculator {

    public int add(String s) {
        s = s.replace("\n", ",")
                .replace("\\n", ",");

        String delimiter = findDelimiter(s);

        final String[] split;
        if (delimiter.isEmpty()) {
            split = s.split(",");
        } else {
            split = s.substring(s.indexOf(","))
                    .replace(delimiter, ",")
                    .split(",");
        }

        return Arrays.stream(split).mapToInt(StringCalculator::getParseInt).sum();
    }

    private String findDelimiter(String s) {
        if (s.startsWith("//")) {
            return s.replace("//", "")
                    .split(",")[0];
        }
        return "";
    }

    private static int getParseInt(String splitted) {
        try {
            return Integer.parseInt(splitted);
        } catch (Exception e) {
            return 0;
        }
    }
}
