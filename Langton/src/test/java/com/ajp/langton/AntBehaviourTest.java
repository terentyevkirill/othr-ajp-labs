package com.ajp.langton;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class AntBehaviourTest {

    @Test
    public void initialValuesTest() {
        Ant ant = new Ant();

        Assert.assertEquals("initial column not zero", 0, ant.getColumn());
        Assert.assertEquals("initial row not zero", 0, ant.getRow());
        Assert.assertEquals("initial color not white", Color.WHITE, ant.getCurrentSquare().getColor());
        Assert.assertEquals("initial orientation not north", Orientation.NORTH, ant.getOrientation());
    }

    private static Stream<Arguments> firstMovementParameters() {
        return Stream.of(
                Arguments.of(Orientation.NORTH, Color.WHITE, 0, 1),
                Arguments.of(Orientation.EAST, Color.WHITE, 1, 0),
                Arguments.of(Orientation.SOUTH, Color.WHITE, 0, -1),
                Arguments.of(Orientation.WEST, Color.WHITE, -1, 0),
                Arguments.of(Orientation.NORTH, Color.BLACK, 0, -1),
                Arguments.of(Orientation.EAST, Color.BLACK, -1, 0),
                Arguments.of(Orientation.SOUTH, Color.BLACK, 0, 1),
                Arguments.of(Orientation.WEST, Color.BLACK, 1, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("firstMovementParameters")
    public void movementTest(Orientation orientation, Color color, int row, int column) {
        Ant ant = new Ant();

        // set to test start values
        ant.setOrientation(orientation);
        ant.getCurrentSquare().setColor(color);
        Square startSquare = ant.getCurrentSquare();

        ant.move();

        // check output
        Assert.assertEquals("wrong row after start from 0, 0 on a " + color.name() + " square facing " + orientation.name(), row, ant.getRow());
        Assert.assertEquals("wrong column after start from 0, 0 on a " + color.name() + " square facing " + orientation.name(), column, ant.getColumn());
        Orientation newOrientation = color == Color.WHITE ? orientation.toRight() : orientation.toLeft();
        Assert.assertEquals("wrong orientation after start from 0, 0 on a " + color.name() + " square facing " + orientation.name(), newOrientation, ant.getOrientation());
        Assert.assertEquals("wring color after start from 0, 0 on a " + color.name() + " square facing " + orientation.name(), color.nextColor(), startSquare.getColor());
    }

}
