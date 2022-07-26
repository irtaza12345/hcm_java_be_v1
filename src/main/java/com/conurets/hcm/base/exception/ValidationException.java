package com.conurets.hcm.base.exception;

/**
 * @author MSA
 * @version 1.0
 */

public class ValidationException extends BaseHCMException {
    public ValidationException(String message) {
        super(message);
    }

    public ValidationException(int code, String message) {
        super(code, message);
    }

    public ValidationException(int code, String message, Throwable cause) {
        super(code, message, cause);
    }
}
