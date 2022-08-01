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
public class AuthenticationResponseDTO implements Serializable {
    private Long organizationId;
    private Long userId;
    private String displayName;
    private String designation;
    private String token;
}
