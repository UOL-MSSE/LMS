package com.uol.msse.exception;


public class ManageUserException extends Exception {

    public ManageUserException(String message) {
        super(message);
    }

    public ManageUserException(String message, Throwable e) {
        super(message, e);
    }


}
