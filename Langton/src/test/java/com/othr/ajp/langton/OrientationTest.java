package com.othr.ajp.langton;

import org.junit.Assert;
import org.junit.Test;

public class OrientationTest {
    private Orientation[] orientations = new Orientation[]{Orientation.NORTH, Orientation.EAST, Orientation.SOUTH, Orientation.WEST};

    @Test
    public void testToRight() {
        for (int i = 0; i < orientations.length - 1; i++) {
            Assert.assertEquals(orientations[i + 1], orientations[i].toRight());
        }
    }

    @Test
    public void testToLeft() {
        for (int i = orientations.length - 1; i > 0; i--) {
            Assert.assertEquals(orientations[i - 1], orientations[i].toLeft());
        }
    }
}
