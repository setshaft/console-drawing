package com.drawingprogram.commands;

import com.drawingprogram.exceptions.InvalidCommandArguments;
import com.drawingprogram.interfaces.CommandType;

public class DrawLine implements CommandType {
  private static final String helpMessage = "L x1 y1 x2 y2   Should create a new line from (x1,y1) to (x2,y2).";
  private int x1;
  private int y1;
  private int x2;
  private int y2;

  public DrawLine(final String... params) {
    if (params.length < 4) {
      throw new InvalidCommandArguments("Draw line requires four arguments", helpMessage);
    }

    setX1(Integer.parseInt(params[0]));
    setY1(Integer.parseInt(params[1]));
    setX2(Integer.parseInt(params[2]));
    setY2(Integer.parseInt(params[3]));

    if (x1 != x2 && y1 != y2) {
      throw new InvalidCommandArguments("Draw line does not support diagonal line at the moment", helpMessage);
    }
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
}
