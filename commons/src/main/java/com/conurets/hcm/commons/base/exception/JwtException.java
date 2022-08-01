package com.conurets.hcm.commons.base.exception;

/**
 * @author MSA
 * @version 1.0
 */

public class JwtException extends BaseHCMException {
    public JwtException(String message) {
        super(message);
    }

    public JwtException(int code, String message) {
        super(code, message);
    }

    public JwtException(int code, String message, Throwable cause) {
        super(code, message, cause);
    }
}
