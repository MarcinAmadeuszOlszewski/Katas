package com.amadeuszx.romannumerals.v1;

/**
 * https://kata-log.rocks/roman-numerals-kata
 */
public class RomanNumerals {

    public String convert(int number) {
        String result = "";

        if (number / 1000 < 4) {
            result += "M".repeat(number / 1000);
            number = number % 1000;
        }

        if (number / 900 == 1) {
            result += "CM";
            number = number % 900;
        }

        if (number / 500 == 1) {
            result += "D";
            number = number % 500;
        }

        if (number / 400 == 1) {
            result += "CD";
            number = number % 400;
        }

        if (number / 100 < 4) {
            result += "C".repeat(number / 100);
            number = number % 100;
        }

        if (number / 90 == 1) {
            result += "XC";
            number = number % 90;
        }

        if (number / 50 == 1) {
            result += "L";
            number = number % 50;
        }

        if (number / 40 == 1) {
            result += "XL";
            number = number % 40;
        }

        if (number / 10 < 4) {
            result += "X".repeat(number / 10);
            number = number % 10;
        }

        if (number / 9 == 1) {
            result += "IX".repeat(1);
            number = number % 9;
        }

        if (number / 5 == 1) {
            result += "V".repeat(1);
            number = number % 5;
        }

        if (number / 4 == 1) {
            result += "IV".repeat(1);
            number = number % 4;
        }

        if (number < 4) {
            result += "I".repeat(number);
        }

        return result;
    }
}
