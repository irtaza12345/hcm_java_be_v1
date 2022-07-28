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
@Table(name = "hcm_countries")
@EqualsAndHashCode(callSuper = false)
public class Country extends BaseEntity {
    @Column(name = "str_name", nullable = false, length = 50)
    private String countryName;

    @Column(name = "str_code", nullable = false, length = 10)
    private String countryCode;
}
