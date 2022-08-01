package com.conurets.hcm.commons.security.exception;

import com.conurets.hcm.commons.base.util.HCMMessageUtil;
import com.conurets.hcm.commons.base.util.HCMStatusConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;

/**
 * @author MSA
 * @version 1.0
 */

@Slf4j
@Component
public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint, Serializable {
    @Autowired
    private HCMMessageUtil messageUtil;

    /**
     * commence
     *
     * @param request
     * @param response
     * @param e
     * @throws IOException
     */
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException {
        String uri = request.getRequestURI();

        log.info("=================================================================================================");
        log.info("CustomAuthenticationEntryPoint.commence start");
        log.info("=================================================================================================");
        log.info("CustomAuthenticationEntryPoint.commence message={}", e.getMessage());
        log.info("CustomAuthenticationEntryPoint.commence uri={}", uri);

        if (HCMStatusConstants.STATUS_MSG_INVALID_CREDENTIALS.equals(e.getMessage())) {
            messageUtil.setJwtErrorResponse(response, HCMStatusConstants.STATUS_CODE_NO_USER_FOUND, "no user found");
        } else if (HCMStatusConstants.STATUS_MSG_FULL_AUTHENTICATION_REQUIRED.equals(e.getMessage())) {
            messageUtil.setJwtErrorResponse(response, HCMStatusConstants.STATUS_CODE_FULL_AUTHENTICATION_REQUIRED, "Invalid access");
        } else {
            messageUtil.setJwtErrorResponse(response, HCMStatusConstants.STATUS_CODE_INVALID_TOKEN, "Invalid token");
        }

        log.info("=================================================================================================");
    }
}
