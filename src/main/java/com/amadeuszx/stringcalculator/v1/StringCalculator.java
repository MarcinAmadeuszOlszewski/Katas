package com.amadeuszx.stringcalculator.v1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * https://kata-log.rocks/string-calculator-kata
 */
public class StringCalculator {

    public int add(String toAdd) {
        final String unifiedDelimiters = unifyDelimiters(toAdd);

        final List<String> delimiters = findOptionalDelimiters(unifiedDelimiters);
        final String normalised = replaceDelimitersByDefaultValue(unifiedDelimiters, delimiters);

        final List<Integer> converted = convertToNumbers(normalised);

        handleNegativeNumbers(converted);

        return getSumFromNumberLessThan1k(converted);
    }

    private static String unifyDelimiters(String toAdd) {
        return toAdd.replace("\n", ",").replace("\\n", ",");
    }

    private List<String> findOptionalDelimiters(String s) {
        if (s.startsWith("//[")) {
            final String delimiters = s.substring(3, s.indexOf("],"));
            return Arrays.asList(delimiters.split("]\\["));
        }
        if (s.startsWith("//")) {
            return List.of(s.substring(2, s.indexOf(",")));
        }
        return List.of();
    }

    private static String replaceDelimitersByDefaultValue(String unifiedDelimiters, List<String> delimiters) {
        for (String d : delimiters) {
            unifiedDelimiters = unifiedDelimiters.replace(d, ",");
        }
        return unifiedDelimiters;
    }

    private static List<Integer> convertToNumbers(String normalised) {
        final String[] split = normalised.split(",");
        return Arrays.stream(split).map(StringCalculator::getParseInt).toList();
    }

    private static int getParseInt(String splitted) {
        try {
            return Integer.parseInt(splitted);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    private void handleNegativeNumbers(List<Integer> converted) {
        final List<Integer> illegals = converted.stream().filter(i -> i < 0).toList();
        if (!illegals.isEmpty()) {
            final String toException = illegals.stream().map(Object::toString).collect(Collectors.joining(", "));
            throw new IllegalArgumentException("negatives not allowed " + toException);
        }
    }

    private static int getSumFromNumberLessThan1k(List<Integer> converted) {
        return converted.stream()
                .filter(i -> i <= 1_000)
                .mapToInt(i -> i)
                .sum();
    }
}
