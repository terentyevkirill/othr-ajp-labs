package com.ajp.langton;

public class Square {

    private Color color = Color.WHITE;

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void changeColor() {
        this.color = color.nextColor();
    }

}
