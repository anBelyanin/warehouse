package org.core.exceptions;

public class BusinessException extends Exception {

    private String message;

    public BusinessException(String message) {
        super();
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
