package com.drawingprogram.commands;

import com.drawingprogram.exceptions.InvalidCommandArguments;

import org.junit.Test;
import org.junit.Assert;
import static org.hamcrest.CoreMatchers.*;

public class DrawRectangleTest {
    @Test
    public void testCreate() throws Exception {
        new DrawRectangle("1", "1", "1", "2");
    }

    @Test
    public void testCreate1() throws Exception {
        DrawRectangle rectangle = new DrawRectangle("1", "1", "1", "2");
        int x1 = rectangle.getX1();
        int x2 = rectangle.getX2();
        int y1 = rectangle.getY1();
        int y2 = rectangle.getY2();
        Assert.assertThat(x1, is(1));
        Assert.assertThat(y1, is(1));
        Assert.assertThat(x2, is(1));
        Assert.assertThat(y2, is(2));
    }

    // @Test(expected = InvalidCommandArguments.class)
    // public void testCreate2() throws Exception {
    // new DrawRectangle("1", "-1", "1", "2");
    // }

    @Test(expected = InvalidCommandArguments.class)
    public void testCreate3() throws Exception {
        new DrawRectangle("1", "1");
    }

    @Test(expected = InvalidCommandArguments.class)
    public void testCreate4() throws Exception {
        new DrawRectangle("1");
    }

    @Test(expected = InvalidCommandArguments.class)
    public void testCreate6() throws Exception {
        new DrawRectangle();
    }
}