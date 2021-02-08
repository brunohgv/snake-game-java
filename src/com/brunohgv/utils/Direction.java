package com.brunohgv.utils;

public enum Direction {
    NONE(0,0),
    UP(0, -1),
    DOWN(0, 1),
    LEFT(-1, 0),
    RIGHT(1, 0);

    int x;
    int y;

    Direction(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean canChangeTo(Direction wantedDirection) {
        return !(this.getX() + wantedDirection.getX() == 0 && this.getY() + wantedDirection.getY() == 0);
    }

}
