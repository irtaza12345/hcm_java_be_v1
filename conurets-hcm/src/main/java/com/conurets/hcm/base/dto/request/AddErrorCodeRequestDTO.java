package com.conurets.hcm.base.dto.request;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author MSA
 * @version 1.0
 */

@Data
@EqualsAndHashCode(callSuper = false)
public class AddErrorCodeRequestDTO extends BaseRequestDTO {
    @NotNull(message = "Error code must not be null")
    private Integer errorCode;
    @NotEmpty(message = "Error level must not be empty")
    @Size(min = 1, max = 80, message = "Error level must have valid format")
    private String errorLevel;
    @NotEmpty(message = "Error information must not be empty")
    @Size(min = 1, max = 80, message = "Error information must have valid format")
    private String information;
    @NotNull(message = "Status must not be null")
    private Integer status;
}