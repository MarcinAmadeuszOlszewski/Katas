package com.amadeuszx.christmaslights;

public record Point(int x, int y) {
    public Point {
        if (x < 0 || x > 999 || y < 0 || y > 999) {
            throw new IndexOutOfBoundsException();
        }
    }
}
