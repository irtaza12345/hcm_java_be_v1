package com.conurets.hcm.persistence.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author MSA
 * @version 1.0
 */

@Data
@Entity
@Table(name = "hcm_lookup_queries")
@EqualsAndHashCode(callSuper = false)
public class LookupQuery extends BaseEntity {
    @Column(name = "str_query_name", nullable = false, length = 100, unique = true)
    private String queryName;

    @Column(name = "str_query", nullable = false, length = 2048)
    private String query;
}
