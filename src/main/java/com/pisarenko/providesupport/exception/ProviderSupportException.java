package com.pisarenko.providesupport.exception;

public class ProviderSupportException extends RuntimeException {

    public ProviderSupportException() {
        super();
    }

    public ProviderSupportException(String message) {
        super(message);
    }

    public ProviderSupportException(String message, Throwable cause) {
        super(message, cause);
    }


    public ProviderSupportException(Throwable throwable) {
        super(throwable);
    }

    public ProviderSupportException(String message, Throwable throwable, boolean enableSuppression, boolean writableStackTrace) {
        super(message, throwable, enableSuppression, writableStackTrace);
    }
}
