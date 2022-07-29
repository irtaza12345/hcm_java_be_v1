package com.conurets.hcm.commons.persistence.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

/**
 * @author MSA
 * @version 1.0
 */

@Data
@Entity
@Table(name = "hcm_departments")
@EqualsAndHashCode(callSuper = false)
public class Department extends BaseEntity {
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_organization", nullable = false)
    private Organization organization;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_branch", nullable = false)
    private Branch branch;

    @Column(name = "str_department_code", nullable = false, length = 20)
    private String departmentCode;

    @Column(name = "str_department_name", nullable = false, length = 80)
    private String departmentName;
}