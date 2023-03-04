package com.amadeuszx.christmaslights;

public record Point(int x, int y) {
    public Point {
        if (x < 0 || x >= 1_000 || y < 0 || y >= 1_000) {
            throw new IndexOutOfBoundsException();
        }
    }
}
