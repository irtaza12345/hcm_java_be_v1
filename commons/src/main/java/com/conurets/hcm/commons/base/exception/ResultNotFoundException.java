package com.conurets.hcm.commons.base.exception;

/**
 * @author MSA
 * @version 1.0
 */

public class ResultNotFoundException extends BaseHCMException {
    public ResultNotFoundException(String message) {
        super(message);
    }

    public ResultNotFoundException(int code, String message) {
        super(code, message);
    }

    public ResultNotFoundException(int code, String message, Throwable cause) {
        super(code, message, cause);
    }
}