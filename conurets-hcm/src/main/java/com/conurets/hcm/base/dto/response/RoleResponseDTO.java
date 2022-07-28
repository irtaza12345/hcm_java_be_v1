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
public class RoleResponseDTO implements Serializable {
    private Long roleId;
    private String roleName;
    private String roleDescription;
    private String status;
    private String organizationName;
    private String companyName;
    private String branchName;
}