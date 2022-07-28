package com.conurets.hcm.base.exception;

/**
 * @author MSA
 * @version 1.0
 */

public class InvalidSessionException extends BaseHCMException {
    public InvalidSessionException(String message) {
        super(message);
    }

    public InvalidSessionException(int code, String message) {
        super(code, message);
    }

    public InvalidSessionException(int code, String message, Throwable cause) {
        super(code, message, cause);
    }
}