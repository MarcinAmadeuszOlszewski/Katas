package v2

import com.amadeuszx.fizzbuzz.v2.FizzBuzz
import spock.lang.Specification

class FizzBuzzTest extends Specification {

    def "one return one"() {
        given:
        var fizzBuzz = new FizzBuzz()

        when:
        var result = fizzBuzz.count(1)

        then:
        result == "1"
    }

    def "two return two"() {
        expect:
        FizzBuzz.count(2) == "2"
    }
}