package com.amadeuszx.fizzbuzz.v2


import spock.lang.Specification

class FizzBuzzTest extends Specification {

    def "numbers examples"(int number, String expected) {
        expect:
        FizzBuzz.count(number) == expected

        where:
        number | expected
        1      | 1
        2      | 2
        3      | "fizz"
        4      | 4
        5      | "buzz"
        6      | "fizz"
        7      | 7
        9      | "fizz"
        10     | "buzz"
        12     | "fizz"
        15     | "fizzbuzz"
        20     | "buzz"
        25     | "buzz"
        30     | "fizzbuzz"
        90     | "fizzbuzz"
    }

    def "illegal numbers"(int number, String expected) {
        when:
        FizzBuzz.count(number) == expected

        then:
        def e = thrown IllegalArgumentException
        e.message == expected

        where:
        number | expected
        0      | "number should be between 1 and 100"
        -1     | "number should be between 1 and 100"
        101    | "number should be between 1 and 100"
        102    | "number should be between 1 and 100"
    }
}