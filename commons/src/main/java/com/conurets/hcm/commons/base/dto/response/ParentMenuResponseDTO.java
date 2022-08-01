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
public class ParentMenuResponseDTO implements Serializable {
    private Long parentMenuId;
    private String parentMenuName;
    private String status;
    private String organizationName;
}