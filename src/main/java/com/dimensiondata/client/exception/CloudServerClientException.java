package com.dimensiondata.client.exception;

public class CloudServerClientException extends RuntimeException {

    int statusCode;

    public CloudServerClientException(String message, Throwable e, int statusCode) {
        super(message, e);
        this.statusCode = statusCode;
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append("HTTP status code= " ).append(statusCode).append("\n")
                .append("Message=").append( getMessage()).toString();
    }

}
