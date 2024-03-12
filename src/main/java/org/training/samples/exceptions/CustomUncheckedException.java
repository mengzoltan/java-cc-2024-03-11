package org.training.samples.exceptions;

public class CustomUncheckedException extends RuntimeException {

    private String user;

    public String getUser() {
        return user;
    }

    public CustomUncheckedException() {
    }

    public CustomUncheckedException(String message) {
        super(message);
    }

    public CustomUncheckedException(String message, Throwable cause) {
        super(message, cause);
    }

    public CustomUncheckedException(String message, String user) {
        super(message);
        this.user = user;
    }
}
