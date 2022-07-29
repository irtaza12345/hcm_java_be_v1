package com.conurets.hcm.commons.base.exception;

/**
 * @author MSA
 * @version 1.0
 */

public class HCMException extends BaseHCMException {
    public HCMException(String message) {
        super(message);
    }

    public HCMException(int code, String message) {
        super(code, message);
    }

    public HCMException(int code, String message, Throwable cause) {
        super(code, message, cause);
    }
}