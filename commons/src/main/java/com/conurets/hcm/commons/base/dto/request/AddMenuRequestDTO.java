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
public class AddMenuRequestDTO extends BaseRequestDTO {
    private Long privilegeId;
    private Long parentMenuId;
    @NotEmpty(message = "Join date must not be empty")
    @Size(min = 1, max = 80, message = "Join date must have valid format")
    private String menuName;
    @NotEmpty(message = "Join date must not be empty")
    @Size(min = 1, max = 80, message = "Join date must have valid format")
    private String menuIcon;
    @NotEmpty(message = "Join date must not be empty")
    @Size(min = 1, max = 80, message = "Join date must have valid format")
    private String menuCssClass;
    @NotEmpty(message = "Join date must not be empty")
    @Size(min = 1, max = 80, message = "Join date must have valid format")
    private String menuHref;
    private String menuType;
    private Integer menuSequence;
    private Integer status;
}