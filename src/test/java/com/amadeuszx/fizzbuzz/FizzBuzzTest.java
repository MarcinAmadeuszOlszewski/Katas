package com.amadeuszx.fizzbuzz;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class FizzBuzzTest {
    private FizzBuzz fizzBuzz;

    @BeforeEach
    void setUp() {
        fizzBuzz = new FizzBuzz();
    }

    @AfterEach
    void tearDown() {
        fizzBuzz = null;
    }

    @Test
    @DisplayName("1 lub 2 zwraca 1 lub 2")
    void t1() {
        assertEquals("1", fizzBuzz.count(1));
        assertEquals("2", fizzBuzz.count(2));
    }

    @Test
    @DisplayName("podzielne przez 3 zwraca Fizz")
    void t3() {
        assertEquals("FizzFizz", fizzBuzz.count(3));
        assertEquals("Fizz", fizzBuzz.count(6));
    }
    @Test
    @DisplayName("zawiera 3 zwraca Fizz")
    void t3v2() {
        assertEquals("Fizz", fizzBuzz.count(31));
        assertEquals("Fizz", fizzBuzz.count(13));
    }

    @Test
    @DisplayName("podzielne przez 5 zwraca Buzz")
    void t5() {
        assertEquals("BuzzBuzz", fizzBuzz.count(5));
        assertEquals("Buzz", fizzBuzz.count(10));
    }

    @Test
    @DisplayName("zawiera 5 zwraca Buzz")
    void t5v2() {
        assertEquals("Buzz", fizzBuzz.count(52));
    }

    @Test
    @DisplayName("podzielne przez 3 i 5 zwraca FizzBuzz")
    void t15() {
        assertEquals("FizzBuzzBuzz", fizzBuzz.count(15));
        assertEquals("FizzFizzBuzz", fizzBuzz.count(30));
    }

    @Test
    @DisplayName("<1 zwracaja Exception")
    void tBellow1() {
        Assertions.assertDoesNotThrow( () -> fizzBuzz.count(1));
        assertThrows(IllegalArgumentException.class, () -> fizzBuzz.count(0));
        assertThrows(IllegalArgumentException.class, () -> fizzBuzz.count(-1));
    }

    @Test
    @DisplayName(">100 zwracaja Exception")
    void tOver100() {
        Assertions.assertDoesNotThrow( () -> fizzBuzz.count(100));
        assertThrows(IllegalArgumentException.class, () -> fizzBuzz.count(101));
        assertThrows(IllegalArgumentException.class, () -> fizzBuzz.count(1002));
    }

    @Test
    @DisplayName("podzielne przez 3 i 5 zwraca FizzBuzz")
    void tFromv2() {
        assertEquals("FizzBuzz", fizzBuzz.count(53));
        assertEquals("FizzBuzzBuzz", fizzBuzz.count(35));
    }
}