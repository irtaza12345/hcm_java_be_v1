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
public class UpdatePreferenceRequestDTO extends BaseRequestDTO {
    @NotNull(message = "Preference ID must not be null")
    private Long preferenceId;
    @NotEmpty(message = "Preference name must not be empty")
    @Size(min = 1, max = 80, message = "Preference name must have valid format")
    private String name;
    @NotEmpty(message = "Preference value must not be empty")
    @Size(min = 1, max = 80, message = "Preference value must have valid format")
    private String value;
    @NotEmpty(message = "Preference description must not be empty")
    @Size(min = 1, max = 80, message = "Preference description must have valid format")
    private String description;
    @NotNull(message = "Status must not be null")
    private Integer status;
}