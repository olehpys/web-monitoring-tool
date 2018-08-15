package com.pisarenko.webmonitoringtool.exception;

public class ProvideSupportException extends RuntimeException {

    public ProvideSupportException() {
        super();
    }

    public ProvideSupportException(String message) {
        super(message);
    }

    public ProvideSupportException(String message, Throwable cause) {
        super(message, cause);
    }


    public ProvideSupportException(Throwable throwable) {
        super(throwable);
    }

    public ProvideSupportException(String message, Throwable throwable, boolean enableSuppression, boolean writableStackTrace) {
        super(message, throwable, enableSuppression, writableStackTrace);
    }
}
