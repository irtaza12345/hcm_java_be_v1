package com.conurets.hcm.logging.impl;

import com.conurets.hcm.base.util.HCMConstants;
import com.conurets.hcm.base.util.HCMUtil;
import com.conurets.hcm.logging.BaseLogging;
import com.conurets.hcm.persistence.entity.UserActivity;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import java.util.Arrays;

/**
 * @author MSA
 * @version 1.0
 */

@Slf4j
@Aspect
@Component
public class UserActivityLoggingImpl extends BaseLogging {
    /**
     * userActivityLogMethod
     *
     * @param proceedingJoinPoint
     * @return
     * @throws Throwable
     */
    @Around("userActivityLogMethod()")
    public Object logAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object result = null;

        try {
            final StopWatch stopWatch = new StopWatch();

            stopWatch.start();
            result = proceedingJoinPoint.proceed();

            Object argsObject = proceedingJoinPoint.getArgs()[HCMConstants.Common.INT_ZERO];

            //log.info("argsObject={}", argsObject);

            String requestClazz = argsObject.getClass().toString();
            String requestJson = HCMUtil.writeValue(argsObject);

            //log.info("requestClazz={}, requestJson={}", requestClazz, requestJson);

            UserActivity userActivity = new UserActivity();
            userActivity.setUser(getDaoFactory().getUserDAO().findById(1L));
            userActivity.setServiceName(proceedingJoinPoint.getSignature().toString());
            userActivity.setRequest(argsObject.getClass().toString());
            userActivity.setRequestData(requestJson);
            userActivity.setStatus(HCMConstants.Common.STATUS_CODE_ACTIVE);

            getDaoFactory().getUserActivityDAO().save(userActivity);

            stopWatch.stop();

            log.info("Execution time of " + proceedingJoinPoint.getSignature() + " :: " + stopWatch.getTotalTimeMillis() + " ms");

            return result;
        } catch (IllegalArgumentException e) {
            log.error("UserActivityLoggingImpl.logAround: {} in {}.{}()", Arrays.toString(proceedingJoinPoint.getArgs()),
                    proceedingJoinPoint.getSignature().getDeclaringTypeName(), proceedingJoinPoint.getSignature().getName());

            throw e;
        }
    }
}