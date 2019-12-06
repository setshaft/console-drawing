package com.drawingprogram.app;

import java.util.Scanner;

class App {

    DrawingHelper window;

    public App() {
        window = new DrawingHelper();
    }

    public static void main(final String[] args) {
        final App app = new App();
        final Scanner scan = new Scanner(System.in);
        String command = new String();
        while (!command.equals("Q")) {
            System.out.println("\nenter command:");
            command = scan.nextLine();
            app.draw(command);
        }
        System.out.println("Quitting the program!");
        scan.close();
    }

    private int getInt(String str) {
        return Integer.parseInt(str);
    }

    private void draw(final String command) {
        final String[] args = command.split(" ");
        final String commandType = args[0];
        try {
            switch (commandType) {
            case "C":
                this.window = new DrawingHelper(getInt(args[1]), getInt(args[2]));
                this.window.print();
                break;
            case "L":
                this.window.streamLine(getInt(args[1]), getInt(args[2]), getInt(args[3]), getInt(args[4]), 'X');
                this.window.print();
                break;
            case "R":
                this.window.streamRectangle(getInt(args[1]), getInt(args[2]), getInt(args[3]), getInt(args[4]), 'X');
                this.window.print();
                break;
            case "B":
                this.window.fillColor(getInt(args[1]), getInt(args[2]), args[3].charAt(0));
                this.window.print();
                break;
            }
        } catch (final ArrayIndexOutOfBoundsException e) {
            System.out.println("\nCommand not valid, try again with right number of arguments.\n");
        } catch (final Exception e) {
            System.out.println("\nError: " + e.getMessage() + "\nplease try again");
        }
    }
}
