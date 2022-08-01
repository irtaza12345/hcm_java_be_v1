package com.conurets.hcm.commons.base.exception;

import com.conurets.hcm.commons.base.dto.response.BaseErrorResponseDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author MSA
 * @version 1.0
 */

@Slf4j
@ControllerAdvice
public class HCMExceptionHandler {
    /**
     * HCMException
     *
     * @param e
     * @return
     */
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(HCMException.class)
    public BaseErrorResponseDTO handleHCM(HCMException e) {
        return response(e.getCode(), e.getMessage(), e);
    }

    /**
     * ResultNotFoundException
     *
     * @param e
     * @return
     */
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(ResultNotFoundException.class)
    public BaseErrorResponseDTO handleResultNotFound(ResultNotFoundException e) {
        return response(e.getCode(), e.getMessage(), e);
    }

    /**
     * InvalidDataException
     *
     * @param e
     * @return
     */
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(InvalidDataException.class)
    public BaseErrorResponseDTO handleInvalidData(InvalidDataException e) {
        return response(e.getCode(), e.getMessage(), e);
    }

    /**
     * ConfigurationException
     *
     * @param e
     * @return
     */
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(ConfigurationException.class)
    public BaseErrorResponseDTO handleConfiguration(ConfigurationException e) {
        return response(e.getCode(), e.getMessage(), e);
    }

    /**
     * BaseErrorResponseDTO
     *
     * @param code
     * @param value
     * @return
     */
    private BaseErrorResponseDTO response(int code, String value) {
        BaseErrorResponseDTO response = new BaseErrorResponseDTO();
        response.setCode(code);
        response.setValue(value);

        return response;
    }

    /**
     * BaseErrorResponseDTO
     *
     * @param code
     * @param value
     * @param e
     * @return
     */
    private BaseErrorResponseDTO response(int code, String value, Throwable e) {
        log.error("error", e);

        return response(code, value);
    }
}
