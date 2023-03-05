package com.amadeuszx.christmaslights.v1;

import java.util.Arrays;
import java.util.function.BiConsumer;

/**
 * https://kata-log.rocks/christmas-lights-kata
 * <p>
 * additional questions:
 * how to be when end is less than begin? switch or ignore?
 * any limit to brightness (phase 2)?
 */
public class ChristmasLights {

    static final int SIZE = 1_000;
    private final int[][] lights = new int[SIZE][SIZE];
    private final BiConsumer<Integer, Integer> turnOn = (x, y) -> lights[x][y]++;
    private final BiConsumer<Integer, Integer> turnOff = (x, y) -> lights[x][y] = Math.max(0, --lights[x][y]);
    private final BiConsumer<Integer, Integer> toggle = (x, y) -> lights[x][y] += 2;

    public int count() {
        return Arrays.stream(lights)
                .flatMapToInt(Arrays::stream)
                .sum();
    }

    public void turnOn(Point begin, Point end) {
        validate(begin, end);
        iterate(begin, end, turnOn);
    }

    public void turnOff(Point begin, Point end) {
        validate(begin, end);
        iterate(begin, end, turnOff);
    }

    public void toggle(Point begin, Point end) {
        validate(begin, end);
        iterate(begin, end, toggle);
    }

    private static void validate(Point begin, Point end) {
        if (begin == null || end == null) {
            throw new IllegalArgumentException();
        }
    }

    private void iterate(Point begin, Point end, BiConsumer<Integer, Integer> change) {
        for (int x = begin.x(); x <= end.x(); x++) {
            for (int y = begin.y(); y <= end.y(); y++) {
                change.accept(x, y);
            }
        }
    }
}
