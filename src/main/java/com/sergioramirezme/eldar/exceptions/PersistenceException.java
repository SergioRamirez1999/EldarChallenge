package com.sergioramirezme.eldar.exceptions;

import java.io.Serializable;

public class PersistenceException extends Exception implements Serializable {

    public PersistenceException() {
        super();
    }

    public PersistenceException(String msg) {
        super(msg);
    }

    public PersistenceException(String msg, Exception e) {
        super(msg,e);
    }
}
