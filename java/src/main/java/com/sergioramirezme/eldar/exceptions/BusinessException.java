package com.sergioramirezme.eldar.exceptions;

import java.io.Serializable;

public class BusinessException extends Exception implements Serializable {

    public BusinessException() {
        super();
    }

    public BusinessException(String msg) {
        super(msg);
    }

    public BusinessException(Exception e) {
        super(e);
    }

    public BusinessException(String msg, Exception e) {
        super(msg,e);
    }
}
