package com.conurets.hcm.base.response.entity;

import com.conurets.hcm.base.dto.response.BaseResponseDTO;
import com.conurets.hcm.base.util.HCMStatusConstants;
import lombok.extern.slf4j.Slf4j;

/**
 * @author MSA
 * @version 1.0
 */

@Slf4j
public abstract class BaseResponseEntity {
    /**
     * Set base response
     *
     * @return ResponseEntity<BaseResponseDTO>
     */
    public BaseResponseDTO response() {
        return response(HCMStatusConstants.STATUS_CODE_SUCCESS, HCMStatusConstants.STATUS_MSG_SUCCESS, null);
    }

    /**
     * Set base response
     *
     * @param code
     * @param value
     * @return ResponseEntity<BaseResponseDTO>
     */
    public BaseResponseDTO response(int code, String value) {
        return response(code, value, null);
    }

    /**
     * Set base response
     *
     * @param data
     * @param <R>
     * @return ResponseEntity<BaseResponseDTO>
     */
    public <R> BaseResponseDTO response(R data) {
        return response(HCMStatusConstants.STATUS_CODE_SUCCESS, HCMStatusConstants.STATUS_MSG_SUCCESS, data);
    }

    /**
     * Set base response
     *
     * @param code
     * @param value
     * @param data
     * @param <R>
     * @return ResponseEntity<BaseResponseDTO>
     */
    public <R> BaseResponseDTO response(int code, String value, R data) {
        BaseResponseDTO<R> baseResponseDTO = new BaseResponseDTO<R>();
        baseResponseDTO.setCode(code);
        baseResponseDTO.setValue(value);
        baseResponseDTO.setData(data);

        return baseResponseDTO;
    }
}
