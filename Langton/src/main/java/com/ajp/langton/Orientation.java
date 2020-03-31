package com.ajp.langton;

public enum Orientation {
    NORTH, EAST, SOUTH, WEST;

    private static Orientation[] orientations = Orientation.values();

    public Orientation toRight() {
        return null;
    }

    public Orientation toLeft() {
        return null;
    }
}
