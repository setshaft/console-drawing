package com.drawingprogram;

import java.util.Scanner;

import com.drawingprogram.commands.CommandProcessor;
import com.drawingprogram.commands.CreateCanvas;
import com.drawingprogram.commands.Quit;
import com.drawingprogram.exceptions.InvalidCommandArguments;
import com.drawingprogram.exceptions.InvalidCommandException;
import com.drawingprogram.exceptions.InvalidCommandTypeException;
import com.drawingprogram.interfaces.CommandType;
import com.drawingprogram.interfaces.UserInputCommand;
import com.drawingprogram.types.Canvas;
import com.drawingprogram.types.TypeHelper;

public class Main {
  private static Canvas canvas;
  private static Scanner scanner;
  private static CommandProcessor commandHandler;
  private static TypeHelper commandType;

  public static void main(String[] args) throws NumberFormatException, InterruptedException {
    scanner = new Scanner(System.in);
    commandHandler = new CommandProcessor();
    commandType = new TypeHelper();

    System.out.println("Enter command:");

    while (true) {
      process(scanner.nextLine());
      System.out.println("Enter command:");
    }
  }

  private static void process(String commandLine) {
    UserInputCommand command = null;

    try {
      command = commandHandler.getCommand(commandLine);
    } catch (InvalidCommandException e) {
      System.out.println("Please enter a valid command.");
    } catch (InvalidCommandArguments invalidCommandArguments) {
      System.out.println("Command syntax is not correct: " + invalidCommandArguments.getMessage());
      System.out.println("Refer to following correct syntax: \n" + invalidCommandArguments.getHelpMessage());
    }

    if (command instanceof Quit) {
      quit();
    }

    if (command instanceof CreateCanvas) {
      createNewCanvas((CreateCanvas) command);
      return;
    }

    if (command instanceof UserInputCommand) {
      draw((CommandType) command);
    }
  }

  private static void draw(CommandType command) {
    if (canvas == null) {
      System.out.println("You need to create a canvas first");
      return;
    }
    try {
      canvas.streamType(commandType.getCommandType(command));
      canvas.render();
    } catch (InvalidCommandTypeException e) {
      System.out.println("Can not add the model to canvas: " + e.getMessage());
    }
  }

  private static void createNewCanvas(CreateCanvas userInput) {
    canvas = new Canvas(userInput.getWidth(), userInput.getHeight());
    canvas.render();
  }

  private static void quit() {
    scanner.close();
    System.out.println("Exiting...");
    System.exit(0);
  }
}
