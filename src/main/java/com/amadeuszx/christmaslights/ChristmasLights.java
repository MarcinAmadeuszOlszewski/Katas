package com.amadeuszx.christmaslights;

import java.util.Arrays;

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
}
