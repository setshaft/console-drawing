package com.drawingprogram.commands;

import com.drawingprogram.exceptions.InvalidCommandArguments;
import com.drawingprogram.interfaces.CommandType;

public class DrawFill implements CommandType {

  private static final String helpMessage = "B x y c Should fill the entire area connected to (x,y) with 'colour' c.";
  private int x;
  private int y;
  private char character;

  public DrawFill(final String... arguments) {
    if (arguments.length < 3)
      throw new InvalidCommandArguments("Bucket fill requires three arguments", helpMessage);
    if (arguments[2].length() != 1) {
      throw new InvalidCommandArguments("Color character should only be 1 character", helpMessage);
    }

    setX(Integer.parseInt(arguments[0]));
    setY(Integer.parseInt(arguments[1]));
    setCharacter(arguments[2].charAt(0));
  }

  public int getX() {
    return x;
  }

  public void setX(final int x) {
    this.x = x;
  }

  public int getY() {
    return y;
  }

  public void setY(final int y) {
    this.y = y;
  }

  public char getCharacter() {
    return character;
  }

  public void setCharacter(final char character) {
    this.character = character;
  }
}
