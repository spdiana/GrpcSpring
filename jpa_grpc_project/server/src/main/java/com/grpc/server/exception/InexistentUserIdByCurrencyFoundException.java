package com.grpc.server.exception;

public class InexistentUserIdByCurrencyFoundException extends Exception {

    public InexistentUserIdByCurrencyFoundException(String s) {
        super(s);
    }
}
