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
@Table(name = "hcm_roles")
@EqualsAndHashCode(callSuper = false)
public class Role extends BaseEntity {
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_organization", nullable = false)
    private Organization organization;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_branch", nullable = true)
    private Branch branch;

    @Column(name = "str_name", length = 50)
    private String roleName;

    @Column(name = "str_description", length = 200)
    private String roleDescription;
}
