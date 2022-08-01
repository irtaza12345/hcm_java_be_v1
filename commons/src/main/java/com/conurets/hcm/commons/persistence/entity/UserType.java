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
@Table(name = "hcm_user_types")
@EqualsAndHashCode(callSuper = false)
public class UserType extends BaseEntity {
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_organization", nullable = false)
    private Organization organization;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_branch", nullable = true)
    private Branch branch;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_role", nullable = true)
    private Role role;

    @Column(name = "str_name", nullable = false, length = 80)
    private String name;

    @Column(name = "str_description", nullable = false, length = 200)
    private String description;

    @Column(name = "bol_system_user", nullable = false)
    private Boolean systemUser;

    @Column(name = "bol_internal_user", nullable = false)
    private Boolean internalUser;

    @Column(name = "bol_super_user", nullable = false)
    private Boolean superUser;

    @Column(name = "bol_read_only", nullable = false)
    private Boolean readOnly;

    @Column(name = "bol_organization_admin", nullable = false)
    private Boolean organizationAdmin;

    @Column(name = "bol_branch_admin", nullable = false)
    private Boolean branchAdmin;
}
