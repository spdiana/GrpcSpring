package com.grpc.server.exception;

public class UnknownCurrencyException extends Exception{

    public UnknownCurrencyException(String s) {
        super(s);
    }
}
