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
@Table(name = "hcm_user_logins")
@EqualsAndHashCode(callSuper = false)
public class UserLogin extends BaseEntity {
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_user", nullable = false)
    private User user;

    @Column(name = "str_credential", nullable = false, length = 100)
    private String credential;

    @Column(name = "int_wrong_credentials", nullable = true, length = 2)
    private Integer wrongCount;
}
