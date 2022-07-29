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
public class AddDepartmentRequestDTO extends BaseRequestDTO {
    @NotEmpty(message = "Department code must not be empty")
    @Size(min = 1, max = 80, message = "Department code must have valid format")
    private String departmentCode;
    @NotEmpty(message = "Department name must not be empty")
    @Size(min = 1, max = 80, message = "Department name must have valid format")
    private String departmentName;
    @NotEmpty(message = "Status must not be null")
    private Integer status;
}