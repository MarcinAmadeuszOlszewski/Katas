package com.amadeuszx.romannumerals.v1;

/**
 * https://kata-log.rocks/roman-numerals-kata
 */
public class RomanNumerals {

    public String convert(int number) {
        Step step = new Step("", number);

        if (step.getNumber() / 1000 < 4) {
            step.setResult("M".repeat(step.getNumber() / 1000));
            step.setNumber(1000);
        }

        if (step.getNumber() / 900 == 1) {
            step.setResult("CM");
            step.setNumber(900);
        }

        if (step.getNumber() / 500 == 1) {
            step.setResult("D");
            step.setNumber(500);
        }

        if (step.getNumber() / 400 == 1) {
            step.setResult("CD");
            step.setNumber(400);
        }

        if (step.getNumber() / 100 < 4) {
            step.setResult("C".repeat(step.getNumber() / 100));
            step.setNumber(100);
        }

        if (step.getNumber() / 90 == 1) {
            step.setResult("XC");
            step.setNumber(90);
        }

        if (step.getNumber() / 50 == 1) {
            step.setResult("L");
            step.setNumber(50);
        }

        if (step.getNumber() / 40 == 1) {
            step.setResult("XL");
            step.setNumber(40);
        }

        if (step.getNumber() / 10 < 4) {
            step.setResult("X".repeat(step.getNumber() / 10));
            step.setNumber(10);
        }

        if (step.getNumber() / 9 == 1) {
            step.setResult("IX".repeat(1));
            step.setNumber(9);
        }

        if (step.getNumber() / 5 == 1) {
            step.setResult("V".repeat(1));
            step.setNumber(5);
        }

        if (step.getNumber() / 4 == 1) {
            step.setResult("IV".repeat(1));
            step.setNumber(4);
        }

        if (step.getNumber() < 4) {
            step.setResult("I".repeat(step.getNumber()));
        }

        return step.getResult();
    }

    private static class Step {
        private String result;
        private int number;

        public Step(String result, int number) {
            this.result = result;
            this.number = number;
        }

        public String getResult() {
            return result;
        }

        public void setResult(String result) {
            this.result += result;
        }

        public int getNumber() {
            return number;
        }

        public void setNumber(int modulo) {
            this.number %= modulo;
        }
    }
}
