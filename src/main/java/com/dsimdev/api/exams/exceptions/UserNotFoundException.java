package com.dsimdev.api.exams.exceptions;

public class UserNotFoundException extends Exception {

    public UserNotFoundException() {
        super("The username doesn't exists");
    }

    public UserNotFoundException(String message) {
        super(message);
    }

}
