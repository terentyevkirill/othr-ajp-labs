package com.ajp.langton;

public enum Color {
    WHITE(0), BLACK(1);

    private int colorNumber;

    Color(int colorNumber) {
        this.colorNumber = colorNumber;
    }

    public Color nextColor() {
        // usage: Color.WHITE.nextColor()
        if (this.colorNumber == 0)
            return BLACK;
        else
            return WHITE;
    }
}


