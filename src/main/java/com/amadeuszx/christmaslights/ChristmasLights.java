package com.amadeuszx.christmaslights;

import java.util.Arrays;
import java.util.function.Consumer;

/**
 * https://kata-log.rocks/christmas-lights-kata
 */
public class ChristmasLights {
    private final Boolean[][] lights = new Boolean[1000][1000];

    public ChristmasLights() {
        for (Boolean[] b : lights) {
            Arrays.fill(b, Boolean.FALSE);
        }
    }

    void turnOn(Point p) {
        lights[p.x()][p.y()] = Boolean.TRUE;
    }

    void turnOff(Point p) {
        lights[p.x()][p.y()] = Boolean.FALSE;
    }

    void toggle(Point p) {
        lights[p.x()][p.y()] = !lights[p.x()][p.y()];
    }

    int count() {
        return (int) Arrays.stream(lights)
                .flatMap(Arrays::stream)
                .filter(light -> light)
                .count();
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
