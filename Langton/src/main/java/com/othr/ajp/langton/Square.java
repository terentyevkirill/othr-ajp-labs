package com.othr.ajp.langton;

/**
 * Represents the state of a Square used in a {@link Field}
 * @author  Kyrylo Terentiev
 * @version since 1.0
 * @see     Ant
 */
public class Square {

    Color color = Color.WHITE;

    /**
     * @return the current {@link Color} of the {@link Square}
     */
    public Color getColor() {
        return color;
    }

    /**
     * Changes the {@link Color} of the {@link Square}. Uses the {@link Color#nextColor()} method
     */
    public void changeColor() {
        this.color = color.nextColor();
    }

}
