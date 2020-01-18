package com.drawingprogram.commands;

import com.drawingprogram.exceptions.InvalidCommandArguments;

import org.junit.Test;
import org.junit.Assert;
import static org.hamcrest.CoreMatchers.*;

public class CreateCanvasTest {
    @Test
    public void createCanvas() throws Exception {
        new CreateCanvas("1", "1");
    }

    @Test
    public void getters() throws Exception {
        CreateCanvas canvas = new CreateCanvas("1", "1");
        int height = canvas.getHeight();
        int width = canvas.getWidth();
        Assert.assertThat(height, is(1));
        Assert.assertThat(width, is(1));
    }

    @Test(expected = InvalidCommandArguments.class)
    public void invalidCreateCanvas() throws Exception {
        new CreateCanvas("1");
    }

    @Test(expected = InvalidCommandArguments.class)
    public void invalidCreateCanvas1() throws Exception {
        new CreateCanvas();
    }
}