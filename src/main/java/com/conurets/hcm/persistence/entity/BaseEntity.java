package com.conurets.hcm.persistence.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author MSA
 * @version 1.0
 */

@Data
@MappedSuperclass
@EqualsAndHashCode(callSuper = false)
public class BaseEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "int_status", nullable = false, length = 2)
    private Integer status;

    @Column(name = "dat_created_date", updatable = false)
    private Timestamp createdDate;

    @Column(name = "int_created_by", updatable = false)
    private Long createdBy;

    @Column(name = "dat_modified_date", insertable = false)
    private Timestamp lastUpdate;

    @Column(name = "int_modified_by", insertable = false)
    private Long lastUpdateBy;
}
