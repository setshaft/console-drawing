package com.drawingprogram.commands;

import com.drawingprogram.exceptions.InvalidCommandArguments;

import org.junit.Test;
import org.junit.Assert;
import static org.hamcrest.CoreMatchers.*;

public class DrawLineTest {
    @Test
    public void line() throws Exception {
        new DrawLine("1", "1", "1", "2");
    }

    @Test
    public void getters() throws Exception {
        DrawLine line = new DrawLine("1", "1", "1", "2");
        int x1 = line.getX1();
        int x2 = line.getX2();
        int y1 = line.getY1();
        int y2 = line.getY2();
        Assert.assertThat(x1, is(1));
        Assert.assertThat(y1, is(1));
        Assert.assertThat(x2, is(1));
        Assert.assertThat(y2, is(2));
    }

    @Test(expected = InvalidCommandArguments.class)
    public void invalidLine1() throws Exception {
        new DrawLine("1", "1", "2", "2");
    }

    @Test(expected = InvalidCommandArguments.class)
    public void invalidLine2() throws Exception {
        new DrawLine("1", "1");
    }

    @Test(expected = InvalidCommandArguments.class)
    public void invalidLine3() throws Exception {
        new DrawLine("1");
    }

    @Test(expected = InvalidCommandArguments.class)
    public void invalidLine4() throws Exception {
        new DrawLine();
    }
}