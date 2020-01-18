package com.drawingprogram.types;

import com.drawingprogram.exceptions.InvalidCommandArguments;
import com.drawingprogram.interfaces.SupportedType;

public class Line implements SupportedType {

  private int x1;
  private int y1;
  private int x2;
  private int y2;

  public Line(final int _x1, final int _y1, final int _x2, final int _y2) {
    if (_x1 != _x2 && _y1 != _y2) {
      throw new InvalidCommandArguments("Draw line does not support diagonal line at the moment",
          "Try drawing horizontal or vertical line");
    }

    setX1(_x1);
    setY1(_y1);
    setX2(_x2);
    setY2(_y2);

  }

  public char[][] stream(char[][] charStream, char character) {
    for (int yAxis = y1; yAxis <= y2; yAxis++) {
      for (int xAxis = x1; xAxis <= x2; xAxis++) {
        charStream[yAxis][xAxis] = character;
      }
    }
    return charStream;
  }

  public int getX1() {
    return x1;
  }

  public void setX1(int x1) {
    this.x1 = x1;
  }

  public int getY1() {
    return y1;
  }

  public void setY1(int y1) {
    this.y1 = y1;
  }

  public int getX2() {
    return x2;
  }

  public void setX2(int x2) {
    this.x2 = x2;
  }

  public int getY2() {
    return y2;
  }

  public void setY2(int y2) {
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