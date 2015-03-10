package com.dimensiondata.command;

public interface Command<O> {
    O execute();
}
