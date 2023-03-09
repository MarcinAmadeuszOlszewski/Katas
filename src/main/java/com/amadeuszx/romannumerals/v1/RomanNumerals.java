package com.amadeuszx.romannumerals.v1;

/**
 * https://kata-log.rocks/roman-numerals-kata
 */
public class RomanNumerals {

    public String convert(int number) {
        String result = "";

        if (number / 1000 < 4) {
            result += "M".repeat(number / 1000);
        }
        number = number % 1000;

        if (number / 100 < 4) {
            result += "C".repeat(number / 100);
        }
        number = number % 100;

        if (number / 10 < 4) {
            result += "X".repeat(number / 10);
        }
        number = number % 10;

        if (number < 4) {
            result += "I".repeat(number);
        }

        return result;
    }
}
