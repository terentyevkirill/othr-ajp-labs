package com.ajp.langton;

public class Ant {

    private Square[][] field = new Square[11][11];
    private int row = 0;
    private int column = 0;
    private Orientation orientation = Orientation.NORTH;

    public Ant() {
        for (int r = 0; r < field.length; r++)
            for (int c = 0; c < field[r].length; c++)
                field[r][c] = new Square();
    }

    public void move() {
        if (getCurrentSquare().getColor() == Color.WHITE)
            this.orientation = this.orientation.toRight();
        else
            this.orientation = this.orientation.toLeft();

        this.getCurrentSquare().changeColor();

        switch (orientation) {
            case NORTH:
                row--;
                break;
            case EAST:
                column++;
                break;
            case SOUTH:
                row++;
                break;
            case WEST:
                column--;
                break;
        }
    }

    public Square getCurrentSquare() {
        return field[row + 5][column + 5];
    }

    public Square[][] getField() {
        return field;
    }

    public void setField(Square[][] field) {
        this.field = field;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }
}
