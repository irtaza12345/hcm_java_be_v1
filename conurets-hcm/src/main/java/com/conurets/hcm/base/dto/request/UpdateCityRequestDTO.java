package com.conurets.hcm.base.dto.request;

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
public class UpdateCityRequestDTO extends BaseRequestDTO {
    private Long stateId;
    private Long cityId;
    @NotEmpty(message = "Join date must not be empty")
    @Size(min = 1, max = 80, message = "Join date must have valid format")
    private String cityName;
    @NotEmpty(message = "Join date must not be empty")
    @Size(min = 1, max = 80, message = "Join date must have valid format")
    private String cityCode;
    private Integer status;
}