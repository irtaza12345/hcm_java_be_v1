package com.conurets.hcm.commons.base.exception;

/**
 * @author MSA
 * @version 1.0
 */

public class UserNotFoundException extends BaseHCMException {
    public UserNotFoundException(String message) {
        super(message);
    }

    public UserNotFoundException(int code, String message) {
        super(code, message);
    }

    public UserNotFoundException(int code, String message, Throwable cause) {
        super(code, message, cause);
    }
}