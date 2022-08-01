package com.conurets.hcm.commons.base.dto.request;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 * @author MSA
 * @version 1.0
 */

@Data
@EqualsAndHashCode(callSuper = false)
public class UpdateErrorCodeRequestDTO extends BaseRequestDTO {
    private Long errorCodeId;
    private Integer errorCode;
    @NotEmpty(message = "Join date must not be empty")
    @Size(min = 1, max = 80, message = "Join date must have valid format")
    private String errorLevel;
    @NotEmpty(message = "Join date must not be empty")
    @Size(min = 1, max = 80, message = "Join date must have valid format")
    private String information;
    private Integer status;
}