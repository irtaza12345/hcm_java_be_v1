package com.conurets.hcm.commons.base.util;

import lombok.extern.slf4j.Slf4j;

/**
 * @author MSA
 * @version 1.0
 */

@Slf4j
public class HCMConstants {
    public static final class Common {
        public static final int INT_ZERO = 0;
        public static final int INT_ONE = 1;
        public static final int INT_TWO = 2;
        public static final int INT_THREE = 3;
        public static final int INT_FOUR = 4;
        public static final int INT_FIVE = 5;
        public static final int INT_SIX = 6;
        public static final int INT_SEVEN = 7;
        public static final int INT_EIGHT = 8;
        public static final int INT_NINE = 9;
        public static final int INT_TEN = 10;
        public static final int INT_ELEVEN = 11;
        public static final int INT_TWELVE = 12;
        public static final int INT_THIRTEEN = 13;
        public static final int INT_FOURTEEN = 14;
        public static final int INT_FIFTEEN = 15;
        public static final int INT_SIXTEEN = 16;
        public static final int INT_SEVENTEEN = 17;
        public static final int INT_EIGHTEEN = 18;
        public static final int INT_NINETEEN = 19;
        public static final int INT_TWENTY = 20;

        public static final String SC_EMPTY = "";
        public static final String SC_STAR = "*";
        public static final String SC_SPACE = " ";
        public static final String SC_DASH = "-";
        public static final String SC_DOT = ".";
        public static final String SC_FALSE = "false";
        public static final String SC_COLON = ":";
        public static final String SC_COLON_SPACE = ": ";
        public static final String SC_UNDER_SCORE = "_";
        public static final String SC_BACK_SLASH = "\\";
        public static final String SC_FORWARD_SLASH = "/";
        public static final String SC_DOUBLE_FORWARD_SLASH = "//";
        public static final String SC_AT_THE_RATE = "@";
        public static final String SC_GREATER_THAN = ">";
        public static final String SC_LESS_THAN = "<";
        public static final String SC_NULL = "null";
        public static final String SC_COMMA = ",";
        public static final String LEFT_BRACE = "{";
        public static final String RIGHT_BRACE = "}";
        public static final String SC_DASH_WITH_SPACE = " - ";

        public static final String SC_T = "T";

        public static final int STATUS_CODE_UNKNOWN = 0;
        public static final int STATUS_CODE_ACTIVE = 1;
        public static final int STATUS_CODE_INACTIVE = 2;
        public static final int STATUS_CODE_DELETE = 3;
        public static final int STATUS_CODE_TERMINATE = 4;
        public static final int STATUS_CODE_LOGGED_IN = 5;
        public static final int STATUS_CODE_LOGGED_OUT = 6;

        public static final String STATUS_MSG_UNKNOWN = "Unknown";
        public static final String STATUS_MSG_ACTIVE = "Active";
        public static final String STATUS_MSG_INACTIVE = "Inactive";
        public static final String STATUS_MSG_DELETE = "Deleted";
        public static final String STATUS_MSG_TERMINATE = "Terminate";
        public static final String STATUS_MSG_LOGGED_IN = "Active logged in";
        public static final String STATUS_MSG_LOGGED_OUT = "Logged out";

        public static final String ROLE = "ROLE";
        public static final String ROLE_SPACE = "ROLE ";
        public static final String ROLE_UNDERSOCRE = "ROLE_";

        public static final String EVENT_TYPE_IN = "IN";
        public static final String EVENT_TYPE_OUT = "OUT";
        public static final String EVENT_TYPE_EARLY = "EARLY";
        public static final String EVENT_TYPE_EARLY_OUT = "EARLY_OUT";

        public static final String DATE_FORMAT_MM_DD_YYYY = "MM-dd-yyyy";
        public static final String DATE_FORMAT_MM_DD_YYYY_HH_MM_SS = "MM-dd-yyyy HH:mm:ss";

        public static final int VERIFY_METHOD_FINGER_PRINT = 1;
        public static final int VERIFY_METHOD_RFID = 2;
        public static final int VERIFY_METHOD_FACE = 16;

        public static final String BOOLEAN_TRUE = "true";
        public static final String BOOLEAN_FALSE = "false";

        public static final long DEFAULT_USER_ID = 0;
    }

    public static final class Header {
        public static final String AUTHORIZATION = "Authorization";
        public static final String AUTHORIZATION_BEARER = "Bearer";
        public static final String AUTHORIZATION_BASIC = "Basic";
        public static final String AUTHORIZATION_BEARER_SPACE = "Bearer ";
        public static final String AUTHORIZATION_BASIC_SPACE = "Basic ";

        public static final String ALLOW_METHOD_HEAD = "HEAD";
        public static final String ALLOW_METHOD_GET = "GET";
        public static final String ALLOW_METHOD_POST = "POST";
        public static final String ALLOW_METHOD_PUT = "PUT";
        public static final String ALLOW_METHOD_DELETE = "DELETE";
        public static final String ALLOW_METHOD_PATCH = "PATCH";

        public static final String ALLOW_HEADER_AUTHORIZATION = "Authorization";
        public static final String ALLOW_HEADER_CACHE_CONTROL = "Cache-Control";
        public static final String ALLOW_HEADER_CONTENT_TYPE = "Content-Type";

        public static final String ALLOW_PATH = "/**";
    }
}
