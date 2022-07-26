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
@Table(name = "hcm_users")
@EqualsAndHashCode(callSuper = false)
public class User extends BaseEntity {
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_organization", nullable = false)
    private Organization organization;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_user_type", nullable = true)
    private UserType userType;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_department", nullable = false)
    private Department department;

    @Column(name = "str_first_name", nullable = false, length = 80)
    private String firstName;

    @Column(name = "str_last_name", nullable = false, length = 80)
    private String lastName;

    @Column(name = "str_email_address", nullable = false, length = 80)
    private String emailAddress;

    @Column(name = "str_mobile_number", nullable = false, length = 20)
    private String mobileNumber;

    @Column(name = "str_designation", nullable = true, length = 50)
    private String designation;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_country", nullable = true)
    private Country country;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_state", nullable = true)
    private State state;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_city", nullable = true)
    private City city;
}
