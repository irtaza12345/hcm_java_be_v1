package com.conurets.hcm.base.dto.response;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @author MSA
 * @version 1.0
 */

@Data
@EqualsAndHashCode(callSuper = false)
public class UserTypeResponseDTO implements Serializable {
    private Long organizationId;
    private String organizationName;
    private Long companyId;
    private String companyName;
    private Long branchId;
    private String branchName;
    private Long roleId;
    private String roleName;
    private Long userTypeId;
    private String name;
    private String description;
    private Boolean systemUser;
    private Boolean internalUser;
    private Boolean superUser;
    private Boolean readOnly;
    private Boolean organizationAdmin;
    private Boolean companyAdmin;
    private Boolean branchAdmin;
    private String status;
}