package com.drawingprogram.types;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static com.drawingprogram.types.Constants.*;

public class CanvasTest {
  private Canvas canvas;

  @Before
  public void beforeAll() throws Exception {
    canvas = new Canvas(20, 4);
  }

  // empty canvas
  @Test
  public void canvas() throws Exception {
    Assert.assertEquals(canvas.render().toString(), EMPTY_CANVAS204);
  }

  // add horizontal line
  @Test
  public void streamLine() throws Exception {
    Line line = new Line(2, 2, 4, 2);
    canvas.streamType(line);
    Assert.assertEquals(canvas.render().toString(), LINE2242);
  }

  @Test
  public void addEntity4() throws Exception {
    Rectangle rectangle = new Rectangle(14, 1, 18, 3);
    canvas.streamType(rectangle);
    Assert.assertEquals(canvas.render().toString(), RECTANGLE141183);
  }

  @Test
  public void streamBucketFill() throws Exception {
    Bucket fill = new Bucket(10, 3, 'o');
    canvas.streamType(fill);
    Assert.assertEquals(canvas.render().toString(), FILL103);
  }

  @Test(expected = IllegalStateException.class)
  public void invalidFill() throws Exception {
    Bucket fill = new Bucket(10, 3, 'o');
    canvas.charStream = null;
    canvas.streamType(fill);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidCanvas() throws Exception {
    canvas = new Canvas(-1, 1);
  }

}