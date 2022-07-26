package com.conurets.hcm.persistence.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

/**
 * @author MSA
 * @version 1.0
 */

@Data
@Entity
@Table(name = "hcm_menus")
@EqualsAndHashCode(callSuper = false)
public class Menu extends BaseEntity {
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_organization")
    private Organization organization;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_privilege")
    private Privilege privilege;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_parent_menu")
    private Menu parentMenu;

    @Column(name = "str_menu_name", length = 80)
    private String menuName;

    @Column(name = "str_menu_icon", length = 20)
    private String menuIcon;

    @Column(name = "str_menu_css_class", length = 30)
    private String menuCssClass;

    @Column(name = "str_menu_href", length = 20)
    private String menuHref;

    @Column(name = "str_menu_type", length = 20)
    private String menuType;

    @Column(name = "int_menu_sequence")
    private Integer menuSequence;
}
