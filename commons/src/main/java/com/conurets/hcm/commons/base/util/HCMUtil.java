package com.conurets.hcm.commons.base.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author MSA
 * @version 1.0
 */

@Slf4j
public class HCMUtil {
    /**
     * String into integer
     *
     * @param input
     * @return
     */
    public static final int stringToInteger(String input) {
        int parseValue = HCMConstants.Common.INT_ZERO;
        try {
            parseValue = Integer.parseInt(input);
        } catch (Exception e) {
            parseValue = HCMConstants.Common.INT_ZERO;
        }
        return parseValue;
    }

    /**
     * String into long
     *
     * @param input
     * @return
     */
    public static final long stringToLong(String input) {
        long parseValue = HCMConstants.Common.INT_ZERO;
        try {
            parseValue = Long.parseLong(input);
        } catch (Exception e) {
            parseValue = HCMConstants.Common.INT_ZERO;
        }
        return parseValue;
    }

    /**
     * String into double
     *
     * @param input
     * @return
     */
    public static final double stringToDouble(String input) {
        double parseValue = HCMConstants.Common.INT_ZERO;
        try {
            parseValue = Double.parseDouble(input);
        } catch (Exception e) {
            parseValue = HCMConstants.Common.INT_ZERO;
        }
        return parseValue;
    }

    /**
     * Validate list
     *
     * @param list
     * @return
     */
    public static final boolean isCollectionNotBlank(Collection list) {
        return (list != null && list.size() > HCMConstants.Common.INT_ZERO) ? Boolean.TRUE : Boolean.FALSE;
    }

    /**
     * DB result status
     *
     * @return
     */
    public static List<Integer> getDBResultStatus() {
        List<Integer> statusList = new ArrayList<>();
        String[] statusArray = {"1,2"}; /*PreferenceUtil.getProperty(APConstants.DB_RESULT_STATUS)
                .split(HCMConstants.Common.SC_COMMA);*/

        for  (String status : statusArray) {
            statusList.add(HCMUtil.stringToInteger(status));
        }

        return statusList; //Arrays.asList(1, 2);
    }

    /**
     * Convert class object into string
     *
     * @param object
     * @return
     * @throws JsonProcessingException
     */
    public static String writeValue(Object object) throws JsonProcessingException {
        if (object == null) {
            return null;
        }

        ObjectMapper mapper = new ObjectMapper();

        return mapper.writeValueAsString(object);
    }

    /**
     * Convert string value into class object
     *
     * @param content
     * @param valueType
     * @param <T>
     * @return
     * @throws IOException
     */
    public static <T> T readValue(String content, Class<T> valueType) throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        return (T) mapper.readValue(content, valueType);
    }

    /**
     * Get status value
     *
     * @param status
     * @return
     */
    public static String getStatus(int status) {
        String statusValue = HCMConstants.Common.STATUS_MSG_ACTIVE;

        if (status == HCMConstants.Common.STATUS_CODE_UNKNOWN) {
            statusValue = HCMConstants.Common.STATUS_MSG_UNKNOWN;
        } else if (status == HCMConstants.Common.STATUS_CODE_ACTIVE) {
            statusValue = HCMConstants.Common.STATUS_MSG_ACTIVE;
        } else if (status == HCMConstants.Common.STATUS_CODE_INACTIVE) {
            statusValue = HCMConstants.Common.STATUS_MSG_INACTIVE;
        } else if (status == HCMConstants.Common.STATUS_CODE_DELETE) {
            statusValue = HCMConstants.Common.STATUS_MSG_DELETE;
        } else if (status == HCMConstants.Common.STATUS_CODE_TERMINATE) {
            statusValue = HCMConstants.Common.STATUS_MSG_TERMINATE;
        }
        return statusValue;
    }

    /**
     * Create role name like... ROLE_ADMIN, ROLE_USER
     *
     * @param roleName
     * @return
     */
    public static String createRoleName(String roleName) {
        int roleLength = HCMConstants.Common.INT_ZERO;

        roleName = roleName.toUpperCase();

        if (roleName.contains(HCMConstants.Common.ROLE_UNDERSOCRE)) {
            roleLength = HCMConstants.Common.ROLE_UNDERSOCRE.length();
        } else if (roleName.contains(HCMConstants.Common.ROLE_SPACE)) {
            roleLength = HCMConstants.Common.ROLE_SPACE.length();
        } else if (roleName.contains(HCMConstants.Common.ROLE)) {
            roleLength = HCMConstants.Common.ROLE.length();
        }

        roleName = roleName.substring(roleLength, roleName.length());

        roleName = new StringBuilder(HCMConstants.Common.ROLE_UNDERSOCRE).append(roleName).toString();
        roleName = roleName.replace(HCMConstants.Common.SC_SPACE, HCMConstants.Common.SC_UNDER_SCORE);
        roleName = roleName.replace(HCMConstants.Common.SC_DASH, HCMConstants.Common.SC_UNDER_SCORE);

        return roleName;
    }

    /**
     * Calc time difference
     *
     * @param startDateTime
     * @param endDateTime
     * @return
     */
    public static long calcTimeDifference(long startDateTime, long endDateTime) {
        log.info("startDateTime={}, endDateTime={}", new Date(startDateTime), new Date(endDateTime));

        return TimeUnit.MILLISECONDS.toSeconds(endDateTime - startDateTime);
    }

    /**
     * containsName
     *
     * @param list
     * @param name
     * @return
     */
    public static boolean containsName(final List<GrantedAuthority> list, final String name) {
        return list.stream().filter(o -> o.getAuthority().equals(name)).findFirst().isPresent();
    }
}
