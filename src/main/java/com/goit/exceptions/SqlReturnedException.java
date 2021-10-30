package com.goit.exceptions;

public class SqlReturnedException extends RuntimeException {

    public SqlReturnedException(String message) {
        super(message);
    }
}