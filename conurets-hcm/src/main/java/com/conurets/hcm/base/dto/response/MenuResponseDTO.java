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
public class MenuResponseDTO implements Serializable {
    private Long parentMenuId;
    private String parentMenuName;
    private Long menuId;
    private String menuName;
    private String menuIcon;
    private String menuCssClass;
    private String menuHref;
    private String menuType;
    private Integer menuSequence;
    private String status;
}