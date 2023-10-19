package com.dsimdev.api.exams.exceptions;

public class UserFoundException extends Exception {

    public UserFoundException() {
        super("Username already exists, please try again");
    }

    public UserFoundException(String message) {
        super(message);
    }

}
