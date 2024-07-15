package com.github.ih0rd.exceptions;

public class GraalVMPlaygroundException extends RuntimeException {
    public GraalVMPlaygroundException(String message) {
        super(message);
    }

    public GraalVMPlaygroundException(String message, Throwable cause) {
        super(message, cause);
    }
}
