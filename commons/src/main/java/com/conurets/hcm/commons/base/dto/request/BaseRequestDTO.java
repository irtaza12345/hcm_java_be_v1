package com.conurets.hcm.commons.base.dto.request;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @author MSA
 * @version 1.0
 */

@Data
@EqualsAndHashCode(callSuper=false)
public class BaseRequestDTO implements Serializable {
    private String origin;
    private Long organizationId;
    private Long branchId;
}