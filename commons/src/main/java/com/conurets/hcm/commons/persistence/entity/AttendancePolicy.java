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
@Table(name = "hcm_attendance_policy")
@EqualsAndHashCode(callSuper = false)
public class AttendancePolicy extends BaseEntity {
    @Column(name = "str_enroll_number", length = 80)
    private String enrollNumber;

    @Column(name = "bol_partially")
    private Boolean partially;
}
