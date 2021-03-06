package com.othr.ajp.langton;

import org.junit.Assert;
import org.junit.Test;

public class ColorTest {

    @Test
    public void colorChangeTest() {
        Color nextFromWhite = Color.WHITE.nextColor();
        Assert.assertEquals("White does not have Black as next color", Color.BLACK, nextFromWhite);
        Color nextFromBlack = Color.BLACK.nextColor();
        Assert.assertEquals("Black does not have White as next color", Color.WHITE, nextFromBlack);
    }
}
