package com.drawingprogram.exceptions;

public class InvalidCommandTypeException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public InvalidCommandTypeException(String message) {
        super(message);
    }
}