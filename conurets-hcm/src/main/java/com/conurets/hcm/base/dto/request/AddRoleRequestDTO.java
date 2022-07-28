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
public class AddRoleRequestDTO extends BaseRequestDTO {
    @NotEmpty(message = "Role name must not be empty")
    @Size(min = 1, max = 80, message = "Role name must have valid format")
    private String roleName;
    @NotEmpty(message = "Role description must not be empty")
    @Size(min = 1, max = 80, message = "Role description must have valid format")
    private String roleDescription;
    private Integer status;
}