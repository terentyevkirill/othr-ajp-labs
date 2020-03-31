package com.ajp.langton;

public enum Orientation {
    NORTH, EAST, SOUTH, WEST;

    private static Orientation[] orientations = Orientation.values();

    public Orientation toRight() {
        return orientations[(this.ordinal() + 1) % orientations.length];
    }

    public Orientation toLeft() {
        return orientations[(orientations.length + this.ordinal() - 1) % orientations.length];
    }
}
