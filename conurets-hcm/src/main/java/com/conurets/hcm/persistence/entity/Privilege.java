package com.conurets.hcm.persistence.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author MSA
 * @version 1.0
 */

@Data
@Entity
@Table(name = "hcm_privileges")
@EqualsAndHashCode(callSuper = false)
public class Privilege extends BaseEntity {
    @Column(name = "str_name", length = 50)
    private String privilegeName;

    @Column(name = "str_description", length = 200)
    private String privilegeDescription;

    @Column(name = "bol_page")
    private Boolean page;
}
