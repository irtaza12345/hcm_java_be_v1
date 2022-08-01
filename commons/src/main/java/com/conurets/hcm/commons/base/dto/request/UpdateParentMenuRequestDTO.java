package com.conurets.hcm.commons.base.dto.request;

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
public class UpdateParentMenuRequestDTO extends BaseRequestDTO {
    private Long parentMenuId;
    @NotEmpty(message = "Join date must not be empty")
    @Size(min = 1, max = 80, message = "Join date must have valid format")
    private String parentMenuName;
    @NotEmpty(message = "Join date must not be empty")
    @Size(min = 1, max = 80, message = "Join date must have valid format")
    private String parentMenuIcon;
    @NotEmpty(message = "Join date must not be empty")
    @Size(min = 1, max = 80, message = "Join date must have valid format")
    private String parentMenuCssClass;
    @NotEmpty(message = "Join date must not be empty")
    @Size(min = 1, max = 80, message = "Join date must have valid format")
    private String parentMenuHref;
    private Integer parentMenuSequence;
    private Integer status;
}