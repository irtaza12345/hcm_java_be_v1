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
@Table(name = "hcm_preferences")
@EqualsAndHashCode(callSuper = false)
public class Preference extends BaseEntity {
    @ManyToOne(fetch = FetchType.EAGER, optional = true)
    @JoinColumn(name = "id_organization", nullable = true)
    private Organization organization;

    @ManyToOne(fetch = FetchType.EAGER, optional = true)
    @JoinColumn(name = "id_branch", nullable = true)
    private Branch branch;

    @Column(name = "str_name", nullable = false, length = 50)
    private String name;

    @Column(name = "str_value", nullable = false, length = 200)
    private String value;

    @Column(name = "str_description", nullable = false, length = 200)
    private String description;
}
