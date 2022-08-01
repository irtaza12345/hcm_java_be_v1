package com.conurets.hcm.commons.base.util;

import com.conurets.hcm.commons.base.dto.response.BaseErrorResponseDTO;
import com.conurets.hcm.commons.base.exception.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Locale;

/**
 * @author MSA
 * @version 1.0
 */

@Slf4j
@Component
public class HCMMessageUtil {
    @Autowired
    private MessageSource messageSource;

    /**
     *
     * @param code
     * @throws HCMException
     */
    public void handleBase(int code) throws HCMException {
        String message = messageSource.getMessage(String.valueOf(code), null, Locale.getDefault());

        throw new HCMException(code, message);
    }

    /**
     *
     * @param response
     * @param code
     * @throws IOException
     */
    public void handleBase(HttpServletResponse response, int code) throws IOException {
        String message = messageSource.getMessage(String.valueOf(code), null, Locale.getDefault());

        message(response, code, message);
    }

    /**
     *
     * @param code
     * @throws HCMException
     */
    public void handleSessionExpired(int code) throws HCMException {
        String message = messageSource.getMessage(String.valueOf(code), null, Locale.getDefault());

        throw new InvalidSessionException(code, message);
    }

    /**
     *
     * @param code
     * @throws HCMException
     */
    public void handleNoResultFound(int code) throws HCMException {
        String message = messageSource.getMessage(String.valueOf(code), null, Locale.getDefault());

        throw new ResultNotFoundException(code, message);
    }

    /**
     *
     * @param code
     * @throws HCMException
     */
    public void handleJwt(int code) throws HCMException {
        String message = messageSource.getMessage(String.valueOf(code), null, Locale.getDefault());

        throw new JwtException(code, message);
    }

    /**
     *
     * @param code
     * @throws HCMException
     */
    public void handleValidation(int code) throws HCMException {
        String message = messageSource.getMessage(String.valueOf(code), null, Locale.getDefault());

        throw new ValidationException(code, message);
    }

    /**
     *
     * @param response
     * @param code
     * @throws IOException
     */
    public void handleAuthenticationException(HttpServletResponse response, int code) throws IOException {
        String message = messageSource.getMessage(String.valueOf(code), null, Locale.getDefault());

        message(response, code, message, HttpStatus.UNAUTHORIZED.value());
    }

    /**
     *
     * @param response
     * @param code
     * @throws IOException
     */
    public void handleAccessDeniedException(HttpServletResponse response, int code) throws IOException {
        String message = messageSource.getMessage(String.valueOf(code), null, Locale.getDefault());

        message(response, code, message);
    }

    /**
     *
     * @param response
     * @param code
     * @param message
     * @throws IOException
     */
    private void message(HttpServletResponse response, int code, String message) throws IOException {
        BaseErrorResponseDTO baseErrorResponseDTO = setBaseErrorResponse(code, message);

        response.setStatus(HttpStatus.OK.value());
        response.getWriter().write(HCMUtil.writeValue(baseErrorResponseDTO));
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
    }

    /**
     *
     * @param response
     * @param code
     * @param message
     * @param statusCode
     * @throws IOException
     */
    private void message(HttpServletResponse response, int code, String message, int statusCode) throws IOException {
        BaseErrorResponseDTO baseErrorResponseDTO = setBaseErrorResponse(code, message);

        response.setStatus((statusCode == HCMStatusConstants.STATUS_CODE_SUCCESS) ? HttpStatus.OK.value() : statusCode);
        response.getWriter().write(HCMUtil.writeValue(baseErrorResponseDTO));
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
    }

    /**
     *
     * @param response
     * @param code
     * @param message
     * @throws IOException
     */
    public static void setJwtErrorResponse(HttpServletResponse response, int code, String message) throws IOException {
        BaseErrorResponseDTO baseErrorResponseDTO = setBaseErrorResponse(code, message);

        response.setStatus(HttpStatus.NOT_FOUND.value());
        response.getWriter().write(HCMUtil.writeValue(baseErrorResponseDTO));
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
    }

    /**
     *
     * @param code
     * @param value
     * @param <R>
     * @return
     */
    public static BaseErrorResponseDTO setBaseErrorResponse(int code, String value) {
        BaseErrorResponseDTO response = new BaseErrorResponseDTO();
        response.setCode(code);
        response.setValue(value);

        return response;
    }
}
