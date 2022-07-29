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
public class PreferenceResponseDTO implements Serializable {
    private Long organizationId;
    private String organizationName;
    private Long companyId;
    private String companyName;
    private Long branchId;
    private String branchName;
    private Long preferenceId;
    private String name;
    private String value;
    private String description;
    private String status;
}