package com.dimensiondata.client;

public class CloudServerException extends RuntimeException {
    private int errorCode;
    private String message;


    public int getErrorCode() {
        return errorCode;
    }

}
