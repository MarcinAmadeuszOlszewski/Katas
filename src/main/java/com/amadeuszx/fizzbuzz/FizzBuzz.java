package com.amadeuszx.fizzbuzz;

/**
 * https://codingdojo.org/kata/FizzBuzz/
 */
public class FizzBuzz {
    public static void main(String[] args) {
        new FizzBuzz().print();
    }

    public void print() {
        for (int i = 1; i <= 100; i++) {
            System.out.println(count(i));
        }
    }

    String count(int i) {
        if (i < 1 || i > 100) {
            throw new IllegalArgumentException();
        }

        String result = "";

        if (String.valueOf(i).contains("3")) {
            result += "Fizz";
        }
        if (i % 3 == 0) {
            result += "Fizz";
        }

        if (String.valueOf(i).contains("5")) {
            result += "Buzz";
        }
        if (i % 5 == 0) {
            result += "Buzz";
        }

        if (result.isEmpty()) {
            result += String.valueOf(i);
        }
        return result;
    }
}
