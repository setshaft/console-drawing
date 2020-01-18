package com.drawingprogram.types;

import org.junit.Before;
import org.junit.Test;

import org.junit.Assert;

import com.drawingprogram.commands.DrawFill;
import com.drawingprogram.commands.DrawLine;
import com.drawingprogram.commands.DrawRectangle;
import static org.hamcrest.CoreMatchers.*;

public class TypeHelperTest {

    private TypeHelper commandType;

    @Before
    public void setUp() throws Exception {
        commandType = new TypeHelper();
    }

    @Test
    public void getEntity_DrawLineCommand() throws Exception {
        DrawLine line = new DrawLine("1", "2", "1", "4");
        Assert.assertThat(commandType.getCommandType(line).hashCode(), is(new Line(1, 2, 1, 4).hashCode()));
    }

    @Test
    public void getEntity_DrawRectangleCommand() throws Exception {
        DrawRectangle rectangle = new DrawRectangle("1", "2", "3", "4");
        Assert.assertThat(commandType.getCommandType(rectangle).hashCode(), is(new Rectangle(1, 2, 3, 4).hashCode()));
    }

    @Test
    public void getEntity_BucketFillCommand() throws Exception {
        DrawFill fill = new DrawFill("2", "3", "o");
        Assert.assertThat(commandType.getCommandType(fill).hashCode(), is(new Bucket(2, 3, 'o').hashCode()));
    }

}