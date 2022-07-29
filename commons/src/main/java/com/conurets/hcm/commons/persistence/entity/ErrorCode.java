package com.conurets.hcm.commons.persistence.entity;

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
@Table(name = "hcm_error_codes")
@EqualsAndHashCode(callSuper = false)
public class ErrorCode extends BaseEntity {
    @Column(name = "int_error_code", nullable = false, length = 5)
    private Integer errorCode;

    @Column(name = "str_error_level", nullable = false, length = 80)
    private String errorLevel;

    @Column(name = "str_information", nullable = false, length = 200)
    private String information;
}