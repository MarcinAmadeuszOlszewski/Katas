package com.amadeuszx.stringcalculator.v1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * https://kata-log.rocks/string-calculator-kata
 */
public class StringCalculator {

    public int add(String toAdd) {
        String s = toAdd.replace("\n", ",").replace("\\n", ",");

        s = handleNewDelimiter(s);

        final String[] split = s.split(",");
        final List<Integer> converted = Arrays.stream(split).map(StringCalculator::getParseInt).toList();

        handleNegativeNumbers(converted);

        return converted.stream()
                .filter(i -> i <= 1_000)
                .mapToInt(i -> i)
                .sum();
    }

    private void handleNegativeNumbers(List<Integer> converted) {
        final List<Integer> illegals = converted.stream().filter(i -> i < 0).toList();
        if (!illegals.isEmpty()) {
            final String toException = illegals.stream().map(Object::toString).collect(Collectors.joining(", "));
            throw new IllegalArgumentException("negatives not allowed " + toException);
        }
    }

    private String handleNewDelimiter(String s) {
        String delimiter = findDelimiter(s);
        if (!delimiter.isEmpty()) {
            s = s.substring(s.indexOf(","))
                    .replace(delimiter, ",");
        }
        return s;
    }

    private String findDelimiter(String s) {
        if (s.startsWith("//[")) {
            return s.replace("//[", "")
                    .split("],")[0];
        }
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
