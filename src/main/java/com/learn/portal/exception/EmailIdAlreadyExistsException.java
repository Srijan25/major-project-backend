package com.learn.portal.exception;

public class EmailIdAlreadyExistsException extends RuntimeException {

    public EmailIdAlreadyExistsException() {
        super(String.format("Email already exists!"));
    }
}
