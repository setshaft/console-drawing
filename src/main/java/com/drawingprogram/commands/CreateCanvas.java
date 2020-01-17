package com.drawingprogram.commands;

import com.drawingprogram.exceptions.InvalidCommandArguments;
import com.drawingprogram.interfaces.CommandType;

public class CreateCanvas implements CommandType {

  private static String helpMessage = "C w h Should create a new canvas of width w and height h.";
  private int height;
  private int width;

  public CreateCanvas(final String... arguments) {
    if (arguments.length < 2) {
      throw new InvalidCommandArguments("For creating canvas two arguments are required", helpMessage);
    }

    setWidth(Integer.parseInt(arguments[0]));
    setHeight(Integer.parseInt(arguments[1]));
  }

  public int getHeight() {
    return height;
  }

  public void setHeight(final int height) {
    this.height = height;
  }

  public int getWidth() {
    return width;
  }

  public void setWidth(final int width) {
    this.width = width;
  }

}
