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
        6      | 6
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
}