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
@Table(name = "hcm_cities")
@EqualsAndHashCode(callSuper = false)
public class City extends BaseEntity {
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_state")
    private State state;

    @Column(name = "str_name", nullable = false, length = 50)
    private String cityName;

    @Column(name = "str_code", nullable = false, length = 10)
    private String cityCode;
}
