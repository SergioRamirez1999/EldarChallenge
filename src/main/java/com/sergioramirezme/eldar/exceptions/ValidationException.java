package com.sergioramirezme.eldar.exceptions;

import java.io.Serializable;

public class ValidationException extends Exception implements Serializable {

    public ValidationException() {
        super();
    }

    public ValidationException(String msg) {
        super(msg);
    }

    public ValidationException(String msg, Exception e) {
        super(msg,e);
    }
}
