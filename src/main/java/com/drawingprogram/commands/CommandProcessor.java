package com.drawingprogram.commands;

import java.util.Arrays;

import com.drawingprogram.exceptions.InvalidCommandArguments;
import com.drawingprogram.exceptions.InvalidCommandException;
import com.drawingprogram.interfaces.CommandType;

public class CommandProcessor {
  public CommandType getCommand(String command) throws InvalidCommandException, InvalidCommandArguments {

    command = command.trim().replaceAll(" {2}", " ");
    String[] split = command.split(" ");
    String type = split[0].toUpperCase();
    String[] arguments = Arrays.copyOfRange(split, 1, split.length);

    switch (type) {
    case "Q":
      return new Quit();
    case "C":
      return new CreateCanvas(arguments);
    case "L":
      return new DrawLine(arguments);
    case "R":
      return new DrawRectangle(arguments);
    case "B":
      return new DrawFill(arguments);
    default:
      throw new InvalidCommandException();
    }
  }
}
