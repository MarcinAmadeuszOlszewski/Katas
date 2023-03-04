package com.amadeuszx.christmaslights;

import java.util.Arrays;

/**
 * https://kata-log.rocks/christmas-lights-kata
 */
public class ChristmasLights {
    private final Boolean[][] lights = new Boolean[1000][1000];

    void turnOn(Point p) {
        lights[p.x()][p.y()] = Boolean.TRUE;
    }

    void turnOff(Point p) {
        lights[p.x()][p.y()] = Boolean.FALSE;
    }

    void toggle(Point p) {
        if (lights[p.x()][p.y()] == null) {
            lights[p.x()][p.y()] = Boolean.TRUE;
        } else {
            lights[p.x()][p.y()] = !lights[p.x()][p.y()];
        }
    }

    int count() {
        return (int) Arrays.stream(lights)
                .flatMap(Arrays::stream)
                .filter(light -> light != null && light)
                .count();
    }
}
