package com.conurets.hcm.commons.persistence.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @author MSA
 * @version 1.0
 */

@Data
@Entity
@Table(name = "hcm_persistent_logins")
@EqualsAndHashCode(callSuper = false)
public class PersistentLogin extends BaseEntity {
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_user", nullable = false)
    private User user;

    @Column(name = "str_type", length = 20)
    private String type;

    @Column(name = "str_origin", nullable = false, length = 20)
    private String origin;

    @Column(name = "dat_logon")
    private Timestamp logOn;

    @Column(name = "dat_logoff")
    private Timestamp logOff;

    @Column(name = "dat_last_used")
    private Timestamp lastUsed;
}
