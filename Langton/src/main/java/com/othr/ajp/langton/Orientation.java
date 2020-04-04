package com.othr.ajp.langton;

/**
 * Represents the four possible orientations of an {@link Ant}
 * @author  Kyrylo Terentiev
 * @version since 1.0
 * @see     Ant
 */
public enum Orientation {
    NORTH, EAST, SOUTH, WEST;

    private static Orientation[] orientations = Orientation.values();

    /**
     * @return the next {@link Orientation} object after turning 90 degrees to the right
     */
    public Orientation toRight() {
        return orientations[(this.ordinal() + 1) % orientations.length];
    }

    /**
     * @return the next {@link Orientation} object after turning 90 degrees to the left
     */
    public Orientation toLeft() {
        return orientations[(orientations.length + this.ordinal() - 1) % orientations.length];
    }
}
