package com.conurets.hcm.base.exception;

/**
 * @author MSA
 * @version 1.0
 */

public class BaseHCMException extends RuntimeException {
    private int code;

    public BaseHCMException(String message) {
        super(message);
    }

    public BaseHCMException(int code, String message) {
        super(message);
        this.code = code;
    }

    public BaseHCMException(int code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }

    public final int getCode() {
        return this.code;
    }

    public String getMessage() {
        return super.getMessage();
    }
}