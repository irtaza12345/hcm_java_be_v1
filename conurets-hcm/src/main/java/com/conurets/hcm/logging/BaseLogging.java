package com.conurets.hcm.logging;

import com.conurets.hcm.persistence.factory.DAOFactory;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author MSA
 * @version 1.0
 */

@Getter
@Slf4j
public abstract class BaseLogging {
    @Autowired
    private DAOFactory daoFactory;

    /**
     * userActivityLogMethod
     */
    @Pointcut("@annotation(com.conurets.hcm.logging.annotation.UserActivityLog)")
    protected void userActivityLogMethod() {
    }
}