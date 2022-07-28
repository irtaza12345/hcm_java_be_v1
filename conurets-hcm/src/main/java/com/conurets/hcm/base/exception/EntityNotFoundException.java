package com.conurets.hcm.base.exception;

/**
 * @author MSA
 * @version 1.0
 */

public class EntityNotFoundException extends BaseHCMException {
    public EntityNotFoundException(String message) {
        super(message);
    }

    public EntityNotFoundException(int code, String message) {
        super(code, message);
    }

    public EntityNotFoundException(int code, String message, Throwable cause) {
        super(code, message, cause);
    }
}