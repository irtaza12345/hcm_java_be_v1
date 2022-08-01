package com.conurets.hcm.commons.base.util;

import com.conurets.hcm.commons.base.exception.ConfigurationException;
import com.conurets.hcm.commons.base.exception.JwtException;
import com.conurets.hcm.commons.base.exception.ResultNotFoundException;
import com.conurets.hcm.commons.base.exception.UserNotFoundException;

/**
 * @author MSA
 * @version 1.0
 */

public class HCMHelper {
    /**
     * Check Configuration
     *
     * @param object
     * @param value
     */
    public static void checkConfiguration(Object object, String value) {
        if (object == null) {
            throw new ConfigurationException(9999, value);
        }
    }

    /**
     * Handle ResultNotFound
     *
     * @param object
     */
    public static void handleResultNotFound(Object object) {
        if (object == null) {
            handleResultNotFound(object, 101, "No result found");
        }
    }

    /**
     * Handle ResultNotFound
     *
     * @param object
     * @param code
     * @param message
     */
    public static void handleResultNotFound(Object object, int code, String message) {
        if (object == null) {
            throw new ResultNotFoundException(code, message);
        }
    }

    /**
     * Handle ResultNotFound
     *
     * @param code
     * @param message
     */
    public static void handleResultNotFound(int code, String message) {
        throw new ResultNotFoundException(code, message);
    }

    /**
     * Handle UserNotFound
     *
     * @param object
     * @param code
     * @param message
     */
    public static void handleUserNotFound(Object object, int code, String message) {
        if (object == null) {
            throw new UserNotFoundException(code, message);
        }
    }

    /**
     * Handle UserNotFound
     *
     * @param code
     * @param message
     */
    public static void handleUserNotFound(int code, String message) {
        throw new UserNotFoundException(code, message);
    }

    /**
     * Handle Jwt
     *
     * @param code
     * @param message
     */
    public static void handleJwt(int code, String message) {
        throw new JwtException(code, message);
    }

    /**
     * Authentication exception
     *
     * @param code
     * @param message
     */
    public static void handleAuthentication(int code, String message) {
        throw new JwtException(code, message);
    }
}
