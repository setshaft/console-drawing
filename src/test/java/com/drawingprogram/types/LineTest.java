package com.drawingprogram.types;

import com.drawingprogram.exceptions.InvalidCommandArguments;
import org.junit.Assert;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;

public class LineTest {
    @Test
    public void create() throws Exception {
        Line line = new Line(1, 2, 1, 3);
        int x1 = line.getX1();
        int x2 = line.getX2();
        int y1 = line.getY1();
        int y2 = line.getY2();
        Assert.assertThat(x1, is(1));
        Assert.assertThat(y1, is(2));
        Assert.assertThat(x2, is(1));
        Assert.assertThat(y2, is(3));
    }

    @Test(expected = InvalidCommandArguments.class)
    public void create7() throws Exception {
        Line line = new Line(1, 2, 3, 4);
        Canvas canvas = new Canvas(20, 4);
        line.stream(canvas.charStream, 'x');
    }

}