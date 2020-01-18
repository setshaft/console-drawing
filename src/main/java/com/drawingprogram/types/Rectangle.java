package com.drawingprogram.types;

import com.drawingprogram.interfaces.SupportedType;

public class Rectangle implements SupportedType {
  private int x1;
  private int y1;
  private int x2;
  private int y2;

  public Rectangle(final int _x1, final int _y1, final int _x2, final int _y2) {
    setX1(_x1);
    setY1(_y1);
    setX2(_x2);
    setY2(_y2);
  }

  public char[][] stream(char[][] charStream, char character) {
    charStream = new Line(x1, y1, x2, y1).stream(charStream, character);
    charStream = new Line(x1, y1, x1, y2).stream(charStream, character);
    charStream = new Line(x2, y1, x2, y2).stream(charStream, character);
    charStream = new Line(x1, y2, x2, y2).stream(charStream, character);
    return charStream;
  }

  public int getX1() {
    return x1;
  }

  public void setX1(final int x1) {
    this.x1 = x1;
  }

  public int getY1() {
    return y1;
  }

  public void setY1(final int y1) {
    this.y1 = y1;
  }

  public int getX2() {
    return x2;
  }

  public void setX2(final int x2) {
    this.x2 = x2;
  }

  public int getY2() {
    return y2;
  }

  public void setY2(final int y2) {
    this.y2 = y2;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + x1;
    result = prime * result + x2;
    result = prime * result + y1;
    result = prime * result + y2;
    return result;
  }

}