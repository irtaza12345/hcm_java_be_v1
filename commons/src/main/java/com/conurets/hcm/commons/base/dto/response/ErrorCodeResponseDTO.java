package com.conurets.hcm.commons.base.dto.response;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @author MSA
 * @version 1.0
 */

@Data
@EqualsAndHashCode(callSuper = false)
public class ErrorCodeResponseDTO implements Serializable {
    private Long errorCodeId;
    private Integer errorCode;
    private String errorLevel;
    private String information;
    private String status;
}