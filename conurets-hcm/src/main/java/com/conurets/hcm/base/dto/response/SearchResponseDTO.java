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
public class SearchResponseDTO implements Serializable {
    private Long userId;
    private Long organizationId;
    private Long companyId;
    private Long branchId;
    private String displayName;
    private String token;
    private String role;
}