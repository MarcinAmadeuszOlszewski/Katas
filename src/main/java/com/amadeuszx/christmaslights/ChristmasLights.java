package com.amadeuszx.christmaslights;

import java.util.Arrays;
import java.util.function.Consumer;

/**
 * https://kata-log.rocks/christmas-lights-kata
 */
public class ChristmasLights {
    private final Integer[][] lights = new Integer[1000][1000];

    public ChristmasLights() {
        for (Integer[] b : lights) {
            Arrays.fill(b, 0);
        }
    }

    void turnOn(Point p) {
        lights[p.x()][p.y()]++;
    }

    void turnOff(Point p) {
        lights[p.x()][p.y()]--;
        if (lights[p.x()][p.y()] < 0) {
            lights[p.x()][p.y()] = 0;
        }
    }

    void toggle(Point p) {
        lights[p.x()][p.y()] += 2;
    }

    int count() {
        return Arrays.stream(lights)
                .flatMap(Arrays::stream)
                .mapToInt(l -> l)
                .sum();
    }

    public void turnOn(Point begin, Point end) {
        iterate(begin, end, this::turnOn);
    }

    public void turnOff(Point begin, Point end) {
        iterate(begin, end, this::turnOff);
    }

    public void toggle(Point begin, Point end) {
        iterate(begin, end, this::toggle);
    }

    private void iterate(Point begin, Point end, Consumer<Point> change) {
        for (int x = begin.x(); x <= end.x(); x++) {
            for (int y = begin.y(); y <= end.y(); y++) {
                change.accept(new Point(x, y));
            }
        }
    }
}
