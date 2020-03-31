package de.ajp.langton.test;

import com.ajp.langton.Orientation;
import org.junit.Assert;
import org.junit.Test;

import static com.ajp.langton.Orientation.*;

public class OrientationTest {

    @Test
    public void testToRight() {
        Orientation[] orientations = new Orientation[]{NORTH, EAST, SOUTH, WEST};
        for (int i = 0; i < orientations.length - 1; i++) {
            Assert.assertEquals(orientations[i + 1], orientations[i].toRight());
        }
    }

    @Test
    public void testToLeft() {
        Orientation[] orientations = new Orientation[]{NORTH, EAST, SOUTH, WEST};
        for (int i = orientations.length - 1; i >= 0; i--) {
            Assert.assertEquals(orientations[i - 1], orientations[i].toLeft());
        }
    }
}
