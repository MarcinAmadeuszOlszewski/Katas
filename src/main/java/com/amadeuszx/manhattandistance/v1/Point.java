package com.amadeuszx.manhattandistance.v1;

public class Point {
    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    int manhattanDistance(Point p2) {
        final int dx = Math.abs(x - p2.x);
        final int dy = Math.abs(y - p2.y);

        return dx + dy;
    }
}
