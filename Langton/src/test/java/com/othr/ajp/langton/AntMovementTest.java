package com.othr.ajp.langton;

import org.junit.Assert;
import org.junit.Test;

public class AntMovementTest {

    @Test
    public void movementTest() {
        Ant ant = new Ant();
        // before
        Square squareBefore = ant.getCurrentSquare();
        Color colorBefore = squareBefore.getColor();
        long columnBefore = ant.getColumn();
        long rowBefore = ant.getRow();
        Orientation orientationBefore = ant.getOrientation();

        Assert.assertEquals("column before is not zero", 0, columnBefore);
        Assert.assertEquals("row before is not zero", 0, rowBefore);
        Assert.assertEquals("color before is not white", Color.WHITE, colorBefore);
        Assert.assertEquals("orientation before is not north", Orientation.NORTH, orientationBefore);

        ant.move();

        // after
        Square squareAfter = ant.getCurrentSquare();
        Color colorAfterOnOldSquare = squareBefore.getColor();
        Color colorAfterOnNewSquare = squareAfter.getColor();
        long columnAfter = ant.getColumn();
        long rowAfter = ant.getRow();
        Orientation orientationAfter = ant.getOrientation();

        Assert.assertEquals("color after of initial square is not black", Color.BLACK, colorAfterOnOldSquare);
        Assert.assertEquals("color after of new square is not white", Color.WHITE, colorAfterOnNewSquare);
        Assert.assertEquals("column after not correct", 1, columnAfter);
        Assert.assertEquals("row after is not correct", 0, rowAfter);
        Assert.assertEquals("orientation after is not correct", Orientation.EAST, orientationAfter);
    }
}
