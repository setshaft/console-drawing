package com.drawingprogram.types;

import org.junit.Test;
import org.junit.Assert;
import static org.hamcrest.CoreMatchers.*;

public class BucketTest {
    @Test
    public void create() throws Exception {
        new Bucket(1, 2, 'o');
    }

    @Test
    public void create3() throws Exception {
        Bucket fill = new Bucket(1, 2, 'o');
        int x = fill.getX();
        int y = fill.getY();
        char character = fill.getCharacter();
        Assert.assertThat(x, is(1));
        Assert.assertThat(y, is(2));
        Assert.assertThat('o', is(character));
    }

    @Test
    public void create4() throws Exception {
        Bucket fill = new Bucket(10, 3, 'o');
        Canvas canvas = new Canvas(20, 4);
        fill.stream(10, 3, canvas.charStream, 4, 20);
    }
}