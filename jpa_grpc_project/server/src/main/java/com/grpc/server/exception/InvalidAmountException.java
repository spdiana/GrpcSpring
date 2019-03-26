package com.grpc.server.exception;

public class InvalidAmountException extends Exception {

    public InvalidAmountException(String s) {
        super(s);
    }
}
