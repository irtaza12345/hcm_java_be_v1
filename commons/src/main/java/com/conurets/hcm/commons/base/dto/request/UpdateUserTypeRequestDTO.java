package com.conurets.hcm.commons.base.dto.request;

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
public class UpdateUserTypeRequestDTO extends BaseRequestDTO {
    @NotNull(message = "Role ID must not be null")
    private Long roleId;
    @NotNull(message = "ID must not be null")
    private Long userTypeId;
    @NotEmpty(message = "User type name must not be empty")
    @Size(min = 1, max = 80, message = "User type name must have valid format")
    private String name;
    @NotEmpty(message = "Description must not be empty")
    @Size(min = 1, max = 200, message = "Description must have valid format")
    private String description;
    @NotNull(message = "System user must not be null")
    private Boolean systemUser;
    @NotNull(message = "Internal user must not be null")
    private Boolean internalUser;
    @NotNull(message = "Super user must not be null")
    private Boolean superUser;
    @NotNull(message = "Read only must not be null")
    private Boolean readOnly;
    @NotNull(message = "Organization admin must not be null")
    private Boolean organizationAdmin;
    @NotNull(message = "Company admin must not be null")
    private Boolean companyAdmin;
    @NotNull(message = "Branch admin must not be null")
    private Boolean branchAdmin;
    private Integer status;
}