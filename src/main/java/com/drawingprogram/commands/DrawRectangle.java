package com.drawingprogram.commands;

import com.drawingprogram.exceptions.InvalidCommandArguments;
import com.drawingprogram.interfaces.CommandType;

public class DrawRectangle implements CommandType {
  private static final String helpMessage = "R x1 y1 x2 y2   Should create a new rectangle, whose upper left corner is (x1,y1) and\n"
      + "                lower right corner is (x2,y2). Horizontal and vertical lines will be drawn\n"
      + "                using the 'x' character.";
  private int x1;
  private int y1;
  private int x2;
  private int y2;

  public DrawRectangle(String... params) {
    if (params.length < 4) {
      throw new InvalidCommandArguments("Draw Rectangle requires four arguments", helpMessage);
    }

    setX1(Integer.parseInt(params[0]));
    setY1(Integer.parseInt(params[1]));
    setX2(Integer.parseInt(params[2]));
    setY2(Integer.parseInt(params[3]));

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
}
