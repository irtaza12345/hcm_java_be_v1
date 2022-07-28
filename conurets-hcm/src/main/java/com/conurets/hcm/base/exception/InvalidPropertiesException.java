package com.conurets.hcm.base.exception;

/**
 * @author MSA
 * @version 1.0
 */

public class InvalidPropertiesException extends BaseHCMException {
    public InvalidPropertiesException(String message) {
        super(message);
    }

    public InvalidPropertiesException(int code, String message) {
        super(code, message);
    }

    public InvalidPropertiesException(int code, String message, Throwable cause) {
        super(code, message, cause);
    }
}