package com.othr.ajp.langton;

/**
 * Represents an Ant and its internal state as outlines <a href="https://en.wikipedia.org/wiki/Langton%27s_ant">here</a>.
 *
 * @author Kyrylo Terentiev
 * @version since 1.0
 * @see Ant
 * @see Square
 * @see <a href="https://en.wikipedia.org/wiki/Langton%27s_ant">Langton's Ant</a>
 */
public class Ant {

    Orientation orientation;
    long row, column;
    Square currentSquare;
    final Field field;

    /**
     * Constructs a new Ant with a new {@link Field}. {@link Orientation} is set to {@link Orientation#NORTH}, row and column id are both set to <code>0</code>.
     * The Ant's current position is set using {@link Field#getInitialSquare()}.
     */
    public Ant() {
        this(new Field());
    }

    /**
     * Constructs a new Ant with a given {@link Field}. {@link Orientation} is set to {@link Orientation#NORTH}, row and column id are both set to <code>0</code>.
     * The Ant's current position is set using {@link Field#getInitialSquare()}.
     *
     * @param field the {@link Field} the Ant is part of.
     */
    public Ant(Field field) {
        this.field = field;
        this.orientation = Orientation.NORTH;
        this.row = 0L;
        this.column = 0L;
        this.currentSquare = field.getInitialSquare();
    }

    /**
     * Implements the core behavior of an Ant.
     * <ul>
     *    <li>If the current {@link Square} is white, it will turn 90 degrees to the right, change the {@link Color} of the {@link Square}, and move one {@link Square} forward on the {@link Field}.</li>
     *    <li>If the current {@link Square} is black, it will turn 90 degrees to the left, change the {@link Color} of the {@link Square}, and move one {@link Square} forward on the {@link Field}.</li>
     * </ul>
     */
    public void move() {
        assert (this.currentSquare != null);

        if (this.currentSquare.getColor() == Color.WHITE)
            this.orientation = this.orientation.toRight();
        else
            this.orientation = this.orientation.toLeft();

        this.currentSquare.changeColor();

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

        this.currentSquare = field.getSquareAt(row, column);
    }

    /**
     * Returns the current {@link Square} the Ant is currently on.
     *
     * @return the current the {@link Square} the Ant currently sits on.
     */
    public Square getCurrentSquare() {
        return currentSquare;
    }

    /**
     * Returns the current {@link Field} the Ant is currently using.
     *
     * @return the {@link Field} the Ant moves on.
     */
    public Field getField() {
        return field;
    }

    /**
     * Returns the current row index position relative from the start position <code>(0, 0)</code>.
     *
     * @return the current row of the {@link Square} the Ant is on on the {@link Field}.
     */
    public long getRow() {
        return row;
    }

    /**
     * Returns the current column index position relative from the start position <code>(0, 0)</code>.
     *
     * @return the current column of the {@link Square} the Ant is on on the {@link Field}.
     */
    public long getColumn() {
        return column;
    }

    /**
     * Returns the current orientation of the Ant.
     *
     * @return the current {@link Orientation} of the Ant.
     */
    public Orientation getOrientation() {
        return orientation;
    }

    /**
     * Creates the String representation of the Ant's orientation as one character <code>N, E, S, W</code>
     * and its position in terms of row and column position like <code>(2, -3)</code>
     *
     * @return String representation of the Ant's orientation and position.
     */
    @Override
    public String toString() {
        return this.orientation.toString() + "(" + this.row + "," + this.column + ")";
    }

    /**
     * Basic main method stepwise printing the {@link Field}s of the first 200 moves.
     *
     * @param args not used.
     */
    public static void main(String[] args) {
        Field field = new Field();
        Ant ant = new Ant(field);
        for (int i = 1; i <= 200; i++) {
            System.out.println(i + ". - Ant: " + ant.toString());
            System.out.println(field);
            ant.move();
        }
    }
}
