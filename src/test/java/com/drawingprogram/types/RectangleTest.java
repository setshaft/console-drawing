package com.drawingprogram.types;

import org.junit.Assert;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;

public class RectangleTest {
    @Test
    public void rectangle() throws Exception {
        new Rectangle(1, 2, 1, 3);
    }

    @Test
    public void getters() {
        Rectangle rectangle = new Rectangle(1, 1, 1, 2);
        int x1 = rectangle.getX1();
        int x2 = rectangle.getX2();
        int y1 = rectangle.getY1();
        int y2 = rectangle.getY2();
        Assert.assertThat(x1, is(1));
        Assert.assertThat(y1, is(1));
        Assert.assertThat(x2, is(1));
        Assert.assertThat(y2, is(2));
    }

    @Test
    public void stream() throws Exception {
        Rectangle rectangle = new Rectangle(1, 1, 1, 2);
        Canvas canvas = new Canvas(20, 4);
        rectangle.stream(canvas.charStream, 'x');
    }
}