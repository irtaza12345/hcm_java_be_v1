package com.conurets.hcm.commons.base.exception;

/**
 * @author MSA
 * @version 1.0
 */

public class ConfigurationException extends BaseHCMException {
    public ConfigurationException(String message) {
        super(message);
    }

    public ConfigurationException(int code, String message) {
        super(code, message);
    }

    public ConfigurationException(int code, String message, Throwable cause) {
        super(code, message, cause);
    }
}