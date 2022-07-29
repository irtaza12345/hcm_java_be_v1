package com.conurets.hcm.commons.security.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author MSA
 * @version 1.0
 */

@Slf4j
@Component
public class CustomAccessDeniedHandler implements AccessDeniedHandler {
    /**
     * handle
     *
     * @param request
     * @param response
     * @param e
     * @throws IOException
     * @throws ServletException
     */
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException e)
            throws IOException, ServletException {
        log.info("=================================================================================================");
        log.info("CustomAccessDeniedHandler.handle start");
        log.info("=================================================================================================");
        log.info("CustomAccessDeniedHandler.handle message={}", e.getMessage());

        response.sendError(HttpServletResponse.SC_PROXY_AUTHENTICATION_REQUIRED, "Access is denied");

        log.info("=================================================================================================");
    }
}
