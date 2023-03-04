package com.amadeuszx.christmaslights;

import java.util.Arrays;

/**
 * https://kata-log.rocks/christmas-lights-kata
 */
public class ChristmasLights {
    private final Boolean[][] lights = new Boolean[1000][1000];

    void turnOne(int x, int y) {
        lights[x][y] = Boolean.TRUE;
    }

    int count() {
        return (int) Arrays.stream(lights)
                .flatMap(Arrays::stream)
                .filter(light -> light != null && light)
                .count();
    }
}
