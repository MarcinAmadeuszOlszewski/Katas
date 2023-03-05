package com.amadeuszx.christmaslights.v1;

import static com.amadeuszx.christmaslights.v1.ChristmasLights.SIZE;

public record Point(int x, int y) {
    public Point {
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) {
            throw new IndexOutOfBoundsException();
        }
    }
}
