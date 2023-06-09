package v2

import com.amadeuszx.fizzbuzz.v2.FizzBuzz
import spock.lang.Specification

class FizzBuzzTest extends Specification {

    def "numbers that don't change"(int number, String expected) {
        expect:
        FizzBuzz.count(number) == expected

        where:
        number | expected
        1      | 1
        2      | 2
        4      | 4
        7      | 7
    }

    def "numbers that fizz"(int number, String expected) {
        expect:
        FizzBuzz.count(number) == expected

        where:
        number | expected
        3      | "fizz"
        6      | "fizz"
        9      | "fizz"
        12     | "fizz"
    }

    def "numbers that buzz"(int number, String expected) {
        expect:
        FizzBuzz.count(number) == expected

        where:
        number | expected
        5      | "buzz"
        10     | "buzz"
        20     | "buzz"
        25     | "buzz"
    }

    def "numbers that fizz-buzz"(int number, String expected) {
        expect:
        FizzBuzz.count(number) == expected

        where:
        number | expected
        15     | "fizzbuzz"
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