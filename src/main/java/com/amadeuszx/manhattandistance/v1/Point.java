package com.amadeuszx.manhattandistance.v1;

public record Point(int x, int y) {

    int manhattanDistance(Point p2) {
        final int dx = Math.abs(x - p2.x);
        final int dy = Math.abs(y - p2.y);

        return dx + dy;
    }

    public int x() {
        throw new UnsupportedOperationException();
    }

    public int y() {
        throw new UnsupportedOperationException();
    }
}
