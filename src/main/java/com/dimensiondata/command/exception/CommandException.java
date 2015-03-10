package com.dimensiondata.command.exception;

public class CommandException extends RuntimeException {

    public CommandException(String message, Throwable exception) {
        super(message, exception);
    }
}
