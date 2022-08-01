package com.conurets.hcm.commons.base.cache;

import com.conurets.hcm.commons.base.exception.ConfigurationException;
import com.conurets.hcm.commons.base.exception.HCMException;
import com.conurets.hcm.commons.base.util.HCMConstants;
import com.conurets.hcm.commons.base.util.HCMUtil;
import com.conurets.hcm.commons.persistence.entity.Preference;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

/**
 * @author MSA
 * @version 1.0
 */

@Slf4j
@Component
public class PreferenceCache extends BaseCache {
    private static ConcurrentMap<String, String> map = new ConcurrentHashMap<>();

    /**
     * Init
     */
    @PostConstruct
    public void init() {
        map = new ConcurrentHashMap<>();

        findAllPreferences();
    }

    /**
     * reloadPreference
     *
     * @return
     * @throws HCMException
     */
    public ConcurrentMap<String, String> reloadPreference() throws HCMException {
        findAllPreferences();

        return map;
    }

    /**
     * findAllPreferences
     *
     * @throws HCMException
     */
    private void findAllPreferences() throws HCMException {
        List<Preference> preferences = getDaoFactory().getPreferenceDAO().findAll();

        if (HCMUtil.isCollectionNotBlank(preferences)) {
            preferences.stream().map(preference -> setCache(preference)).collect(Collectors.toList());
        }
    }

    /**
     * setProperties
     *
     * @param preference
     * @return
     */
    private ConcurrentMap<String, String> setCache(Preference preference) throws HCMException {
        setCache(preference.getName(), preference.getValue());

        return map;
    }

    /**
     * setProperties
     *
     * @param name
     * @param value
     */
    public static void setCache(String name, String value) {
        try {
            map.put(name, value);
        } catch (Exception e) {
            log.error("PreferenceCache.setCache", e.getMessage());
        }
    }

    /**
     * getProperty
     *
     * @param key
     * @return
     */
    public static String getProperty(String key) {
        return map.get(key);
    }

    /**
     * getDoubleProperty
     *
     * @param key
     * @return
     */
    public static Double getDoubleProperty(String key) {
        return new Double(getProperty(key));
    }

    /**
     * getBigDecimalProperty
     *
     * @param key
     * @return
     */
    public static BigDecimal getBigDecimalProperty(String key) {
        return new BigDecimal(getProperty(key));
    }

    /**
     * getIntegerProperty
     *
     * @param key
     * @return
     */
    public static Integer getIntegerProperty(String key) {
        return new Integer(getProperty(key));
    }

    /**
     * getLongProperty
     *
     * @param key
     * @return
     */
    public static Long getLongProperty(String key) {
        return new Long(getProperty(key));
    }

    /**
     * getDecimalFormatProperty
     *
     * @param key
     * @return
     */
    public static DecimalFormat getDecimalFormatProperty(String key) {
        return new DecimalFormat(getProperty(key));
    }

    /**
     * getBooleanProperty
     *
     * @param key
     * @return
     */
    public static boolean getBooleanProperty(String key) {
        return HCMConstants.Common.BOOLEAN_TRUE.equals(getProperty(key)) ? Boolean.TRUE : Boolean.FALSE;
    }

    /**
     * getInstance
     *
     * @param key
     * @param <T>
     * @return
     */
    public <T> T getInstance(String key) {
        try {
            String className = getProperty(key);
            return (T) Class.forName(className).newInstance();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            throw new ConfigurationException(9999, e.getMessage());
        }
    }
}
