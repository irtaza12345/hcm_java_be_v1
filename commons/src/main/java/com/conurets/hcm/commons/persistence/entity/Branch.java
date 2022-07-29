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
@Table(name = "hcm_branches")
@EqualsAndHashCode(callSuper = false)
public class Branch extends BaseEntity {
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_organization", nullable = false)
    private Organization organization;

    @Column(name = "str_name", nullable = false, length = 80)
    private String name;

    @Column(name = "str_branch_code", nullable = false, length = 20)
    private String branchCode;

    @Column(name = "str_address", nullable = false, length = 200)
    private String address;

    @Column(name = "str_phone_1", nullable = false, length = 20)
    private String phoneNumber1;

    @Column(name = "str_phone_2", length = 20)
    private String phoneNumber2;

    @Column(name = "str_email", nullable = true, length = 50)
    private String emailAddress;

    @Column(name = "str_postal_address", length = 20)
    private String postalCode;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_country", nullable = true)
    private Country country;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_state", nullable = true)
    private State state;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_city", nullable = true)
    private City city;

    @Column(name = "str_region", nullable = true)
    private String region;
}
