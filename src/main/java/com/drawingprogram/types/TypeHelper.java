package com.drawingprogram.types;

import com.drawingprogram.commands.DrawFill;
import com.drawingprogram.commands.DrawLine;
import com.drawingprogram.commands.DrawRectangle;
import com.drawingprogram.interfaces.CommandType;
import com.drawingprogram.interfaces.SupportedType;

public class TypeHelper {

  public SupportedType getCommandType(final CommandType userInput) {
    if (userInput instanceof DrawLine) {
      final DrawLine command = (DrawLine) userInput;
      return new Line(command.getX1(), command.getY1(), command.getX2(), command.getY2());
    } else if (userInput instanceof DrawRectangle) {
      final DrawRectangle command = (DrawRectangle) userInput;
      return new Rectangle(command.getX1(), command.getY1(), command.getX2(), command.getY2());
    } else if (userInput instanceof DrawFill) {
      final DrawFill command = (DrawFill) userInput;
      return new Bucket(command.getX(), command.getY(), command.getCharacter());
    }
    return null;
  }
}
