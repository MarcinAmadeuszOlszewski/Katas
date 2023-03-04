package com.amadeuszx.christmaslights;

import java.util.Arrays;

/**
 * https://kata-log.rocks/christmas-lights-kata
 */
public class ChristmasLights {
    private final Boolean[][] lights = new Boolean[1000][1000];

    void turnOn(int x, int y) {
        lights[x][y] = Boolean.TRUE;
    }

    void turnOff(int x, int y) {
        lights[x][y] = Boolean.FALSE;
    }

    int count() {
        return (int) Arrays.stream(lights)
                .flatMap(Arrays::stream)
                .filter(light -> light != null && light)
                .count();
    }
}
