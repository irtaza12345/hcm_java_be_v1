package com.conurets.hcm.commons.base.util;

import lombok.extern.slf4j.Slf4j;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * @author MSA
 * @version 1.0
 */

@Slf4j
public class HCMDateUtil {
    /**
     * getCurrentDate
     *
     * @return
     */
    public static Date getCurrentDate() {
        return convertInToTimeZone(new Date().getTime());
    }

    /**
     * Get current timestamp
     *
     * @return
     */
    public static final Timestamp getCurrentTimestamp() {
        return new Timestamp(new Date().getTime());
    }

    /**
     * Get date object by format
     *
     * @param input
     * @param format
     * @return
     */
    public static Date getDateByFormat(String input, String format) {
        Date date = null;
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
            date = simpleDateFormat.parse(input);
        } catch (ParseException e) {
            log.error("HCMDateUtil.getDateByFormat", e);
        }
        return date;
    }

    /**
     * Convert into time zone
     *
     * @param ts
     * @return
     */
    public static Date convertInToTimeZone(long ts) {
        SimpleDateFormat easternDateFormat = new SimpleDateFormat(HCMConstants.Common.DATE_FORMAT_MM_DD_YYYY_HH_MM_SS);
        TimeZone easternTimeZone = TimeZone.getTimeZone("UTC");

        Date currentDate = new Date(ts);
        Date datEasternTimeZone = null;

        try {
            easternDateFormat.setTimeZone(easternTimeZone);
            String strEasternTime = easternDateFormat.format(currentDate.getTime());

            SimpleDateFormat sdf = new SimpleDateFormat(HCMConstants.Common.DATE_FORMAT_MM_DD_YYYY_HH_MM_SS);
            datEasternTimeZone = sdf.parse(strEasternTime);
        } catch (ParseException e) {
            log.error("convertInToTimeZone", e);
        }

        return datEasternTimeZone;
    }
}
