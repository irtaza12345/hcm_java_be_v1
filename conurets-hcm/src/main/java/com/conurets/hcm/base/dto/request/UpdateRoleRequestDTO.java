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
public class UpdateRoleRequestDTO extends BaseRequestDTO {
    private Long roleId;
    @NotEmpty(message = "Join date must not be empty")
    @Size(min = 1, max = 80, message = "Join date must have valid format")
    private String roleName;
    @NotEmpty(message = "Join date must not be empty")
    @Size(min = 1, max = 80, message = "Join date must have valid format")
    private String roleDescription;
    private Integer status;
}