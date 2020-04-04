package com.othr.ajp.langton;

import com.google.common.collect.Range;
import com.google.common.collect.Table;
import com.google.common.collect.TreeBasedTable;

import java.io.Serializable;

/**
 * Represents the field of {@link Square}s that is visited by an {@link Ant}. A Field uses
 * cartesian coordinates with an initial position of <code>(0, 0)</code>.
 * The Field keeps track of visited {@link Square}s and created and stores only these.
 * {@link Square}s are considered visited after being requested by calling {@link #getSquareAt}.
 *
 * @author Kyrylo Terentiev
 * @version since 1.0
 * @see Ant
 * @see Square
 */
public class Field implements Serializable {

    /**
     * Unique version ID of the class.
     * Changes if internal structure can not be de-serialized any longer.
     */
    public static long serialVersionUID = 1L;
    private Table<Long, Long, Square> squares;
    private Range<Long> rows;
    private Range<Long> columns;

    /**
     * Constructs a new, unlimited Field with one new {@link Square} at position <code>(0, 0)</code>
     */
    public Field() {
        squares = TreeBasedTable.create();
        rows = Range.closed(0L, 0L);
        columns = Range.closed(0L, 0L);
        squares.put(0L, 0L, new Square());
    }

    /**
     * Returns the initial {@link Square} at position <code>(0, 0)</code>. This is considered to be the "middle" of the Field.
     *
     * @return the initial {@link Square} at position <code>(0, 0)</code>.
     */
    public Square getInitialSquare() {
        return getSquareAt(0L, 0L);
    }

    /**
     * Returns the {@link Square} at the given row and column.
     * If the {@link Square} does not exist it is created and returned.
     *
     * @param row    The row of the {@link Square}. A negative row represents the upper half of the field, a positive row represents the lower half of the field.
     * @param column The column of the {@link Square}.  A negative column represents the left half of the field, a positive column represents the right half of the field.
     * @return The {@link Square} at the given position.
     */
    public Square getSquareAt(Long row, Long column) {
        if (row < rows.lowerEndpoint())
            rows = Range.closed(row, rows.upperEndpoint());
        if (row > rows.upperEndpoint())
            rows = Range.closed(rows.lowerEndpoint(), row);
        if (column < columns.lowerEndpoint())
            columns = Range.closed(column, columns.upperEndpoint());
        if (column > columns.upperEndpoint())
            columns = Range.closed(columns.lowerEndpoint(), column);

        if (squares.contains(row, column))
            return squares.get(row, column);
        else {
            Square square = new Square();
            squares.put(row, column, square);
            return square;
        }
    }

    /**
     * Creates a full rectangular representation of the field using {@link Square#toString()} of the contained {@link Square}s.
     *
     * @return a representation of the complete Field using {@link StringBuilder}
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.rows.toString());
        sb.append("-");
        sb.append(this.columns.toString());
        sb.append("\n");

        for (long row = rows.lowerEndpoint(); row <= rows.upperEndpoint(); row++) {
            for (long column = columns.lowerEndpoint(); column <= columns.upperEndpoint(); column++) {
                if (squares.contains(row, column))
                    sb.append(squares.get(row, column).getColor().toString());
                else
                    sb.append("-");
            }
            sb.append("\n");
        }
        sb.append("\n");

        return sb.toString();
    }
}
