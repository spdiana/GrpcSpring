package com.grpc.server.exception;

public class InsufficientFundsException extends Exception {

    public InsufficientFundsException(String s) {
        super(s);
    }
}
