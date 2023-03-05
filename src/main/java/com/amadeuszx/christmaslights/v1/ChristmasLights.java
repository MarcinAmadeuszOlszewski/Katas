package com.amadeuszx.christmaslights.v1;

import java.util.Arrays;
import java.util.function.BiConsumer;

/**
 * https://kata-log.rocks/christmas-lights-kata
 */
public class ChristmasLights {
    private final Integer[][] lights = new Integer[1000][1000];
    private final BiConsumer<Integer, Integer> turnOn = (x, y) -> lights[x][y]++;
    private final BiConsumer<Integer, Integer> turnOff = (x, y) -> lights[x][y] = Math.max(0, --lights[x][y]);
    private final BiConsumer<Integer, Integer> toggle = (x, y) -> lights[x][y] += 2;

    public ChristmasLights() {
        for (Integer[] b : lights) {
            Arrays.fill(b, 0);
        }
    }

    public int count() {
        return Arrays.stream(lights)
                .flatMap(Arrays::stream)
                .mapToInt(l -> l)
                .sum();
    }

    public void turnOn(Point begin, Point end) {
        iterate(begin, end, turnOn);
    }

    public void turnOff(Point begin, Point end) {
        iterate(begin, end, turnOff);
    }

    public void toggle(Point begin, Point end) {
        iterate(begin, end, toggle);
    }

    private void iterate(Point begin, Point end, BiConsumer<Integer, Integer> change) {
        for (int x = begin.x(); x <= end.x(); x++) {
            for (int y = begin.y(); y <= end.y(); y++) {
                change.accept(x, y);
            }
        }
    }
}
