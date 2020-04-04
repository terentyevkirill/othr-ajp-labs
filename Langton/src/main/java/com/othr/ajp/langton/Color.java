package com.othr.ajp.langton;

/**
 * Represents the two possible {@link Square} colors white and black
 *
 * @author Kyrylo Terentiev
 * @version since 1.0
 * @see Square
 */
public enum Color {
    WHITE('W'), BLACK('B');

    private char color;

    Color(char c) {
        this.color = c;
    }

    /**
     * @return a one-letter representation of the represented Color.
     */
    @Override
    public String toString() {
        return "" + this.color;
    }

    /**
     * @return a next color value in the enumeration
     */
    public Color nextColor() {
        if (this.color == 'W')
            return BLACK;
        else
            return WHITE;
    }
}


