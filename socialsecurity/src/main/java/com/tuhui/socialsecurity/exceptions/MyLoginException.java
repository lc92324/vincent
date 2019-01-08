package com.tuhui.socialsecurity.exceptions;

public class MyLoginException extends RuntimeException {

    public MyLoginException() {
        super();
    }

    public MyLoginException(String message) {
        super(message);
    }

    public MyLoginException(String message, Throwable cause) {
        super(message, cause);
    }

    public MyLoginException(Throwable cause) {
        super(cause);
    }

    protected MyLoginException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
