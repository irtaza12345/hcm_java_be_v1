package com.conurets.hcm.base.exception;

/**
 * @author MSA
 * @version 1.0
 */

public class InvalidDataException extends BaseHCMException {
    public InvalidDataException(String message) {
        super(message);
    }

    public InvalidDataException(int code, String message) {
        super(code, message);
    }

    public InvalidDataException(int code, String message, Throwable cause) {
        super(code, message, cause);
    }
}