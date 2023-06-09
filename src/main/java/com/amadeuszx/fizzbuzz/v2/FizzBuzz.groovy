package com.amadeuszx.fizzbuzz.v2

/**
 * https://codingdojo.org/kata/FizzBuzz/
 */
class FizzBuzz {

    static String count(var number) {

        var result = ""
        if (number % 3 == 0) {
            result += "fizz"
        }
        if (number % 5 == 0) {
            result += "buzz"
        }
        if (result.isEmpty()) {
            result += number
        }
        result
    }
}