package com.dimensiondata.marshaller.exception;

public class UnmarshallException extends RuntimeException {

    public UnmarshallException(String message, Throwable e ) {
        super(message, e);
    }
}
