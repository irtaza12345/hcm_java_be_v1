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
@Table(name = "hcm_states")
@EqualsAndHashCode(callSuper = false)
public class State extends BaseEntity {
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_country")
    private Country country;

    @Column(name = "str_name", nullable = false, length = 50)
    private String stateName;

    @Column(name = "str_code", nullable = false, length = 10)
    private String stateCode;
}
