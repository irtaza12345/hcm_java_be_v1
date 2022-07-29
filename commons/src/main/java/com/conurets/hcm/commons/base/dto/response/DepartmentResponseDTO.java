package com.conurets.hcm.commons.base.dto.response;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @author MSA
 * @version 1.0
 */

@Data
@EqualsAndHashCode(callSuper = false)
public class DepartmentResponseDTO implements Serializable {
    private String organizationName;
    private String companyName;
    private String branchName;
    private Long departmentId;
    private String departmentCode;
    private String departmentName;
    private String status;
}