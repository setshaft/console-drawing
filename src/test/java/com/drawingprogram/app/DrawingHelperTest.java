package com.drawingprogram.app;

import static com.drawingprogram.app.Constants.EMPTY_CANVAS204;
import static com.drawingprogram.app.Constants.FILL103;
import static com.drawingprogram.app.Constants.LINE1214;
import static com.drawingprogram.app.Constants.RECTANGLE141183;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Unit test for drawing helper.
 */
public class DrawingHelperTest {
  @Test
  public void initializeTest() {
    final DrawingHelper window = new DrawingHelper();
    assertEquals(0, window.width);
    assertEquals(0, window.height);
  }

  @Test
  public void constructorTest() {
    final DrawingHelper window = new DrawingHelper(20, 4);
    assertEquals(window.print().length(), 138);
    assertEquals(EMPTY_CANVAS204, window.print().toString());
  }

  @Test
  public void testWidthZero() {
    try {
      new DrawingHelper(0, 4);
    } catch (final IllegalArgumentException expectedException) {
      assertEquals("Canvas measurements cannot be less than 1", expectedException.getMessage());
    }
  }

  public void testHeightZero() {
    try {
      new DrawingHelper(4, 0);
    } catch (final IllegalArgumentException expectedException) {
      assertEquals("Canvas measurements cannot be less than 1", expectedException.getMessage());
    }
  }

  @Test
  public void testStreamLine() {
    final DrawingHelper window = new DrawingHelper(3, 5);
    window.streamLine(1, 2, 1, 4, 'X');
    assertEquals(LINE1214, window.print().toString());
  }

  @Test
  public void testForNotHorizontalOrVerticalLines() {
    try {
      final DrawingHelper window = new DrawingHelper(20, 4);
      window.streamLine(1, 2, 6, 3, 'X');
    } catch (final IllegalArgumentException expectedException) {
      assertEquals("Currently only horizontal or vertical lines are supported", expectedException.getMessage());
    }
  }

  @Test
  public void testCheckIfCanvasIsThere() {
    try {
      final DrawingHelper window = new DrawingHelper();
      window.streamLine(1, 2, 6, 2, 'X');
    } catch (final IllegalStateException expectedException) {
      assertEquals("Canvas is not defined, please define with C {width} {height} and try again.",
          expectedException.getMessage());
    }
  }

  @Test
  public void testStreamRectangle() {
    final DrawingHelper window = new DrawingHelper(20, 4);
    window.streamRectangle(14, 1, 18, 3, 'X');
    assertEquals(RECTANGLE141183, window.print().toString());
  }

  @Test
  public void testFillColor() {
    final DrawingHelper window = new DrawingHelper(20, 4);
    window.fillColor(10, 3, 'o');
    assertEquals(FILL103, window.print().toString());
  }
}
