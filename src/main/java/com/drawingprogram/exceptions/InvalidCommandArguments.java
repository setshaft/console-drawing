package com.drawingprogram.exceptions;

public class InvalidCommandArguments extends RuntimeException {

    private static final long serialVersionUID = 1L;
    private final String help;

    public InvalidCommandArguments(String message, String _help) {
        super(message);
        help = _help;
    }

    public String getHelpMessage() {
        return help;
    }
}