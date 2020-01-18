package com.drawingprogram.commands;

import com.drawingprogram.exceptions.InvalidCommandArguments;

import org.junit.Test;
import org.junit.Assert;
import static org.hamcrest.CoreMatchers.*;

public class DrawFillTest {
  @Test
  public void testCreate() throws Exception {
    new DrawFill("1", "1", "o");
  }

  @Test
  public void testCreate2() throws Exception {
    DrawFill fill = new DrawFill("1", "1", "o");
    int x = fill.getX();
    int y = fill.getY();
    char character = fill.getCharacter();
    Assert.assertThat(x, is(1));
    Assert.assertThat(y, is(1));
    Assert.assertThat('o', is(character));
  }

  @Test(expected = InvalidCommandArguments.class)
  public void testCreate1() throws Exception {
    new DrawFill("-1", "1", "oo");
  }

  @Test(expected = InvalidCommandArguments.class)
  public void testCreate3() throws Exception {
    new DrawFill("1", "1");
  }

  @Test(expected = InvalidCommandArguments.class)
  public void testCreate4() throws Exception {
    new DrawFill("1");
  }

  @Test(expected = InvalidCommandArguments.class)
  public void testCreate6() throws Exception {
    new DrawFill();
  }

}