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
@Table(name = "hcm_role_privileges")
@EqualsAndHashCode(callSuper = false)
public class RolePrivilege extends BaseEntity {
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_organization", nullable = false)
    private Organization organization;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_branch", nullable = true)
    private Branch branch;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_role")
    private Role role;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_privilege")
    private Privilege privilege;
}
