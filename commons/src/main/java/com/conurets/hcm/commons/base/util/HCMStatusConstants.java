package com.conurets.hcm.commons.base.util;

/**
 * @author MSA
 * @version 1.0
 */

public class HCMStatusConstants {
    public static final int STATUS_CODE_SUCCESS = 0;
    public static final String STATUS_MSG_SUCCESS = "success";

    public static final int STATUS_CODE_NO_RESULT_FOUND = 101;
    public static final int STATUS_CODE_SESSION_EXPIRED = 102;
    public static final int STATUS_CODE_INVALID_SESSION = 103;
    public static final String STATUS_MSG_INVALID_SESSION = "Invalid session";

    public static final int STATUS_CODE_NO_USER_FOUND = 201;
    public static final String STATUS_MSG_NO_USER_FOUND = "No user found";
    public static final int STATUS_CODE_INVALID_CREDENTIALS = 202;
    public static final String STATUS_MSG_INVALID_CREDENTIALS = "Bad credentials";
    public static final int STATUS_CODE_INACTIVE_USER = 203;
    public static final String STATUS_MSG_INACTIVE_USER = "Inactive user";
    public static final int STATUS_CODE_USER_DELETED = 204;
    public static final String STATUS_MSG_USER_DELETED = "User already deleted";
    public static final int STATUS_CODE_FULL_AUTHENTICATION_REQUIRED  = 205;
    public static final String STATUS_MSG_FULL_AUTHENTICATION_REQUIRED = "Full authentication is required to access this resource";
    public static final int STATUS_CODE_NO_ENTITY_FOUND = 206;
    public static final String STATUS_MSG_NO_ENTITY_FOUND = "No entity found for query";
    public static final int STATUS_CODE_NO_CREDENTIAL_FOUND = 207;
    public static final String STATUS_MSG_NO_CREDENTIAL_FOUND = "No credential found";

    public static final int STATUS_CODE_NO_ROLE_FOUND = 301;
    public static final String STATUS_MSG_NO_ROLE_FOUND = "No role found";
    public static final int STATUS_CODE_NO_PRIVILEGE_FOUND = 302;
    public static final int STATUS_CODE_NO_ROLE_ASSIGNED = 303;
    public static final int STATUS_CODE_NO_PRIVILEGE_ASSIGNED = 304;
    public static final String STATUS_MSG_NO_PRIVILEGE_ASSIGNED = "No privilege assigned";
    public static final int STATUS_CODE_NO_USER_ROLE_FOUND = 305;
    public static final String STATUS_MSG_NO_USER_ROLE_FOUND = "No user role found";

    public static final int STATUS_CODE_INVALID_TOKEN = 901;
    public static final int STATUS_CODE_ACCESS_DENIED = 902;
    public static final int STATUS_CODE_TOKEN_EXPIRED = 903;

    public static final int STATUS_CODE_NO_TOKEN_FOUND = 904;

    public static final int STATUS_CODE_JWT_INVALID_SIGNATURE = 911;
    public static final int STATUS_CODE_JWT_MALFORMED = 912;
    public static final int STATUS_CODE_JWT_EXPIRED = 913;
    public static final int STATUS_CODE_JWT_UNSUPPORTED = 914;
    public static final int STATUS_CODE_JWT_ILLEGAL_ARGUMENT = 915;

    public static final int STATUS_CODE_INVALID_DATA = 9999;
}
