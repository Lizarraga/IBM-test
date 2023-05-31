package com.pablolizarraga.ibmtest.exception;


public record ErrorMessage(
        String exception,
        String message,
        String path
) {
    public ErrorMessage(Exception exception, String path) {
        this(
                exception.getClass().getSimpleName(),
                exception.getMessage(),
                path
        );
    }
}
